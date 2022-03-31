//These class is for linking with the database, we are doing database configuration here.

package com.telusko.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class AlienRepository 
{
	//List<Alien> aliens;
	
	//These we are doing for creating the database connection.
	Connection con = null; 
	public AlienRepository() // need to understand why this line is coming in place.
	{
		String url = "jdbc:mysql://localhost:3306/restdatabase";  
		String username = "root";
		String password = "happy";
	
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver"); //These is used for loading the driver.
		con = DriverManager.getConnection(url,username,password);// creating the connection
		
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}}
	
	
	
	
	//These we are doing for getting all the values from the databases.
	public List<Alien> getAliens()
	{
		
		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from alien";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(sql);
			while(rs.next()) //we want everything which is in the database that is why we are using while loop.
			{
				Alien a = new Alien(); //Alien class we are having , we are creating here reference of Alien.
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return aliens;
	}
	
	
	//These we are doing for getting particular alien with particular id.
	public Alien getAlien(int id)
	{
		
		String sql = "select * from alien where id = "+id;
		Alien a = new Alien();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(sql);
			
			//These part have some doubt, seems like if we dont have particular id then what will happen.
			if(rs.next())
			{
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
	}
		return a;
	}

	
	
	//These for inserting the values into database.
	public void create(Alien a1) {
		
		String sql = "insert into alien values (?,?,?)";
		
		
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			//Statement st = con.createStatement();
		    
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
	}
	}
		
		
		
		
	//These for updating the value in the database.
	public void update(Alien a1) {
			
			String sql = "update alien set name = ?, points = ? where id = ?";
			
			
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				//Statement st = con.createStatement();
			    
				
				st.setString(1, a1.getName());
				st.setInt(2, a1.getPoints());
				st.setInt(3, a1.getId());
				st.executeUpdate();
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
		}
			
		
		
	}

		
	
	
	//These for deleting the value in the database with particular id.
	public void delete(int id) {
			
String sql = "delete from alien where id = ?";
			
			
			try
			{
				PreparedStatement st = con.prepareStatement(sql);
				//Statement st = con.createStatement();
			    
				
				st.setInt(1, id);
				st.executeUpdate();
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
		}
			
		}
	}

