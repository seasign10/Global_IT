import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileInputStream_3 {

	public static void main(String[] args) throws IOException {
		// 파일 레퍼런스 생성
		File inFile=new File("src/files/FileInputStream2.txt");
		// FileInputStream 생성
		InputStream is2=new FileInputStream(inFile);
		InputStreamReader isr=new InputStreamReader(is2,"UTF-8");// utf-8인코딩
		BufferedReader br=new BufferedReader(isr);
		int str;
		while((str=br.read())!=-1) {
		  System.out.print((char)str);
		}
		is2.close();
		isr.close();
		br.close();
	}
}
