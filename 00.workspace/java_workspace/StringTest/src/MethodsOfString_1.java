public class MethodsOfString_1 {

	public static void main(String[] args) {
		String str1="Hello Java!";
		String str2="안녕하세요!";
		System.out.println(str1.length()); // 11
		System.out.println(str2.length()); // 6
		System.out.println();

		System.out.println(str1.charAt(1)); // e
		System.out.println(str2.charAt(1)); // 녕
		System.out.println();
		
		System.out.println(str1.indexOf("a")); // 7
		System.out.println(str1.lastIndexOf("a")); // 9
	}

}