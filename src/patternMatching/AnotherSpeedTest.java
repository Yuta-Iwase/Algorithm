package patternMatching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnotherSpeedTest {

	private static final int TEXT_LENGTH = 1000000; // ここでは円周率の桁数になる
	private static final int N_REPEAT = 100; // 計算時間測定のための反復回数

	public static void main(String[] args) {

		String p = "00000000000000000001";
		String t = makeText();
		
		
		System.out.println("テキストの初めの100文字:");
		for (int i = 0; i < 100; i++) {
			System.out.print(t.charAt(i));
			if (i % 10 == 9)
				System.out.print(" ");
		}
		System.out.println();
		System.out.println("テキストの終わりの100文字:");
		for (int i = 0; i < 100; i++) {
			System.out.print(t.charAt(TEXT_LENGTH - 100 + i));
			if (i % 10 == 9)
				System.out.print(" ");
		}
		System.out.println();

		Finder[] finders = new Finder[] { new BruteForceFinder(),
				new RKFinder(), new KMPFinder(), new BMFinder() };

			System.out.println("Number pattern?");

			// 照合の実施
			for (Finder fdr : finders) {
				long msBegin = System.currentTimeMillis();

				Integer pos = 0;
				for (int i = 0; i < N_REPEAT; i++) {
					pos = fdr.matchPattern(p, t);
				}

				long msEnd = System.currentTimeMillis();
				System.out.println("Result = " + pos + ", " + N_REPEAT
						+ "回の合計CPU time(ms) = " + (msEnd - msBegin));
			}

	}
	
	private static String makeText(){
		StringBuffer buf = new StringBuffer();
		
		//サンプルとして下記は、0,1をTEXT_LENGTHまで繰り返す
		for(int i=0 ; i<100000 ; i++){
			for(int j=0 ; j<9 ; j++) buf.append('0');
			buf.append('1');
		}
		
		return buf.toString();
	}	
}