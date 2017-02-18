package patternMatching;

public class RKFinder implements Finder {

	private int d = 10; // 文字の種類数
	private char baseChar = '0';
	private int q = 524287; // 素数

	public Integer matchPattern(String p, String t) {
		int m = p.length();
		int n = t.length();

		int dm = 1;
		int hp = 0;
		int ht = 0;
		for (int i = 1; i < m; i++) {
			dm = (d * dm) % q;
		}
		dm -= q;

		for (int i = 0; i < m; i++) {
			hp = (hp * d + p.charAt(i) - baseChar) % q;
			ht = (ht * d + t.charAt(i) - baseChar) % q;
		}
		//System.out.println("hp="+hp);
		
		for (int i = 0; i <= n - m; i++) {
			if (hp == ht) {
				int j;
				for (j = 0; j < m; j++) {
					if (t.charAt(i + j) != p.charAt(j)) {
						break;
					}
				}
				if (j == m)
					return i;
			}
			if (i < n - m){
				ht = ((ht - (t.charAt(i) - baseChar) * dm) * d + (t.charAt(i + m) - baseChar))% q;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String t = "string pattern matching";
		String p = "abcde";
		Integer result = new RKFinder().matchPattern(p, t);
		System.out.println("Result = " + result);
	}
}