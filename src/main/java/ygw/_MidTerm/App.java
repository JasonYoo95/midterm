package ygw._MidTerm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Enter the keyword you are looking for : ");
    	String word = scan.next();
    	
    	JSONParser jsonParser = new JSONParser();
    	JSONObject jsonObject = null;
    	FileReader fr = null;
		try {
			fr = new FileReader("./midterm.json");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			jsonObject = (JSONObject) jsonParser.parse(fr);
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	JSONArray infoArray = (JSONArray) jsonObject.get("poem");
    	
    	for (int i = 0; i < infoArray.size(); i++) {
			JSONObject itemObject = (JSONObject) infoArray.get(i);
			String temp = (String) itemObject.get("item");
			if(temp.contains(word)) {
				System.out.print("item "+i + ": ");
				System.out.println(temp);
			}
		}
    	
    }
}
