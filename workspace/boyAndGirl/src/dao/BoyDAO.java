package dao;

import domain.BoyVO;

public class BoyDAO {
	
	private String[] stringDatas = null; 
	
	public BoyVO setObject(String s) {
		
		BoyVO vo = new BoyVO();
		
		int i = 0;
		
		stringDatas = s.split("\t");
		
		vo.setName(stringDatas[i++]);
		vo.setRank(Integer.valueOf(stringDatas[i++]));
		vo.setAmount(Integer.valueOf(stringDatas[i++].replaceAll(",", "")));
		
		return vo;
	}
	
	
}
