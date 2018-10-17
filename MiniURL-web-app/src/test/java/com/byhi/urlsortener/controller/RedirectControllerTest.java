package com.byhi.urlsortener.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.byhi.urlsortener.controller.RedirectController;
import com.byhi.urlsortener.domain.Longurl;
import com.byhi.urlsortener.domain.ShortUrl;
import com.byhi.urlsortener.repository.LongUrlRepository;
import com.byhi.urlsortener.repository.ShortUrlReposiroty;
import com.byhi.urlsortener.service.ShortUrlServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(RedirectController.class)
@AutoConfigureMockMvc(secure=false)
@ContextConfiguration(classes={MiniUrlWebAppApplication.class})
public class RedirectControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	 @MockBean
	private LongUrlRepository longUrlRepository;
	
	 @MockBean
	private ShortUrlServiceImpl shortUrlService;


    @MockBean
    private ShortUrlReposiroty shortUrlReposiroty;
   
    
    @Test
    public void testList() throws Exception {
    	String url = "https://www.baeldung.com/spring-boot-testing";
    	String shorturlvalus = "test.b";
    	Longurl longurl = new Longurl(url);
    	
    	longUrlRepository.save(longurl);
    	ShortUrl shorturl = new ShortUrl(shorturlvalus);
    	shortUrlReposiroty.save(shorturl) ;
    	shorturl.setLongUrl(longurl);
    	shortUrlReposiroty.save(shorturl) ;
        
    	
    assertThat(this.shortUrlService).isNotNull();
      mockMvc.perform(MockMvcRequestBuilders.get("/{url}", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.view().name("index"));
      
      mockMvc.perform(MockMvcRequestBuilders.get("/{url}", "asdasd"))
      .andExpect(MockMvcResultMatchers.status().is(404));
      

    }
}
