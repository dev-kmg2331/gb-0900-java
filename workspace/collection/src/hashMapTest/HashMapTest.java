package hashMapTest;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		JSONObject userJSON = null;
		
		userMap.put("id", "kmg2331");
		userMap.put("pw", "1234");
		userMap.put("name", "강민구");
		userMap.put("age", 25);
		
		System.out.println(userMap);
		
		System.out.println(userMap.get("id"));
		
		userJSON = new JSONObject(userMap);
		
		System.out.println(userJSON);
	}
}
