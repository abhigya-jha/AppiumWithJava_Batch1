package com.w2a.iOS.testCases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w2a.TestDataPOJO.Tech;
import com.w2a.TestDataPOJO.User;

public class ReadJson {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		File file= new File("./src/main/resources/testDataJson/TestData.json");
		
		ObjectMapper objectMapper= new ObjectMapper();
		User user=objectMapper.readValue(file, User.class);
		
		System.out.println("validUsername -> "+user.getValidUsername());
		System.out.println("validPassword -> "+user.getValidPassword());
		System.out.println("invalidUsername -> "+user.getInvalidUsername());
		System.out.println("invalidPassword -> "+user.getInvalidPassword());
		
		
		System.out.println("Tech-> "+user.Tech);
		
		for(Tech tech:user.getTech()) {
			System.out.println(tech.getUi());
			System.out.println(tech.getFramework());
		}
		
	}

}
