package jsonTest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONWork {
	public static void main(String[] args) throws JSONException {
//		상품 클래스 선언(상품 번호, 상품 이름, 상품 가격, 상품 재고)
		Product pr = new Product(1, 10000, 50, "모종삽");
		Product pr2 = null;
		
//		1. 상품 1개를 제작하여 JSON형식으로 변경
		JSONObject prJSON = new JSONObject(pr);
		System.out.println(prJSON);
		JSONObject pr2JSON = null;
		JSONObject productInfo = new JSONObject();
		
//		2. JSON형식의 상품 정보 중 상품 재고 출력
		System.out.println(prJSON.get("quantity"));
		
//		3. 할인 중인 상품 정보 제작
		pr2 = new Product(2, 8000, 30, "화분");
		
//		4. 할인 중인 상품의 KEY 값은 "discount"로 설정
//		5. JSON 형식으로 변경
		pr2JSON = new JSONObject(pr2);
		
//		6. JSON에 할인율 필드 추가 
		pr2JSON.put("discount", 0.8);
//		System.out.println(pr2JSON);
//		System.out.println("================");
//		System.out.println(pr2);
		
//		7. JSON 형식의 상품 정보 중 할인율 출력
		System.out.println(pr2JSON.get("discount"));
		
//		productInfo.put((String) prJSON.get("name"), prJSON);
//		productInfo.put((String) pr2JSON.get("name"), pr2JSON);
		
		System.out.println(productInfo);
		
		JSONArray products = new JSONArray();
		products.put(prJSON);
		products.put(pr2JSON);
		
		System.out.println(products);
		System.out.println(products.getJSONObject(0));
	}
}
