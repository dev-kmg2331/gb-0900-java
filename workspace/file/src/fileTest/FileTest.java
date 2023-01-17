package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException{
		
//		절대 경로 : 어디에서 작성해도 찾아갈 수 있는 경로, C:/a/b 
//		상대 경로 : 현재 위치에 따라 변경되는 경로, ../a/b
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("./src/test.txt", true));
//		bw.write("안녕!\n");
//		bw.close();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("./src/test2.txt"));
			
			String line = "";
			
//		줄바꿈 없음 println때문임
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("없는 파일.");
		} finally {
			if(br != null) {
				br.close();
			}
		}
		
//		성능 저하 및 다양한 결함이 발생하여, 9버전 이후 부터는 사용하지 말고 close()를 쓰자!
//		System.gc();
//		System.runFinalization();
		
//		File file = new File("./src/test.txt");
//		if(file.exists()) {
//			file.delete();
//		}
	}
}
