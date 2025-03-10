//import java.util.Scanner;

public class LoopTest {

	public static void main(String[] args) {
//		for(int i=1;i<=10;i++) {
//			System.out.println(i);
//		}
//		for(int i=10;i>=1;i--) {
//			System.out.println(i);
//		}
//		Scanner s=new Scanner(System.in);
//		for(;;) {
//			System.out.println("정수를 입력하세요. (나가기 -1 입력) : ");
//			
//			if (s.hasNextInt()) {
//				int number=s.nextInt();
//				if(number==-1) {
//					System.out.println("종료되었습니다.");
//					break;
//				}
//			}else {
//				System.out.println("잘못된 입력입니다. 정수를 입력하세요.");
//                s.next(); // 잘못된 입력을 소비하여 다음 입력으로 넘어감
//			}
//		}
		
		// 구구단. 이중for문
//		for(int dan=2;dan<=9;dan++) {
//			for(int num=1;num<=9;num++) {
//				System.out.println(dan+"x"+num+"="+dan*num);
//			}
//		}
//		
//		for(int num=1;num<=9;num++) {
//			for(int dan=2;dan<=9;dan++) {
//				System.out.print(dan+"x"+num+"="+dan*num+"\t");
//			}
//			System.out.println(); // 줄이 바뀜
//		}
//		
//		int j=0;
//		while(j<=10) {
//			System.out.println(j);
//			j++;
//		}
//		
//		int k=0;
//		do{
//			System.out.println(k);
//			k++;
//		}while(k<=10);
		
		
		
		
		
		// 무한루프 대신 do while 사용
//		Scanner s=new Scanner(System.in);
//		int number;
//		do {
//			System.out.print("정수를 입력하세요 : ");
//			number=s.nextInt();
//		}while(number!=-1);
//		
//		while(true) {
//			System.out.print("정수를 입력하세요 : ");
//			number=s.nextInt();
//			if(number==-1) {
//				break;
//			}
//		}
//		boolean flag=false;
//		for(int i=0;i<10;i++) {
//			for(int f=0;f<10;f++) {
//				if(f==3) {
//					flag=true; // flag를 변경
//					break;
//				}
//				System.out.println(i+", "+f);
//			}
//			if(flag){
//				break;
//			}
//		}	
//		System.out.println("끝");
//		
		int z=0;
		while(z<=10) {
			z++;
			if(z%2==1) {
				continue; // 현재 반복을 건너뛰고 다음 반복으로 이동
			}
			System.out.println(z);
		}
		System.out.println("End");
	}

}
