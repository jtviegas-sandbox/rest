package com.ibm.ie.iem.apaa.rest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;

import com.ibm.ie.iem.apaa.model.Task;
import com.ibm.ie.iem.apaa.persistence.services.TaskService;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("/tasks")
public class Tasks {

	@Autowired
	private TaskService taskService;

	protected TaskService getService() {
		if (null == this.taskService) {
			this.taskService = (TaskService) ContextLoader.getCurrentWebApplicationContext().getBean("taskService");
		}

		return this.taskService;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test")
	public Task getTest() {
		Task o = new Task("dothingz", "198.162.1.1");
		o.setId("54596cd8c830485b01c31cc7");

		return o;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Task postTask(Task note) {
		return getService().save(note);
	}

	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Task getTask(@PathParam("id") String id) {
		Task o = getService().findOne(id);
		return o;
	}

	@DELETE
	@Path("/delete/{id}")
	public void deleteTask(@PathParam("id") String id) {
		getService().delete(id);
	}

	@DELETE
	@Path("/delete/all")
	public void deleteAllTasks() {
		getService().deleteAll();
		;
	}

	@GET
	@Produces("application/json")
	@Path("/all")
	public List<Task> getAllTasks() {
		List<Task> result = new LinkedList<Task>();
		Iterator<Task> iterator = getService().findAll().iterator();
		while (iterator.hasNext())
			result.add(iterator.next());

		return result;
	}

}
