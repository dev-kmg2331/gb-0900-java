package view;

import java.io.IOException;

import dao.SalaryDAO;

public class Test {
	public static void main(String[] args) throws IOException {
//		String[] arr = null;
//		String charTemp = "";
//		String temp = "4,000만원   2,917,143   416,190   145,490   100,870   7,440   21,010   128,530   12,850";
//		arr = temp.split("   ");
//        Integer[] result = arr[0].chars().filter(c -> Character.getNumericValue(c) != -1).boxed().toArray(Integer[]::new);
//        
//        for(int i : result) {
//        	charTemp += (char)i;
//        }
//        
//        System.out.println(Integer.valueOf(charTemp));
		
		SalaryDAO dao = new SalaryDAO();
//		dao.delete(15000);
		System.out.println(dao.select(8500));
//		System.out.println(dao.selectAll());
	}
}
