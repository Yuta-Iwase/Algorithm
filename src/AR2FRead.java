import java.io.*;

public class AR2FRead {
	public static int T;
	public static double data[] = new double[1000];
	public static void main(String[] args) {
		// データロード
		load_data();
		double x[] = data.clone();
		
		// 平均を出す
		double sum=0,average;
		for(int i=0;i<T;i++){
			sum += x[i];
		}
		average = sum/T;
		System.out.println("平均: " + average);
		for(int i=0;i<T;i++){
			x[i] -= average;
		}
		
		// 分散,共分散(分散は不要だが一応)
		double variance=0;
		for(int i=0;i<T;i++){
			variance += Math.pow(x[i]-0, 2);
		}
		variance /= T;
		System.out.println("分散: " + variance);
		// 自己共分散関数をプロット(余分な計算部分があるが一応)
		System.out.println();
		double autocovariance;
		for(int s=0;s<T;s++){
			autocovariance=0;
			for(int t=0;t<=T-s-1;t++){
				autocovariance += (x[t]*x[t+s]);
			}
			autocovariance /= (T-s);
//			pw3.println(s + "\t" + autocovariance);
			if(s==0 ||s==1 ||s==2)
				System.out.println("R" + s + "=" + autocovariance + ";");
		}
	}
	
	private static void load_data(){
		int n=0;
		try{
			FileReader fr = new FileReader("AR2.dat");
			StreamTokenizer st = new StreamTokenizer(fr);
			while(st.nextToken() != StreamTokenizer.TT_EOF){
				data[n] = st.nval;
				n++;
			}
			fr.close();
		}catch(Exception e){
			System.out.println(e);
		}
		T = n;
		System.out.println("T=" + T);
	}
}
