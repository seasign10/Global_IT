import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriter_1 {

	public static void main(String[] args) {
		// FileWriter 사용
		File outputStreamWriter1=new File("src/files/OutputStreamWriter1.txt");
		// writer객체 자동 close
		try(Writer writer=new FileWriter(outputStreamWriter1);){
			writer.write("안녕하세요? 감사해요. 잘있어요. 다시 만나요. \n");
			writer.flush();
		}catch(IOException e) {}
		
		// OutputStreamWriter 사용해서 인코딩
		File outputStreamWriter2=new File("src/files/OutputStreamWriter2.txt");
		// writer객체 자동 close
		try(
			OutputStream os=new FileOutputStream(outputStreamWriter2);
			OutputStreamWriter osw=new OutputStreamWriter(os, "UTF-8");
			){
			osw.write("안녕하세요? 감사해요. 잘있어요. 다시 만나요. \n");
			osw.flush();
		}catch(IOException e) {}

	}

}
