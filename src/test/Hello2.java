package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello2")
public class Hello2 {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello() {
		String resource = "<?xml version='1.0' ?>" + 
						  "<hello>Hi Sophie, This is Hello from XML</hello>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJASON() {
		String resource = null;
		return resource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML(@QueryParam("name") String name, 
							@QueryParam("Card_no") String Card_no,
							@QueryParam("amount") int amount) {
		
		System.out.println("Name is "+name);
		System.out.println("Amount is "+String.valueOf(amount));
		String response;
		
		if(amount>100000) {
			System.out.println("Amount is Greater than 100000");
			response = "Credit Card is not approved";
		} else {
			System.out.println("Amount is Lesser than 100000");
			response = "Credit Card is approved";
		}
		
		return "<html><title>Credit Card Authorization</title><body><h1>" + 
				response + 
				"</h1></body></html>";
	}
}
