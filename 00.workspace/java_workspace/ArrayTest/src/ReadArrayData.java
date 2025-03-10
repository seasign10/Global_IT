import java.util.Arrays;

public class ReadArrayData {

	public static void main(String[] args) {
		int[] array=new int[] {3,4,5,6,7};
		System.out.println(array.length); // 배열의 크기

		// 출력1
		// 배열의 요소가 순서대로 k에 저장되어 처리
		for(int k : array) {
			System.out.print(k+" ");
			
		}
		System.out.println();

		// 출력2
		System.out.print(array[0]+" ");
		System.out.print(array[1]+" ");
		System.out.print(array[2]+" ");
		System.out.print(array[3]+" ");
		System.out.print(array[4]+" ");
		System.out.println();
		
		// 출력3
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
		// 출력4
		// 배열을 문자열로 변환
		System.out.println(Arrays.toString(array));
	}

}
