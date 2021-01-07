package com.employeeapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	public static final String TOKEN_ADMIN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsInNjb3BlcyI6IlJPTEVfQURNSU4iLCJpYXQiOjE2MDQ0NTk0ODMsImV4cCI6MTYwNDQ3NzQ4M30.uGFOxbhxAluPz7DXoJTjMtD_ibVrsu8yB8gt6yzpzos";

	@Test
	public void testFindEmployeeById() throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", TOKEN_ADMIN);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("employee/findById?id=2")
				.accept(MediaType.APPLICATION_JSON).headers(httpHeaders);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());

		String expected = "{\"id\":2,\"firstName\":\"John\",\"lastName\":\"Joseph\",\"mobile\":\"8144156266\",\"emailId\":\"jhon.joseph@xyz.com\",\"designation\":\".Net Developer\",\"address\":{\"empId\":2,\"street\":\"Saravanampatti\",\"city\":\"Coimbatore\",\"state\":\"Tamilnadu\",\"country\":\"India\"},\"assetList\":[]}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void deleteEmployee() throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", TOKEN_ADMIN);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("employee/deleteById?id=1")
				.accept(MediaType.APPLICATION_JSON).headers(httpHeaders);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"code\":\"200\",\"message\":\"Request completed sucessfully\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
