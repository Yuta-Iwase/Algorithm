// データ解析 11/24出題分『コンピュータ実習 確率5』

public class DataAnalysis5 {
	public static void main(String[] args) {
		int N=1000;
		double x[] = new double[N];
		
//		for(int i=0;i<N;i++) x[i]=Math.random();
		
//		// 設定(1)
//		for(int i=0;i<N;i++) x[i]=Math.sqrt(Math.random());
		// 設定(2)
		for(int i=0;i<N;i++) x[i]=-Math.log(Math.random())/8;
		
		double m;
		double space;
		int minIndex;
		for(int i=0;i<N;i++){
			m=Double.MAX_VALUE;
			space=0;
			minIndex=-1;
			for(int j=i;j<N;j++){
				if(m>x[j]){
					m=x[j];
					minIndex=j;
				}
			}
			space=m;
			x[minIndex]=x[i];
			x[i]=space;
		}
		
		// 確率測度ν(x)をプロット
		System.out.println(0 + "\t" + 0);
		for(int i=0 ; i<N ; i++)
			System.out.println(x[i] + "\t" + (i+0.5)/N);
		System.out.println(1 + "\t" + 1);
	}
}
