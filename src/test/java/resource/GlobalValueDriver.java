package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValueDriver {
	
	public String baseURL;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GlobalValueDriver gd = new GlobalValueDriver();
		
		Properties prop = new Properties();
		 String currentDirectory = System.getProperty("user.dir");
		 System.out.println(currentDirectory);
		FileInputStream fis = new FileInputStream(currentDirectory+ "\\global.properties");
		prop.load(fis);
		gd.baseURL = prop.getProperty("baseURL");

	}

}
