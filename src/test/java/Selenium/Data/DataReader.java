package Selenium.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//read json to string
		
		String jsonToString=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"SeleniumFrameWork\\src\\test\\java\\Selenium\\Data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		
		//string to hashmap(jackson databind)
		
		ObjectMapper map=new ObjectMapper();
		List<HashMap<String,String>> data=map.readValue(jsonToString, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	
	
}
