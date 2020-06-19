package com.flipkart.exceptions;

@SuppressWarnings("serial")
public class UsernameNotAvailableException extends Exception{

	String username;
	public UsernameNotAvailableException(String username){
		this.username=username;
	}
	
	public String getMessage()
	{
		return	"Username not Available";
	}
	
	
}
