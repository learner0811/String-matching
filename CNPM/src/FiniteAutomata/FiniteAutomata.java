package FiniteAutomata;

public class FiniteAutomata {
	public static int MAX = 256;

	public static int getNextState(char[] pat, int m, int state, int x) {
		int ns, i;

		if (state < m && pat[state] == x)
			return state + 1;

		for (ns = state; ns > 0; ns--) {
			if (pat[ns - 1] == x) {
				for (i = 0; i < ns - 1; i++) {
					if (pat[i] != pat[state - ns + 1 + i])
						break;
				}
				if (i == ns - 1)
					return ns;
			}

		}
		return 0;
	}

	public static void computeTF(char[] pat, int m, int[][] TF) {
		int state, x;
		for (state = 0; state <= m; state++)
			for (x = 0; x < MAX; x++)
				TF[state][x] = getNextState(pat, m, state, x);
	}

	public static int finite_automata(char[] pat, char[] txt) {
		int i, count = 0, state = 0;
		int m, n;
		m = pat.length;
		n = txt.length;
		int TF[][] = new int[m + 1][MAX];
		computeTF(pat, m, TF);		
		for (i = 0; i < n; i++) {					
			state = TF[state][txt[i]];			
			if (state >= m) {
				System.out.println("Match at position " + (i-m+1));
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int a = finite_automata("GCAGAGAG".toCharArray(), "GCATCGCAGAGAGTATACAGTACG".toCharArray());		
	}
}
