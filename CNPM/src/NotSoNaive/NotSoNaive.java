package NotSoNaive;

import java.util.Arrays;

public class NotSoNaive {
	public static boolean cmp(char[] x, char[] y) {
		if (x.length != y.length)
			return false;
		for (int i = 0; i < x.length; i++) {
			if (x[i] != y[i]) {
				return false;
			}
		}
		return true;
	}

	public static void search(char[] x, char[] y) {
		int m = x.length;
		int n = y.length;
		int i = 0;
		while (i <= n - m) {
			if (x[1] != y[i + 1] && x[0] == x[1]) {
				i = i + 2;
			} else if (x[1] == y[i + 1] && x[0] != x[1]) {				
				if (cmp(x, Arrays.copyOfRange(y, i, i + x.length))) {
					System.out.print(i + "    ");
				}
				i += 2;
			} else {
				if (cmp(x, Arrays.copyOfRange(y, i, i + x.length))) {
					System.out.print(i + "    ");
				}
				i += 1;
			}
		}
	}

	public static void main(String[] args) {
		char[] x = "GCAGAGAG".toCharArray();
		char[] y = "GCATCGCAGAGAGTATACAGTACG".toCharArray();
		System.out.println("Các vị trí xuất hiện trong văn bản của xâu mẫu là: ");
		search(x, y);
	}
}
