// データ解析 11/24出題分『コンピュータ実習 ARモデル1』問題2

import java.io.FileWriter;
import java.io.IOException;


public class AR1Data {
	public static void main(String[] args) {
		FileWriter pw,pw2,pw3;
		try {
			pw = new FileWriter("D:\\AR1Data_T=300.dat");
			pw2 =new FileWriter("D:\\AR1Data_Histogram_T=10000.dat");
			pw3 =new FileWriter("D:\\Autocovariance_T=10000.dat");
			
			
			int T=10000;
			// y[i]:=x[i-1]と定義
			double[] y = new double[T+1];
			y[0]=0;
			double[] x = new double[T];
			double s0=1.0;
			double a1=0.5;
			double epsilon;
			
			// y[]を設定し,x[]へ反映
			double r,theta;
			for(int i=0;i<x.length;i++){
				r=Math.sqrt(-2*Math.log(Math.random()));
				theta=2*Math.PI*Math.random();
				if(i%2==0)	epsilon=s0*r*Math.cos(theta);
				else		epsilon=s0*r*Math.sin(theta);
				y[i+1] = a1*y[(i-1)+1] + epsilon;
			}
			for(int i=0;i<x.length;i++){
				x[i]=y[i+1];
			}
			
			// (1)のプロット
			pw.write(-1 + "\t" + y[0] + "\r\n");
			for(int i=0;i<x.length;i++){
				pw.write(i + "\t" + x[i] + "\r\n");
			}
			
			// (2)範囲-5～5で幅0.25の小区間を作成,それに従い小区間数を計算,小区間のカウント用の変数を準備
			double a=-5,b=5;
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
			// 自己共分散関数をプロット
			double autocovariance;
			for(int s=0;s<x.length;s++){
				autocovariance=0;
				for(int t=0;t<=T-s-1;t++){
					autocovariance += (x[t]*x[t+s]);
				}
				autocovariance /= (T-s);
				pw3.write(s + "\t" + autocovariance + "\r\n");
			}
			
			
			
			
			pw.close();
			pw2.close();
			pw3.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
