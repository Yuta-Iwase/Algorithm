// データ解析 10/20出題分『コンピュータ実習3』及びその修正

public class DataAnalysis3 {
	public static void main(String[] args) {
		/// 記入部分
		// 区間定義
		Section sec = new Section(-4,4);
		// 小区間数
		int secN=20;
		// 小区間の幅
		double width = sec.distance()/20.0;
		// 試行回数
		int n=10000;
		
		
		// 範囲外に出たものに対応するため10個分余分に確保する
		int[] N = new int[secN+10];
		for(int i=0;i<N.length;i++) N[i]=0;
		
		// サイコロオブジェクトをProblem21から定義
		ExDice dice = new ExDice();
		
		// (5)
		double z;
		int ii;
		for(int k=0 ; k<10000 ; k++){
			// (3)
			z=0.0;
			for(int j=0; j<n ; j++){
				z = z + (dice.roll() - 1.0/6.0);
			}
			z = z / (Math.sqrt(5.0*n)/6.0);
			
			// (4)
			ii = (int)(20.0*(z+4.0)/8.0);
			N[ii]++;
		}
		
		// (5)続き
		double sum=0;
		for(int i=0;i<secN;i++){
			sum += N[i]*width;
		}
		double nomalizedN[] = new double[secN+10];
		for(int i=0;i<secN;i++){
			nomalizedN[i] = N[i]/sum;
		}
		
		for(int k=0 ; k<secN ; k++){
			System.out.println((-4 + k*width + 0.5*width) + "\t" + nomalizedN[k]);
		}
	}
	

}
class Section{
	double left;
	double right;
	Section(double l , double r) {
		left = l;
		right = r;
	}
	
	double distance(){
		return right-left;
	}
}
class ExDice{
	public ExDice() {
	}
	public double roll(){
		double d = Math.random();
		if(0.0<=d && d<5.0/6.0) {
			return 0.0;
		}else{
			return 1.0;
		}
	}
}