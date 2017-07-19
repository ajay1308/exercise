package com.lloyd.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * The Class TestSubscription.
 * 
 * Subscription test
 * 
 * @author Ajay
 */
@WebAppConfiguration
public class TestSubscription extends BaseApplicationTest {

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mock mvc. */
	private MockMvc mockMvc;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
	}

	/**
	 * Testform.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testform() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

		mockMvc.perform(get("/welcome")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"));

	}

	/**
	 * Test subscribe success.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testSubscribeSuccess() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/subscribe").param("name", "name").param("email", "email@email.com"))
				.andExpect(status().isOk()).andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute("message", equalTo("User successfully subscribed")));
	}

	/**
	 * Test subscribe failure.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testSubscribeFailure() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/subscribe").param("name", "name").param("email", "email")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute("message", equalTo("User not subscribed")));
	}

	/**
	 * Test subscribe name empty.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSubscribeName() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/subscribe").param("name", "").param("email", "email")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute("name", equalTo("Name is required field")));
	}

	/**
	 * Test subscribe email empty.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSubscribeEmail() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/subscribe").param("name", "name").param("email", "")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute("email", equalTo("Email is required field")));
	}

	/**
	 * Test subscribe empty input.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSubscribeEmpty() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		mockMvc.perform(post("/subscribe").param("name", "").param("email", "")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(model().attribute("email", equalTo("Email is required field")))
				.andExpect(model().attribute("name", equalTo("Name is required field")));
	}

}