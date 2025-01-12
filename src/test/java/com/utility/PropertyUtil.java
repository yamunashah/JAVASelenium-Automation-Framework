package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertyUtil {

	public static String ReadProperty(Env env, String PropertyName) {
		
		File file= new File(System.getProperty("user.dir")+"/com.properties/QA.properties");
		FileReader fileReader = null;
		
		try {
			fileReader= new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Properties propertyReader = new Properties();
		try {
			propertyReader.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String Value=propertyReader.getProperty(PropertyName);
		return Value;
		
	}
}
