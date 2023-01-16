package jsonTest;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONTask {
	public static void main(String[] args) {
		User user = new User(1, 25, "kmg233", "1234", "강민구");
		
		JSONObject userJSON = new JSONObject(user);
		JSONObject infoJSON = new JSONObject();
		
		JSONParser parser = new JSONParser();
		
		try {
			infoJSON.put("userInfo", userJSON);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(infoJSON);
		
		try {
			System.out.println(infoJSON.getJSONObject("userInfo").get("number"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
