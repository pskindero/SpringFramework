package com.pskindero.spring.rest_boot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pskindero.spring.rest_boot.domain.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class BooksControllerMvcTest {

	private final MediaType[] SUPPORTED_MEDIA_TYPE = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON};
	
	private MockMvc mockMvc;

	@Autowired
	public WebApplicationContext ctx;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void getAllBooks_supportedFormats() throws Exception {
		for (MediaType MT : SUPPORTED_MEDIA_TYPE) {
			mockMvc.perform(get("/books").accept(MT))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MT + ";charset=UTF-8"))
				.andDo(MockMvcResultHandlers.print());
		}
	}
	
	@Test
	public void getBook_supportedFormats() throws Exception {
		for (MediaType MT : SUPPORTED_MEDIA_TYPE) {
			mockMvc.perform(get("/books/2").accept(MT))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MT + ";charset=UTF-8"))
				.andDo(MockMvcResultHandlers.print());
		}
	}
	
	@Test
	public void getBook_wrongId() throws Exception {
		for (MediaType MT : SUPPORTED_MEDIA_TYPE) {
			mockMvc.perform(get("/books/10").accept(MT))
				.andExpect(status().isNoContent())
				.andDo(MockMvcResultHandlers.print());
		}
	}
	
}