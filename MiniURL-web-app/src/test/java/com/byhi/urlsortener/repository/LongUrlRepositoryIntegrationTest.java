package com.byhi.urlsortener.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.byhi.urlsortener.MiniUrlWebAppApplication;
import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.repository.LongUrlRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MiniUrlWebAppApplication.class })
@DataJpaTest
public class LongUrlRepositoryIntegrationTest {

	@Autowired
	private LongUrlRepository longUrlRepository;

	@Test
	public void whenFindByOriginalUrl_thenReturnLongurl() {
		Longurl url1 = new Longurl("https://www.baeldung.com/spring-boot-testing");
		longUrlRepository.save(url1);

		Longurl url2 = longUrlRepository.findByUrl(url1.getOriginalurl());

		assertThat(url2.getOriginalurl()).isEqualTo(url1.getOriginalurl());
	}

	@Test
	public void saveTest() {
		Longurl url1 = new Longurl("https://www.baeldung.com/spring-boot-testing");

		Longurl url2 = longUrlRepository.save(url1);
		assertNotEquals(null, url2);
		assertThat(url2.getOriginalurl()).isEqualTo(url1.getOriginalurl());
	}
}
