
public class OperatorTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3<<1); // 3>6 == 3*2
		System.out.println(3<<2); // 3>12 == 3*4
		System.out.println(3<<3); // 3>24 == 3*8
		
		System.out.println(8>>1); // 8>4 == 8/4
		System.out.println(8>>2); // 8>2 == 8/2
		System.out.println(8>>3); // 8>1 == 8/8
		
		System.out.println(-8>>1); // -4 부호유지
		System.out.println(-8>>>1); // 양수로 변경
	}

}
