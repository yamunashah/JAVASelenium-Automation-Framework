package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVDataUtility {

	@DataProvider(name = "TestUserCSVData")
	public static Iterator<User> readCSVData(String Filename) {
		
		File file = new File(System.getProperty("user.dir")+"/TestData/"+ Filename);
		
		FileReader filereader = null;
		CSVReader csvreader;
		String[] line;
		List<User> userList = null;
		try {
			filereader = new FileReader(file);
			csvreader= new CSVReader(filereader);
			csvreader.readNext();
			userList = new ArrayList<User>();
			User userData;
			while((line=csvreader.readNext())!= null){
					userData = new User(line[0],line[1]);	
					userList.add(userData);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
	}
}
