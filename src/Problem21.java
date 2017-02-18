

public class Problem21 {
	public static void main(String[] args) {
		Trial tri1 = new Trial(10,10);
		Trial tri2 = new Trial(10,100);
		Trial tri3 = new Trial(10,1000);
		Trial tri4 = new Trial(10,10000);
		Trial tri5 = new Trial(10,100000);
		Trial tri6 = new Trial(10,1000000);

		tri1.heikin();
		tri2.heikin();
		tri3.heikin();
		tri4.heikin();
		tri5.heikin();
		tri6.heikin();

		System.out.println();

		tri1.bunsan();
		tri2.bunsan();
		tri3.bunsan();
		tri4.bunsan();
		tri5.bunsan();
		tri6.bunsan();
		
		System.out.println("演習2-1-(6)");
		
		tri1.logHei();
		tri2.logHei();
		tri3.logHei();
		tri4.logHei();
		tri5.logHei();
		tri6.logHei();
		
		System.out.println();
		
		tri1.logBun();
		tri2.logBun();
		tri3.logBun();
		tri4.logBun();
		tri5.logBun();
		tri6.logBun();
	}
}

class Dice{
	public Dice() {
	}

	public int roll(){
		double d = Math.random();
		if(0<=d && d<1.0/6){
			return 1;
		}else if(1.0/6<=d && d<2.0/6){
			return 2;
		}else if(2.0/6<=d && d<3.0/6){
			return 3;
		}else if(3.0/6<=d && d<4.0/6){
			return 4;
		}else if(4.0/6<=d && d<5.0/6){
			return 5;
		}else{
			return 6;
		}
	}
}

class Trial{
	int n;
	int imax;

	double average;
	double variance;
	
	double expected;

	public Trial(int In_n,int In_imax) {
		n =In_n;
		imax = In_imax;

		int[] k = new int[imax];

		Dice dice = new Dice();

		// 試行(3)
		for(int i=0 ; i<imax ; i++){
			k[i]=0;
			for(int j=0 ; j<n ; j++){
				if(dice.roll() == 1){
					k[i]++;
				}
			}
		}

		// 試行(4)
		// 平均値
		average=0;
		for(int i=0 ; i<imax ; i++){
			average += k[i];
		}
		average /= imax;
		// 分散
		final double TrueAverage = (1.0/6)*n;
		variance = 0;
		for(int i=0 ; i<imax ; i++){
			variance += Math.pow( k[i] - TrueAverage , 2);
		}
		variance /= imax;
	}

	public void heikin(){
		System.out.println(imax + "\t" + average);
	}

	public void bunsan(){
		System.out.println(imax + "\t" + variance);
	}
	
	public void logHei(){
		expected=10.0/6;
		System.out.println(Math.log(imax) + "\t" + Math.log(Math.abs(expected-average)));
	}
	
	public void logBun(){
		expected=10.0/6;
		System.out.println(Math.log(imax) + "\t" + Math.log(Math.abs(expected-variance)));
	}
}

