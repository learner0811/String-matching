package BerryRavindran;

public class BerryRavindran {

	public static int MAX = 256;

	public static boolean cmp(char[] x, char[] y, int y1) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] != y[y1++]) {
				return false;
			}
		}
		return true;
	}

	public static void preBrBc(char[] x, int m, int brBc[][]) {
		int a, b, i;

		for (a = 0; a < MAX; ++a)
			for (b = 0; b < MAX; ++b)
				brBc[a][b] = m + 2;
		
		for (a = 0; a < MAX; ++a)
			brBc[a][x[0]] = m + 1;
		
		for (i = 0; i < m - 1; ++i)
			brBc[x[i]][x[i + 1]] = m - i;
		
		for (a = 0; a < MAX; ++a)
			brBc[x[m - 1]][a] = 1;
	}

	public static void BR(char[] x, int m, char[] y, int n) {
		int j, brBc[][];
		brBc = new int[MAX][MAX];		
		/* Preprocessing */
		preBrBc(x, m, brBc);

		j = 0;
		while (j <= n - m-2) {
			System.out.println(j + " ; " + y[j + m] + " " + y[j + m+1]);
			if (cmp(x, y, j))
				System.out.println("match at position " + j);			
			j += brBc[y[j + m]][y[j + m + 1]];
		}
	}

	public static void main(String[] args) {
		BR("GCAGAGAG".toCharArray(), "GCAGAGAG".length(), "GCATCGCAGAGAGTATACAGTACG".toCharArray(),
				"GCATCGCAGAGAGTATACAGTACG".length());
	}
}
