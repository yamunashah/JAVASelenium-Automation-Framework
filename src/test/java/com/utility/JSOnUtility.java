package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSOnUtility {
	
	public static Environment readJson(Env env)  {
		
		Gson gson= new Gson();
		File file = new File(System.getProperty("user.dir")+"/com.properties/config.json");
		FileReader filereader= null;
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(filereader, Config.class);
		Environment environment=config.getEnvironments().get("DEV");
		return environment;
		
	}
}
