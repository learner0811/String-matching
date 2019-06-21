package SkipSearch;

import java.util.ArrayList;

public class SkipSearch {
	
	public static boolean cmp(char[] x, char[] y, int y1) {
		if (y1 >= y.length)
			return false;
		for (int i = x.length-1; i >= 0 ; i--) {
			if (x[i] != y[y1--]) {
				return false;
			}
		}
		return true;
	}
		
	public static void skip(String x, String y) {		
		ArrayList<ArrayList<Integer>> z = new ArrayList<>();
		for (int i = 0; i < 256; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			z.add(temp);
		}
					
		int m = x.length();
		int n = y.length();
		
		//tiền xử lý
		for (int i = m-1; i >= 0; i--) {
			z.get((int) x.charAt(i)).add(i);
		}
		
		//tìm kiếm
		for (int j = m-1; j < n; j += m) {
			for (Integer i : z.get(y.charAt(j))) {
				if (cmp(x.toCharArray(), y.toCharArray(), j+m-1-i))
					System.out.println("Trùng nhau tại vị trí " + (j-i));
			}
		}
	}
	
	public static void main(String[] args) {
		skip("GCAGAGAG", "GCATCGCAGAGAGTATACAGTACG");
	}
}
