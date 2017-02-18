package patternMatching;

public class BruteForceFinder implements Finder{

	public Integer matchPattern(String p, String t){
		int m = p.length();
		int n = t.length();
		
		for (int i = 0; i <= n - m; i++){
			int j;
			for (j = 0; j < m; j++){
				if (t.charAt(i + j) != p.charAt(j)){
					break;
				}
			}
			if (j == m) return i;
		}
		return null;
	}
	
	public static void main(String[] args) {
		String t = "string pattern matching";
		String p = "pat";
		Integer result = new BruteForceFinder().matchPattern(p, t);
		System.out.println("Result = " + result);
	}
}