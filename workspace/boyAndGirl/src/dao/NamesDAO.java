package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import domain.NamesDTO;

public class NamesDAO {

	private ArrayList<NamesDTO> merge() throws IOException {
		BufferedReader br = null;

		ArrayList<NamesDTO> names = new ArrayList<NamesDTO>();
		
		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();

		String line = "";

		br = DBConnecter.getReader(DBConnecter.BOYPATH);

		while ((line = br.readLine()) != null) {
			names.add(boyDAO.setObject(line));
		}

		br = DBConnecter.getReader(DBConnecter.GIRLPATH);

		while ((line = br.readLine()) != null) {
			names.add(girlDAO.setObject(line));
		}

		br.close();
		
		
		return names;
	}

	public ArrayList<NamesDTO> getMergedArray() throws IOException {
		ArrayList<Integer> temp;
		ArrayList<NamesDTO> names = merge();
		ArrayList<NamesDTO> result = new ArrayList<NamesDTO>();
		
		temp = sortAmount(names);

		int index = 1;
		int count = 0;

		for (int i : temp) {

			for (int t = 0; t < names.size(); t++) {

				if (i == names.get(t).getAmount()) {
					names.get(t).setRank(index - count);
					result.add(names.get(t));
					
					count++;
					index++;
					
					names.remove(t);
				}

			}

			count = 0;
		}
		
		return result;
	}

	private ArrayList<Integer> sortAmount(ArrayList<NamesDTO> names) {
		ArrayList<Integer> temp = null;
		HashSet<Integer> dataHash = new HashSet<Integer>();
		names.stream().map(v -> v.getAmount()).forEach(dataHash::add);

		temp = new ArrayList<Integer>(dataHash);

		temp.sort(Collections.reverseOrder());
		
		return temp;
	}

	public void createFile(ArrayList<NamesDTO> arr) throws IOException {
		BufferedWriter bw = DBConnecter.getWriter(DBConnecter.NAMESPATH);

		String temp = "";
		
		for (NamesDTO dto : arr) {
			temp += dto.toString() + "\n";
		}
		
		bw.write(temp);

		if (bw != null) {
			bw.close();
		}
	}
}
