
public class binary {
	public static void main(String[] args) {
		int i,n=50;
		double p=1.0/6, q=1-p;
		double P[] = new double[n+1];
		// P[0]初期化
		P[0]=1;
		
		P[0] *= Math.pow(q, n);
		
		int maxI=0;
		double maxP=0;
		
		for(i=0 ; i<=n ; i++){
			System.out.println(i + "\t" + P[i]);
			
			if(P[i] > maxP){
				maxI = i;
				maxP = P[i];
			}
			
			if(i != n){
				P[i+1] = (((double)n-i) / (i + 1.0)) * (p/q) * P[i];
			}
		}
		
		System.out.println();
		System.out.println("n=" + n + " k=" + maxI + " p=" + maxP);
		
		// 裾野左端探索
		double minDis=10000;
		int leftI=0;
		double leftP=0;
		for(i=0 ; i<maxI ; i++){
			if(Math.abs((maxP/2) - P[i]) < minDis){
				minDis = Math.abs((maxP/2) - P[i]);
				leftI = i;
				leftP = P[i];
			}
		}
		
		// 裾野右端探索
		minDis=10000;
		int rightI=0;
		double rightP=0;
		for(i=maxI ; i<=n ; i++){
			if(Math.abs((maxP/2) - P[i]) < minDis){
				minDis = Math.abs((maxP/2) - P[i]);
				rightI = i;
				rightP = P[i];
			}
		}
		
		System.out.println();
		System.out.println("裾野左端: k=" +  leftI + " p=" +  leftP);
		System.out.println("裾野右端: k=" + rightI + " p=" + rightP);
		System.out.println("よって 半値幅:" + (rightI-leftI));
	}
}
