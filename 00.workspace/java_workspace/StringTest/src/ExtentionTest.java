import java.util.Scanner;

public class ExtentionTest {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("파일명 : ");
		String fileName=s.nextLine(); // 공백포함 한줄 전체 읽어들임

		// 방법1
		int positionOfDot=fileName.lastIndexOf(".");
		System.out.println("확장자 : "+fileName.substring(positionOfDot+1));
		
		// 방법2
		String[] result=fileName.split("\\."); // .문자를 정규 표현식으로 해석하므로, \\ 추가
		System.out.println(result);
		for(String word : result) {
			System.out.println(word);
		}
		
		System.out.println(result[result.length-1]); // 배열의 index 최대값==배열의 크기-1
//		System.out.println(result[-1]); // 자바에서는 불가, python 가능		
		
	}
}