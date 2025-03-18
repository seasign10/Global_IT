import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class FileOutputStream_2 {

	public static void main(String[] args) throws IOException {
		// 파일 레퍼런스 생성
		File outFile=new File("src/files/FileInputStream2.txt");
		// FileOutputStream 생성
		// true: append (추가) | false: overwrite (덮어쓰기)
		OutputStream os2=new FileOutputStream(outFile,true); 
		
		// utf-8 인코딩 (string to byte[])
		byte[] byteArray1="안녕하세요".getBytes(Charset.forName("UTF-8"));
		os2.write(byteArray1);
		os2.write('\n'); // 줄 바꾸기
		
		os2.flush();
		os2.close();
	}

}
