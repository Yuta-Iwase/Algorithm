// データ解析 10/20出題分『コンピュータ実習2』修正2回目


public class DataAnalysis2 {
	double average,variance;
	int imax;
	public DataAnalysis2(int input_imax,int n) {
		imax=input_imax;
		
		// (2)
		int[] k = new int[imax];
		for(int i=0;i<imax;i++)k[i]=0;
			
		// (3)
		for(int i=0;i<imax;i++){
			for(int j=0;j<n;j++){
				if(dice() == 1)k[i]++;
			}
		}
				
		// (4)
		average=0;
		for(int i=0;i<k.length;i++){
			average += k[i];
		}
		average /= (k.length+0.0);
		variance=0;
		for(int i=0;i<k.length;i++){
			variance += Math.pow(k[i]-average,2);
		}
		variance /= k.length;
	}
	public static void main(String[] args) {
		DataAnalysis2 tri1 = new DataAnalysis2(10,10);
		DataAnalysis2 tri2 = new DataAnalysis2(100,10);
		DataAnalysis2 tri3 = new DataAnalysis2(1000,10);
		DataAnalysis2 tri4 = new DataAnalysis2(10000,10);
		DataAnalysis2 tri5 = new DataAnalysis2(100000,10);
		DataAnalysis2 tri6 = new DataAnalysis2(1000000,10);
		
		tri1.ave();
		tri2.ave();
		tri3.ave();
		tri4.ave();
		tri5.ave();
		tri6.ave();
		
		System.out.println();
		
		tri1.var();
		tri2.var();
		tri3.var();
		tri4.var();
		tri5.var();
		tri6.var();
		
		
	}
	public int dice(){
		return (int)(6*Math.random())+1;
	}
	
	public void ave(){
		System.out.println(imax + "\t" + average);
	}
	public void var(){
		System.out.println(imax + "\t" + variance);
	}
}
