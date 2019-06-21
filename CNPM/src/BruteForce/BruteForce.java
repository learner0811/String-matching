package BruteForce;

public class BruteForce {
	public static boolean cmp(char[] x, char[] y, int y1) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] != y[y1++]) {
				return false;
			}
		}
		return true;
	}
	
	public static void search(char[] x, char[] y) {
		int m = x.length;
		int n = y.length;
		
		int i = 0;
		while (i <= n-m) {
			if (cmp(x, y, i))
				System.out.println("Match at position " + i);
			i++;
		}
	}
	
	public static void main(String[] args) {
		search("GCAGAGAG".toCharArray(), "GCATCGCAGAGAGTATACAGTACG ".toCharArray());
	}
}
