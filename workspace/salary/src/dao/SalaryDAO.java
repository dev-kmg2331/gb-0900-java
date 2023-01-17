package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import domain.SalaryVO;

public class SalaryDAO {
//   추가
   public void insert(SalaryVO salaryVO) throws IOException{
      BufferedWriter bufferedWriter = DBConnecter.getAppend();
      String content = new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
      String temp = null;
      temp = content.charAt(content.length() - 1) == '\n' ? "" : "\n";
      temp += salaryVO.toString();
      bufferedWriter.write(temp);
      bufferedWriter.close();
   }
   
//   수정(소득세)
   public void update(SalaryVO salaryVO) throws IOException {
      BufferedReader bufferedReader = DBConnecter.getReader();
      String line = null, temp = "";
      
      while((line = bufferedReader.readLine()) != null) {
         if(line.split("   ")[0].equals(insertComma(salaryVO.getSalary()) + "만원")) {
            String data = line.substring(0, line.lastIndexOf("   "));
            
            temp += data.substring(0, data.lastIndexOf("   ")) + "   " 
                  + insertComma(salaryVO.getIncomeTax()) + "   "
                  + insertComma(salaryVO.getLocalTax()) + "\n";
            continue;
         }
         temp += line + "\n";
      }
      BufferedWriter bufferedWriter = DBConnecter.getWriter();
      bufferedWriter.write(temp);
      
      bufferedWriter.close();
      bufferedReader.close();
   }
//   삭제
   public void delete(int salary) throws IOException {
	   BufferedReader bufferedReader = DBConnecter.getReader();
	      String line = null, temp = "";
	      
	      while((line = bufferedReader.readLine()) != null) {
	         if(line.split("   ")[0].equals(insertComma(salary) + "만원")) {
	            continue;
	         }
	         temp += line + "\n";
	      }
	      BufferedWriter bufferedWriter = DBConnecter.getWriter();
	      bufferedWriter.write(temp);
	      
	      bufferedWriter.close();
	      bufferedReader.close();
   }
//   조회
   public SalaryVO select(int salary) throws IOException {
	   BufferedReader bufferedReader = DBConnecter.getReader();
	      String line = null, temp = "";
	      String[] arr = null;
	      SalaryVO salaryVO = new SalaryVO();
	      
	      while((line = bufferedReader.readLine()) != null) {
	         if(line.split("   ")[0].equals(insertComma(salary) + "만원")) {
	        	 
	        	 temp = line;
	        	 arr = temp.split("   ");
	        	 
	        	 salaryVO.setSalary(removeComma(arr[0]));
	        	 salaryVO.setNetPay(removeComma(arr[1]));
	        	 salaryVO.setTaxDeductionAmount(removeComma(arr[2]));
	        	 salaryVO.setPension(removeComma(arr[3]));
	        	 salaryVO.setHealthInsurance(removeComma(arr[4]));
	        	 salaryVO.setLongTermCarePay(removeComma(arr[5]));
	        	 salaryVO.setEmploymentInsurance(removeComma(arr[6]));
	        	 salaryVO.setIncomeTax(removeComma(arr[7]));
	        	 salaryVO.setLocalTax(removeComma(arr[8]));
	        	 
	            break;
	         }
	         
	      }
	      
	      bufferedReader.close();
	      
	      return salaryVO;
   }
//   목록
   public String selectAll() throws IOException {
	      BufferedReader bufferedReader = DBConnecter.getReader();
	      String line = null, temp = "";
	      
	      while((line = bufferedReader.readLine()) != null) {
	         temp += line + "\n";
	      }
	      
	      bufferedReader.close();
	      
	      return temp;
   }
   
   public static String insertComma(int number) {
      String temp = String.valueOf(number);
      String result = "";
      
      for (int i = 0; i < temp.length(); i++) {
         if(i != 0 && i % 3 == 0) {
            result = "," + result;
         }
         result = temp.charAt(temp.length() - 1 - i) + result;
      }
      return result;
   }
   
   private int removeComma(String target) {
	   String charTemp = "";
       
       Integer[] result = target.chars().filter(c -> Character.getNumericValue(c) != -1).boxed().toArray(Integer[]::new);
       for(int i : result) {
       	charTemp += (char)i;
       }
       
       return Integer.valueOf(charTemp);
   }
   
}





























