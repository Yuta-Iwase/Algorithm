// データ解析 12/8出題分『コンピュータ実習 正規乱数』

public class Histogram2 {
	public static void main(String[] args) {
		int j, N=20, T=10000;
		int n[] = new int[N];
		double a=-5.0;
		double b=5.0;
		
		
		double x,d,y;
		d=(b-a)/N;
		
		
		// 問題(2)用
		double r1,r2,R,r,theta;
		int k;
		int m[] = new int[N];
		int trueM[] = new int[N];
		
		for(int i=0 ; i<N ; i++) n[i]=0;
		for(int i=0 ; i<N ; i++) m[i]=0;
		for(int i=0 ; i<N ; i++) trueM[i]=0;
		for(int t=0 ; t<T ; t++){
			//問題1(1)
//			x=0;
//			y=0;
//			y  = Math.random() + Math.random() + Math.random() + Math.random();
//			y += Math.random() + Math.random() + Math.random() + Math.random();
//			y += Math.random() + Math.random() + Math.random() + Math.random();
//			x = y-6;
			
			r1=Math.random();
			r2=Math.random();
			R=-Math.log(r1);
			r=Math.sqrt(2*R);
			theta=2*Math.PI*r2;
			x=r*Math.cos(theta);
			y=r*Math.sin(theta);
			
			

			j = (int)((x-a)/d);
			n[j] += 1;
			k = (int)((y-a)/d);
			m[k] += 1;
			
			trueM[j] += 1;
			trueM[k] += 1;
		}
		for(int i=0 ; i<20 ; i++)
			System.out.println(
					(a+(i+0.5)*d) + "\t" + n[i]/d/T
					);
		System.out.println();
		for(int i=0 ; i<20 ; i++)
			System.out.println(
					(a+(i+0.5)*d) + "\t" + m[i]/d/T
					);
		System.out.println();
		for(int i=0 ; i<20 ; i++)
			System.out.println(
					(a+(i+0.5)*d) + "\t" + trueM[i]/d/T
					);
	}

}
