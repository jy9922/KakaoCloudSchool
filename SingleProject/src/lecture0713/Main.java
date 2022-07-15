package lecture0713;

import java.util.HashMap;
import java.util.Map;

class Student{
	
}
public class Main {
	public static void main(String[] args) {
		// Map
		Map map = new HashMap<>();
		map.put("1", "홍길동");
		map.put("2" , "Hello");
		
		// Map generic
		Map<String,String> map1 = new HashMap<String, String>();
		map1.put("1", "홍길동1");
		map1.put("2", "홍길동2");
		
		// API reference를 참조해서 각 collection의 이용방법을 찾아서 써보아요
	}
}
