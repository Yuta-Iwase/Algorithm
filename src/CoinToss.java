
public class CoinToss {
	static int[] counter= new int[4];
	static String[] name = new String[4];
	
	public CoinToss() {
		for(int i=0;i<4;i++)counter[i]=0;
		name[0] = "むさしの";
		name[1] = "福田屋ソバ店";
		name[2] = "手打そば にのまえ";
		name[3] = "李厨房";
	}
	
	public static void main(String[] args) {
		new CoinToss();

		
		for(int i=0;i<10000;i++){
			toss();
		}
		
		int max=0;
		int maxIndex=-1;
		for(int i=0;i<4;i++){
			max = Math.max(max, counter[i]);
			if(max == counter[i]) maxIndex=i;
		}
		
		System.out.println("むさしの:" + counter[0]);
		System.out.println("福田屋ソバ店:" + counter[1]);
		System.out.println("手打そば にのまえ:" + counter[2]);
		System.out.println("李厨房:" + counter[3]);
		System.out.println();
		System.out.print("最大値:" + max + " 番号:" + maxIndex + " ");
		System.out.println("店名:" + name[maxIndex]);
	}
	
	public static void toss(){
		int x =(int)( 4 * Math.random() );
		switch(x){
		case 0:
			counter[0]++;
			break;
		case 1:
			counter[1]++;
			break;
		case 2:
			counter[2]++;
			break;
		case 3:
			counter[3]++;
			break;
		}
		
		
	}
}
