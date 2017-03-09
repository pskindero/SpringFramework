package com.pskindero.spring.rest_boot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pskindero.spring.rest_boot.dbs.StubDb;
import com.pskindero.spring.rest_boot.domain.Book;
import com.pskindero.spring.rest_boot.services.BooksService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BooksControllerMvcTest {

	private MockMvc mockMvc;

	@Autowired
	public WebApplicationContext ctx;
	
	@Autowired
	public BooksService booksService;
	
	@Autowired
	public StubDb<Book> db;
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void getAllBooks() throws Exception {
		mockMvc.perform(get("/books"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			//.andExpect()
			.andDo(MockMvcResultHandlers.print());
	}
}