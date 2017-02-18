import java.util.Random;


public class rand {
	public static void main(String[] args) {
		Random a = new Random();
		int i=a.nextInt(6);
		String s="";
		
		switch(i){
		case 0:
		s="タイコウ";
		break;
		
		case 1:
		s="ホウチン";
		break;
		
		case 2:
			s="ピーゴロ";
			break;
			
		case 3:
			s="てん";
			break;
			
		case 4:
			s="匠屋";
			break;
		
		case 5:
			s="魚べい";
			break;
		}
		System.out.println(s);
		
		
		

	}
}
