package fileTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	public static void main(String[] args) throws IOException {
		String[] games = {"배틀그라운드", "롤", "오버워치", "로스트아크","메이플스토리", "스타크래프트"};
		
//		배열로 출력하고 전체 내용을 가져와서 콘솔에 출력하기
		String fileSource = "./src/games.txt";
		String line = "", temp = "";
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter(fileSource));
		BufferedReader br = null;
//		
//		for(String s : games) {
//			bw.write(s + "\n");
//		}
//		
//		bw.close();
//		
//		try {
//			br = new BufferedReader(new FileReader(fileSource));
//			while((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("없는 파일.");
//		} finally {
//			if(br != null) {
//				br.close();
//			}
//		}
		
	String target = "로스트아크";
      
      try {
         br = new BufferedReader(new FileReader(fileSource));
         while((line = br.readLine()) != null) {
            if(line.equals(target)) {
               temp += "피파2002\n";
               continue;
            }
            temp += line + "\n";
         }
         
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileSource, false));
         bufferedWriter.write(temp);
         bufferedWriter.close();
         
      } catch (FileNotFoundException e) {
         System.out.println("잘못된 경로");
      } finally {
         if(br != null) {
            br.close();
         }
      }
      
//      피파2002 삭제
      target = "피파2002";
      
      try {
          br = new BufferedReader(new FileReader(fileSource));
          while((line = br.readLine()) != null) {
             if(line.equals(target)) {
                continue;
             }
             temp += line + "\n";
          }
          
          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileSource, false));
          bufferedWriter.write(temp);
          bufferedWriter.close();
          
       } catch (FileNotFoundException e) {
          System.out.println("잘못된 경로");
       } finally {
          if(br != null) {
             br.close();
          }
       }
	}
}
