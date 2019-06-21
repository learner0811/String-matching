package TunedBoyerMoore;

public class TunedBoyerMoore {

	public static int[] preBc(char[] x) {
		int[] bc = new int[255];
		int m = x.length;
		for (int i = 0; i < 255; i++) {
			bc[i] = m;
		}
		for (int i = 0; i < m - 1; i++) {
			bc[(int) x[i]] = m - i - 1;
		}
		return bc;
	}

	public static void search(char[] x, char[] y) {
		int m = x.length;
		int n = y.length;
		int[] preBc = preBc(x);
		int shift = preBc[x[m - 1]];
		preBc[x[m - 1]] = 0;
		int i = 0;
		int k = 0;
		while (i <= n - m) {
			k = preBc[y[i + m - 1]];
			while (k != 0) {
				i += k;
				k = preBc[y[i + m - 1]];
				i += k;
				k = preBc[y[i + m - 1]];
				i += k;
				k = preBc[y[i + m - 1]];
			}
			if (cmp(x, y, i)) {
				System.out.println(i);
			}
			i += shift;
		}
	}

	public static boolean cmp(char[] x, char[] y, int y1) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] != y[y1++]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[] x = "GCAGAGAG".toCharArray();
		char[] y = "GCATCGCAGAGAGTATACAGTACG".toCharArray();
		System.out.print("Các vị trí xuất hiện trong văn bản của xâu mẫu là: ");
		search(x, y);
	}
}
