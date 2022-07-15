package lecture0715;

import java.io.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ObjectStreamTest {
	/* 객체 형태 그대로 데이터 주고받기, 객체 Stream */
	public static void main(String[] args) {
		Map<String, String> map =
				new HashMap<String, String>();
		map.put("1", "아이유");
		map.put("2", "홍길동");
		map.put("3", "김연아");
		
		File file = new File("C:/Users/user/Desktop/readme.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file); // 파일이 없으면 파일을 만들어줌..
											  // FileOutputStream은 객체 전달 능력X
			  								  // FileOutputStream 자체로 사용할 수 없음!
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
