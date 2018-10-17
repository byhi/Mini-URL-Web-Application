package com.byhi.urlsortener.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IDConverterServiceImplTest {

	@Test
	public void getDictionaryKeyFromUniqueID() {
		Long uniqueID = IDConverterServiceImpl.INSTANCE.getDictionaryKeyFromUniqueID("a");
		assertEquals(new Long(0), uniqueID);
	}

	@Test
	public void createUniqueID() {
		String uniqueID = IDConverterServiceImpl.INSTANCE.createUniqueID((long) 10);
		assertEquals("k", uniqueID);
	}
}
