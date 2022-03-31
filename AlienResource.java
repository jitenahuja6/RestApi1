//These is for performing all the operation in the client end (like we have database but this for client)

package com.telusko.demorest;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens") // These means whenever this path will be called down line code should get execute.
public class AlienResource {
	
	AlienRepository repo = new AlienRepository(); //Creating an object of database class.

	@GET //Get we are using to get the resource and down one Produces we have to use if we are using Get.
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) //Which type we are using we have to specify here. Produces means result will come in which form xml or json.
	public List<Alien> getAliens()
	{
		System.out.println("get alien called");
		return repo.getAliens(); //As repo is an object of AlienRepository, so with that we are calling getAliens() method to declare all fields inside database.
		
	}
	
	@GET //Get we are using to get the resource and down one Produces we have to use if we are using Get.
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien getAlien2(@PathParam("id") int id)  //IF we are dealing with one particular id then we are using these.
	{
		
		System.out.println("Alien called with particular id "+id);
		return repo.getAlien(id);
		
	}
	
	
	//Post we are using to put data into database.
	@POST
	@Path("alien")
	@Consumes(MediaType.APPLICATION_XML) //consumes means in which form you want to send data.
	public Alien createAlien(Alien a1)
	{
		
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	

	//These we are using for updating the value in the database. Here if  need to understand , rest its ok, as per me if is for ->it describe the value  if it is not there then what to do.
	@PUT
	@Path("alien")
	@Consumes(MediaType.APPLICATION_XML)
	public Alien updateAlien(Alien a1)
	{
		
		System.out.println(a1);
		if(repo.getAlien(a1.getId()).getId()==0) //These we are using if id is not there then it will create the id,
		{
			System.out.println("checking if for put working");
			repo.create(a1);
		}
		else
		{
			
		
		System.out.println("Checking put working");
		repo.update(a1); //calling the update method define in AlienRepository.
		}
		return a1;
	}
	
	@DELETE //These we are using to delete id.
	@Path("alien/{id}") //giving /alien/id in url then only it will work.
	public Alien killAlien(@PathParam("id") int id) //If we are dealing with one particular id then we are using @PathParam.
	{
		Alien a = repo.getAlien(id);
		if(a.getId()!=0)
			repo.delete(id);
		return a;
		
		
	}
}
