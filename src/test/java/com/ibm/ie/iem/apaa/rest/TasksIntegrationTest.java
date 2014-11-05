package com.ibm.ie.iem.apaa.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.junit.Assert;
import org.junit.Test;

import com.ibm.ie.iem.apaa.model.Task;

public class TasksIntegrationTest {

	private static final String URL = "http://localhost:9080/rest-1.0-SNAPSHOT";

	@Test
	public void testQuotesTest() throws Exception {

		// Read more:
		// http://mrbool.com/how-to-use-rest-service-with-websphere-8-5-application-server-and-send-json-data/27999#ixzz3HzxEzPYJ
		// and ->
		// http://webstar.company/2014/02/testing-the-jax-rs-restful-web-service-2/

		Task expected = new Task("dothingz", "198.162.1.1");
		expected.setId("54596cd8c830485b01c31cc7");

		Client client = ClientBuilder.newBuilder().register(JacksonJaxbJsonProvider.class).build();
		WebTarget target = client.target(URL + "/tasks/test");
		Response response = target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get();
		
		Task actual = response.readEntity(Task.class);
		Assert.assertEquals(expected, actual);

	}

	/*
	 * @Test public void testQuotesTest() throws Exception {
	 * 
	 * try { ClientRequest request = new ClientRequest(URL + "/test");
	 * request.accept("application/json"); ClientResponse<Task> response =
	 * request.get(Task.class);
	 * 
	 * if (response.getStatus() != 200) { throw new
	 * RuntimeException("Failed : HTTP error code : " + response.getStatus()); }
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	/*
	 * @Test public void testQuotesTest() throws Exception {
	 * 
	 * try { ResteasyClient client = new ResteasyClientBuilder().build();
	 * ResteasyWebTarget target = client.target( URL + "/test");
	 * 
	 * ClientResponse response = (ClientResponse) target.request().get(); Task
	 * task = response.readEntity(Task.class); Assert.assertNotNull(task); }
	 * catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test public void testTaskPost() throws Exception {
	 * 
	 * Task received = null; Task task = new Task("dosomethingz",
	 * "192.168.1.1"); task.setId(new ObjectId().toString());
	 * 
	 * ResteasyClient client = new ResteasyClientBuilder().build();
	 * ResteasyWebTarget target = client.target( URL + "/add");
	 * 
	 * ClientResponse response = (ClientResponse)
	 * target.request().post(Entity.entity(task, MediaType.APPLICATION_JSON));
	 * 
	 * if (response.getStatus() != 200) throw new
	 * RuntimeException("Failed : HTTP error code : " + response.getStatus() +
	 * " | " + response.getStatusInfo());
	 * 
	 * received = response.readEntity(Task.class);
	 * 
	 * Assert.assertEquals(" Author not equal", received.getName(),
	 * task.getName() ); Assert.assertEquals(" Text not equal",
	 * received.getHost(), task.getHost() );
	 * 
	 * response.close(); }
	 * 
	 * @Test public void testTaskCount() throws Exception {
	 * 
	 * 
	 * ResteasyClient client = new ResteasyClientBuilder().build();
	 * 
	 * ResteasyWebTarget target = client.target( URL + "/all"); ClientResponse
	 * response = (ClientResponse) target.request().get(); List<Task> tasks =
	 * response.readEntity(new GenericType<List<Task>>(){});
	 * 
	 * int count1 = tasks.size();
	 * 
	 * Task task = new Task("dosomethingz", "192.168.1.1"); task.setId(new
	 * ObjectId().toString()); target = client.target( URL + "/add"); response =
	 * (ClientResponse) target.request().post(Entity.entity(task,
	 * MediaType.APPLICATION_JSON));
	 * 
	 * if (response.getStatus() != 200) throw new
	 * RuntimeException("Failed : HTTP error code : " + response.getStatus() +
	 * " | " + response.getStatusInfo());
	 * 
	 * target = client.target( URL + "/all"); response = (ClientResponse)
	 * target.request().get(); tasks = response.readEntity(new
	 * GenericType<List<Task>>(){});
	 * 
	 * int count2 = tasks.size();
	 * 
	 * Assert.assertEquals(count2, ++count1); response.close();
	 * 
	 * }
	 */

}
