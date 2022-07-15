package lecture0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardInput {
	public static void main(String[] args) {
		System.out.println("키보드로 한줄을 입력하세요!");
		
		// 키보드(표준입력.System.in)을 통해 데이터 1줄 입력받을거예요!
		// 이 System.in이라는 제공된 Stream 사용하기 너무 힘들다.
		InputStreamReader ist = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ist);
		try {
			String input = br.readLine();	
			System.out.println("입력받은 문자열 : " + input);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
/* 
키보드로 한줄을 입력하세요!
소리없는 아우성!
입력받은 문자열 : 소리없는 아우성
 */
