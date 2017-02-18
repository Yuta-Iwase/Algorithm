import java.io.FileReader;
import java.io.StreamTokenizer;


public class AR2Levinson {
	public static int T;
	public static double data[] = new double[100000];
	
	public static void main(String[] args) {
		int t;
		double a1,a2,s0;
		//Data
		load_data();
		double[] x= data.clone();
//		for(t=0;t<T;t++)System.out.println(x[t]);
		
		// 問題2
		double sumAlt=0.0;
		for(int i=0;i<T;i++) sumAlt += x[i];
		double ave=sumAlt/T;
		for(int i=0;i<T;i++) x[i] -= ave;
		for(t=0;t<T;t++)System.out.println(x[t]);
		System.out.println();
		
		// 問題3(1)
		double R0,R1,R2,sum0=0.0,sum1=0.0,sum2=0.0;
		for(t=0;t<T;t++) sum0 += x[t]*x[t];
		R0 = sum0/T;
		for(t=0;t<T-1;t++) sum1 += x[t]*x[t+1];
		R1 = sum1/(T-1);
		for(t=0;t<T-2;t++) sum2 += x[t]*x[t+2];
		R2 = sum2/(T-2);
		System.out.println("R0=" + R0);
		System.out.println("R1=" + R1);
		System.out.println("R2=" + R2);
		System.out.println();
		// 問題3(2)
		int Mmax=3;
		double R[] = new double[Mmax];
		R[0]=R0; R[1]=R1; R[2]=R2;
		
		// 問題4
		a1=(R[0]*R[1]-R[1]*R[2])/(R[0]*R[0]-R[1]*R[1]);
		a2=(R[1]*R[1]-R[0]*R[2])/(R[1]*R[1]-R[0]*R[0]);
		s0=R[0]-a1*R[1]-a2*R[2];
		System.out.println("a1="+a1);
		System.out.println("a2="+a2);
		System.out.println("s0="+s0);
		System.out.println();
		
		// 問題5
		double a[][] = new double[Mmax][Mmax];
		double s[] = new double[Mmax];
		// 1.R(0),R(1),R(2)の決定
		/// すでにできているため省略
		// 2.SquareSigma0((σ_0)^2の事)の決定
		s[0] = R[0];
		// 3.a[M][M],a[M][m],(σ_M)^2の決定
		a[1][1] = (1/s[0]) * (R[1]-0);
		s[1] = s[0] * (1-a[1][1]*a[1][1]);
		a[2][2] = (1/s[1]) * (R[2]-a[1][1]*R[2-1]);
		s[2] = s[1] * (1-a[2][2]*a[2][2]);
		a[2][1] = a[2-1][1] - a[2][2]*a[2-1][2-1];
		System.out.println("s[0]=" +s[0]);
		System.out.println("s[1]=" +s[1]);
		System.out.println("s[2]=" +s[2]);
		System.out.println("a[1][1]=" + a[1][1]);
		System.out.println("a[2][1]=" + a[2][1]);
		System.out.println("a[2][2]=" + a[2][2]);
		
	}
	
	private static void load_data(){
		int n=0;
		try{
			FileReader fr = new FileReader("AR2.dat");
			StreamTokenizer st = new StreamTokenizer(fr);
			while(st.nextToken() != StreamTokenizer.TT_EOF){
				data[n]=st.nval;
				n++;
			}
			fr.close();
		}catch(Exception e){
			System.out.println(e);
		}
		T=n;
		System.out.println("T=" + T);
	}
}
