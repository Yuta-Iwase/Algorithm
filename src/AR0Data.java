// データ解析 11/24出題分『コンピュータ実習 ARモデル1』問題1

import java.io.FileWriter;
import java.io.IOException;


public class AR0Data {
	public static void main(String[] args) {
		FileWriter pw,pw2;
		try {
			pw = new FileWriter("D:\\AR0Data_T=300.dat");
			pw2 =new FileWriter("D:\\AR0Data_Histogram_T=100.dat");
			
			
			int T=300;
			double[] x = new double[T];
			double s0=1.0;
			
			// x[]の設定
			double r,theta;
			for(int i=0;i<x.length;i++){
				r=Math.sqrt(-2*Math.log(Math.random()));
				theta=2*Math.PI*Math.random();
				if(i%2==0)	x[i]=s0*r*Math.cos(theta);
				else		x[i]=s0*r*Math.sin(theta);
				
			}
			
			// (1)のプロット
			for(int i=0;i<x.length;i++){
				pw.write(i + "\t" + x[i] + "\r\n");
			}
			
			// (2)範囲-4～4で幅0.25の小区間を作成,それに従い小区間数を計算,小区間のカウント用の変数を準備
			double a=-4,b=4;
			double width=0.25;
			int sectionN = (int)((b-a)/width);
			int[] section = new int[sectionN];
			for(int i=0;i<section.length;i++)section[i]=0;
			// 値がどの区間に入っているか決定
			double leftLenght;
			int sectionID;
			for(int i=0;i<x.length;i++){
				leftLenght = x[i] - a;
				sectionID  = (int)(leftLenght/width);
				section[sectionID]++;
			}
			// (2)のプロット
			for(int i=0;i<section.length;i++){
				pw2.write(a+i*width+width/2 + "\t" + section[i] + "\r\n");
			}
			
			// (3)平均を計算,その後その平均値でx[]の各々を引く
			double sum=0;
			for(int i=0;i<x.length;i++) sum += x[i];
			double average = sum/x.length;
			for(int i=0;i<x.length;i++) x[i] -= average;
			System.out.println("T="+T + "  平均=" + average);
			
			// (4)分散を計算((3)で既にデータは平均値で引かれているので(x[]-m)^2 ではなく x[]^2 で計算することにする)
			double variance = 0;
			for(int i=0;i<x.length;i++) variance += Math.pow(x[i], 2);
			variance /=x.length;
			System.out.println("T="+T + "  分散=" + variance);
			
			pw.close();
			pw2.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
