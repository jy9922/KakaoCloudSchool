package lecture0715;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/* 객체스트림 */
public class ObjectInputStreamTest {
	public static void main(String[] args) {
		File file = new File("C:/Users/user/Desktop/readme.txt");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject(); //캐스팅
			
			Map<String,String> map = (Map<String,String>)obj;
			System.out.println(map.get("2")); // 키가 2인 값 가져오기
			
			ois.close();
			fis.close();
			
		}catch(Exception e) {
			
		}
	}
}
