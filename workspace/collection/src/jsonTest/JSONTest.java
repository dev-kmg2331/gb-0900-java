package jsonTest;

import java.util.HashMap;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTest {
	public static void main(String[] args) {
		User user = new User(1, 25, "kmg2331", "1234", "강민구");
		
		JSONObject userJSON = new JSONObject(user);
		JSONParser parser = new JSONParser();
		
		System.out.println(userJSON);
		
		try {
			HashMap<String, Object> result = (HashMap)parser.parse(userJSON.toString());
			System.out.println(result.get("id"));
			System.out.println(result.get("name"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
