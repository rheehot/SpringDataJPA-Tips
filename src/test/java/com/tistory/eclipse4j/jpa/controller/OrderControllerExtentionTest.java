package com.tistory.eclipse4j.jpa.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.tistory.eclipse4j.jpa.entity.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * Started - Spring boot Application
 */
@Slf4j
public class OrderControllerExtentionTest {

	@Test
	public void createClient() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/orders/").path("1").path("/products/").path("3")
				.path("/update-tx").queryParam("ms", 0);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		Order order = response.readEntity(Order.class);
		log.info("[ORDER] Order={}", order);
	}
}
