package com.byhi.urlsortener;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.byhi.urlsortener.MiniUrlWebAppApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MiniUrlWebAppApplication.class)
@ContextConfiguration(classes = { MiniUrlWebAppApplication.class })
@TestPropertySource("classpath:test.properties")
public class MiniUrlWebAppApplicationTests {

	@Test
	public void contextLoads() {
		 assertTrue(true);
	}

}
