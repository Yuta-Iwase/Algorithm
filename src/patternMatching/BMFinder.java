package patternMatching;

public class BMFinder implements Finder {

	public Integer matchPattern(String p, String t) {
		int m = p.length();
		if (m == 0) {
			return 0;
		}
		int charTable[] = makeCharTable(p);
		int offsetTable[] = makeOffsetTable(p);
		for (int i = m - 1, j; i < t.length();) {
			for (j = m - 1; p.charAt(j) == t.charAt(i); --i, --j) {
				if (j == 0) {
					return i;
				}
			}
			i += Math.max(offsetTable[m - 1 - j], charTable[t.charAt(i)]);
		}
		return null;
	}

	/**
	 * Makes the jump table based on the mismatched character information.
	 */
	private static int[] makeCharTable(String p) {
		final int ALPHABET_SIZE = 256;
		int[] table = new int[ALPHABET_SIZE];
		for (int i = 0; i < table.length; ++i) {
			table[i] = p.length();
		}
		for (int i = 0; i < p.length() - 1; ++i) {
			table[p.charAt(i)] = p.length() - 1 - i;
		}
		return table;
	}

	/**
	 * Makes the jump table based on the scan offset which mismatch occurs.
	 */
	private static int[] makeOffsetTable(String p) {
		int[] table = new int[p.length()];
		int lastPrefixPosition = p.length();
		for (int i = p.length() - 1; i >= 0; --i) {
			if (isPrefix(p, i + 1)) {
				lastPrefixPosition = i + 1;
			}
			table[p.length() - 1 - i] = lastPrefixPosition - i
					+ p.length() - 1;
		}
		for (int i = 0; i < p.length() - 1; ++i) {
			int slen = suffixLength(p, i);
			table[slen] = p.length() - 1 - i + slen;
		}
		return table;
	}

	/**
	 * Is p[pos:end] a prefix of p?
	 */
	private static boolean isPrefix(String p, int pos) {
		for (int i = pos, j = 0; i < p.length(); ++i, ++j) {
			if (p.charAt(i) != p.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the maximum length of the substring ends at pos and is a suffix.
	 */
	private static int suffixLength(String p, int pos) {
		int len = 0;
		for (int i = pos, j = p.length() - 1; i >= 0
				&& p.charAt(i) == p.charAt(j); --i, --j) {
			len += 1;
		}
		return len;
	}
	
	// This class was based on the Java program 
	// in Wikipedia "Boyer-Moore String Search Algorithm"
	

	public static void main(String[] args) {
		String t = "string pattern matching"; 
		String p = "pattern";
		Integer result = new BMFinder().matchPattern(p, t);
		System.out.println("Result = " + result);
	}

}
