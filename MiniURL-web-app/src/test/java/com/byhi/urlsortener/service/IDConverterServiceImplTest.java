package com.byhi.urlsortener.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.byhi.urlsortener.MiniUrlWebAppApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MiniUrlWebAppApplication.class })
public class IDConverterServiceImplTest {

	@Test
	public void getDictionaryKeyFromUniqueID() {
		Long uniqueID = IDConverterServiceImpl.INSTANCE.getDictionaryKeyFromUniqueID("a");
		assertEquals(new Long(0), uniqueID);
	}

	@Test
	public void createUniqueID() {
		String uniqueID = IDConverterServiceImpl.INSTANCE.createUniqueID((long) 10);
		assertEquals('k', uniqueID);
	}
}
