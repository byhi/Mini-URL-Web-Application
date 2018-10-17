package com.byhi.urlsortener.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.byhi.urlsortener.MiniUrlWebAppApplication;
import com.byhi.urlsortener.controller.ListController;
import com.byhi.urlsortener.service.UrlServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(ListController.class)
@AutoConfigureMockMvc(secure = false)
@ContextConfiguration(classes = { MiniUrlWebAppApplication.class })
public class ListControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UrlServiceImpl urlServiceImpl;

	@Test
	public void testList() throws Exception {
		assertThat(this.urlServiceImpl).isNotNull();
		mockMvc.perform(MockMvcRequestBuilders.get("/urllist")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("urllist"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("urls"))
				.andExpect(MockMvcResultMatchers.model().attribute("urls", Matchers.is(Matchers.empty())));

	}
}
