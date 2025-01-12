package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelDataUtility {

//	public static Iterator<User> readExcelSheet(String filename){
	public static void main(String[] args) {
		File xlsxfile = new File(System.getProperty("user.dir")+"/TestData/LoginExcelData.xlsx");
		XSSFWorkbook xssfbook = null;
		XSSFSheet excelsheet;
		List<User> userList;
		Iterator<Row> rowIterator;
		Cell emailAddress;
		Cell password;
		User userData;
		Row row;
		try {
			xssfbook= new XSSFWorkbook(xlsxfile);
			excelsheet= xssfbook.getSheet("LoginExcelData");
			userList= new ArrayList<User>();
			rowIterator = excelsheet.iterator();
			rowIterator.next();
			while(rowIterator.hasNext())
			{
				row=rowIterator.next();
				emailAddress=row.getCell(0);
				password=row.getCell(1);
				userData = new User(emailAddress.toString(),password.toString());
				userList.add(userData);
//				System.out.println(emailAddress.toString() + " " + password.toString());
				xssfbook.close();
			}
			System.out.println(userList);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return userList.iterator();
	}

}
