package patternMatching;

public class KMPFinder implements Finder{

	public Integer matchPattern(String p, String t) {
		int m = p.length();
		int n = t.length();

		int[] next = computeNext(p);
		/*System.out.println("function f:");
		for (int i = 1; i <= m; i++){
			System.out.printf("%3d", f[i]);
		}
		System.out.println();*/
		
		int j = 0;
		for (int i = 0; i < n; i++){
			//System.out.println("i="+i+",j="+j);
			while (j >= 0 && t.charAt(i) != p.charAt(j)){
				j = next[j];
			}
			if (j == m - 1) return i - m + 1;
			j++;
		}
		return null;
	}

	private static int[] computeNext(String p) {
		int m = p.length();
		int[] next = new int[m];
		int j = -1;
		for (int i = 0; i < m; i++){
			next[i] = j;
			while (j >= 0 && p.charAt(i) != p.charAt(j)){
				j = next[j];
			}
			j++;
		}
		return next;
	}

	public static void main(String[] args) {
		//String should have a apace " " in the head in order to start address from one.
		String t = "string pattern matching"; 
		String p = "pattern";
		int f[] = computeNext(p);
		for (int i = 0; i < f.length; i++){
			System.out.println("f("+i+")="+f[i]);
		}
		Integer result = new KMPFinder().matchPattern(p, t);
		System.out.println("Result = " + result);
	}

}
