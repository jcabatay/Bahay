package com.ascii274;

import com.ascii274.login.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BahayLoginServicesAppTest {

	@Autowired
	private UserController userController;

	@Autowired
	private MockMvc mvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception{

		this.mvc.perform( get ("/v1/test-message"))
				.andDo(print())
				.andExpect(status()
						.isOk())
				.andExpect(content().string(containsString("Hello, Bahay Login Services")));
	}

	@Test
	void contextLoads() throws Exception{
		assertThat(userController).isNotNull();
	}

}
