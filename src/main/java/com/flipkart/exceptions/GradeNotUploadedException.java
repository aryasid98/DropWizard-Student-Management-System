package com.flipkart.exceptions;

public class GradeNotUploadedException extends Exception{
	
	public void GradeNotFoundException(){
		
	}
	
	public String getMessage()
	{
		return	"Wrong Student Id or Course Id to Upload Grade";
	}
	
}
