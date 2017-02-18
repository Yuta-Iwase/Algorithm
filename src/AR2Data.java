import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class AR2Data {
	
	public static void main(String[] args) {
		PrintWriter pw1,pw3;
		try {
			pw1 = new PrintWriter(new File("C:\\Users\\Owner\\Desktop\\AR2Data.dat"));
			pw3 = new PrintWriter(new File("C:\\Users\\Owner\\Desktop\\AR2Data_Autocovariance_T=1000.dat"));
			
			double s0=1.0,a1=0.4,a2=0.1;
			int T=1000000;
			double[] x = new double[T+2];
			x[0]=0; x[1]=0;
			
			// x[2]生成(前回参照)
			x[2]=s0 * Math.sqrt(-2*Math.log(Math.random())) * (2*Math.PI*Math.random());
			
			double y1,y2,r;
			for(int i=1;i<T;i++){
				y1=Math.random();
				y2=Math.random();
				r=Math.sqrt(-2*Math.log(y1))*Math.cos(2*Math.PI*y2);
				x[i+2]=a1*x[i+1] + a2*x[i] + r;
			}
			
			// (1)データプロット
			for(int i=0;i<T;i++)
				pw1.println(i + "\t" + x[i+2]);
			
			
			// (2)平均を出す
			double sum=0,average;
			for(int i=0;i<T;i++){
				sum += x[i+2];
			}
			average = sum/T;
			System.out.println("平均: " + average);
			for(int i=0;i<T;i++){
				x[i+2] -= average;
			}
			
			// (3)分散,共分散
			double variance=0;
			for(int i=0;i<T;i++){
				variance += Math.pow(x[i+2]-0, 2);
			}
			variance /= T;
			System.out.println("分散: " + variance);

			// 自己共分散関数をプロット
			System.out.println();
			double autocovariance;
			for(int s=0;s<T;s++){
				autocovariance=0;
				for(int t=0;t<=T-s-1;t++){
					autocovariance += (x[(t+2)]*x[(t+2)+s]);
				}
				autocovariance /= (T-s);
				pw3.println(s + "\t" + autocovariance);
				if(s==0 ||s==1 ||s==2)
					System.out.println("R" + s + "=" + autocovariance + ";");
			}
			pw1.close();
			pw3.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
}
