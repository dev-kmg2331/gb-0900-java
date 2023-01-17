package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import vo.NamesVO;

public class NamesDAO {
	
	public ArrayList<NamesVO> merge() throws IOException {
		BufferedReader br = null;
		
		ArrayList<NamesVO> names = new ArrayList<NamesVO>();
		ArrayList<Integer> temp = null;
		ArrayList<NamesVO> result = new ArrayList<NamesVO>();
		
		HashSet<Integer> dataHash = new HashSet<Integer>();
		
		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();
		
		String line = "";
		
		br = DBConnecter.getReader(DBConnecter.BOYPATH);
		
		while((line = br.readLine()) != null) {
			names.add(boyDAO.setObject(line));
		}
		
		br = DBConnecter.getReader(DBConnecter.GIRLPATH);
		
		while((line = br.readLine()) != null) {
			names.add(girlDAO.setObject(line));
		}
		
		names.stream().map(v -> v.getAmount()).forEach(dataHash::add);;
		
		temp = new ArrayList<Integer>(dataHash);
		
		temp.sort(Collections.reverseOrder());
		
		int index = 1;
		
		for(int i : temp) {
			for(NamesVO vo : names) {
				if(vo.getAmount() == i) {
					int rank = index;
					vo.setRank(rank);
					result.add(vo);
					
					index++;
				}
			}
		}
		
		return result;
	}
	
	public void createFile(ArrayList<NamesVO> arr) throws IOException {
		BufferedWriter bw = DBConnecter.getAppend(DBConnecter.NAMESPATH);
		
		for(NamesVO vo : arr) {
			bw.write(vo.toString() + "\n");
		}
		
		if(bw != null) {
			bw.close();
		}
	}
}
