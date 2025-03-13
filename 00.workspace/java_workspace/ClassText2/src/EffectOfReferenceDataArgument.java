import java.util.Arrays;

public class EffectOfReferenceDataArgument {

	public static void main(String[] args) {
		int[] array=new int[] {1,2,3};
		modifyData(array); // call by reference
		printData(array); // call by reference
	}
	
	public static void modifyData(int[] a) {
		a[0]=4;
		a[1]=5;
		a[2]=6;
	}
	
	public static void printData(int[] a) {
		System.out.println(Arrays.toString(a));
	}

}
