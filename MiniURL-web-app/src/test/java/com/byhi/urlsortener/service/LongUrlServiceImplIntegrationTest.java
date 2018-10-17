package com.byhi.urlsortener.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.byhi.urlsortener.MiniUrlWebAppApplication;
import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.repository.LongUrlRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MiniUrlWebAppApplication.class })
@TestPropertySource("classpath:test.properties")
public class LongUrlServiceImplIntegrationTest {

	@TestConfiguration
	static class LongUrlImplTestContextConfiguration {

		@Bean
		public LongUrlService employeeService() {
			return new LongUrlServiceImpl();
		}
	}

	@Autowired
	private LongUrlService longUrlService;


	@MockBean
	private LongUrlRepository longUrlRepository;

	@Before
	public void setUp() {
		Longurl url1 = new Longurl("https://www.baeldung.com/spring-boot-testing");

		Mockito.when(longUrlRepository.findByUrl(url1.getOriginalurl())).thenReturn(url1);
	}

	@Test
	public void isURLExistTest() {
		String urlpath = "https://www.baeldung.com/spring-boot-testing";
		String urlpath2 = "https://www.baeldung.com/s";
		boolean isExist = longUrlService.isURLExist(urlpath);
		boolean isExist2 = longUrlService.isURLExist(urlpath2);

		assertEquals(true, isExist);
		assertEquals(false, isExist2);
	}

	@Test
	public void getLongurlByURLTest() {
		String url = "https://www.baeldung.com/spring-boot-testing";
		Longurl url2 = longUrlService.getLongurlByURL(url);

		assertThat(url2.getOriginalurl()).isEqualTo(url);
	}
}
