//These is not related with database, just like these it is there.

//Here is an implementation of myresource . Same we are requesting via url and getting displayed here.
//Here first request from index.jsp is going to container(Servlet Container in this case)then it is trying to search myresource and when it is getting that then it is implemented.
package com.telusko.demorest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource") //Here it will redirect. Means it will find myresource here then these down code will executed.
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	 	@GET //way for getting a request.
	 	@Produces(MediaType.TEXT_PLAIN)
	    public String getMsg()
	    {
	         return "Hello World !! - Jersey 2";
	    }
}

