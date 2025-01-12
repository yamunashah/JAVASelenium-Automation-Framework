package com.ui.testdataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.Data;
import com.ui.pojo.User;
import com.utility.CSVDataUtility;
import com.utility.ExcelDataUtility;

public class TestDataProvider {
	
	
	@DataProvider(name = "TestUserData")
	public Iterator<Object[]> readTestData()
	{
		Gson gson= new Gson();
		File testdatafile = new File(System.getProperty("user.dir")+"/TestData/UserData.json");
		FileReader readJsonfile = null;
		try {
			 readJsonfile = new FileReader(testdatafile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Data TestData = gson.fromJson(readJsonfile, Data.class);
		
		List<Object[]> userdata = new ArrayList<Object[]>();
		
		for (User user:TestData.getData())
		{
			userdata.add(new Object[] {user});
		}
		
		return userdata.iterator();
		
		
		
	}
	
	@DataProvider(name = "TestUserCSVData")
	public Iterator<User> readCSVData()
	{
		return CSVDataUtility.readCSVData("LoginData.csv");
	}
	
//	@DataProvider(name = "TestUserExcelData")
//	public Iterator<User> readExcelData()
//	{
//		return ExcelDataUtility.readExcelSheet("LoginExcelData.xlsx");
//	}
	
}
