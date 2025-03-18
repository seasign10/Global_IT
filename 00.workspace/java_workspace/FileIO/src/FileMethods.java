import java.io.File;

public class FileMethods {

	public static void main(String[] args) {
		// 파일경로를 이용해서 파일객체 생성
		File tempDir=new File("c:/temp");
		// 파일존재유무확인
		if(!tempDir.exists()) { // 해당 폴더가 있으면
			tempDir.mkdir(); // 새폴더 생성
		}
		File file=new File("c:/Windows");
		System.out.println("절대 경로: "+file.getAbsolutePath());
		System.out.println("폴더: "+file.isDirectory());
		System.out.println("파일: "+file.isFile());
		System.out.println("파일/폴더명: "+file.getName());
		System.out.println("부모폴더: "+file.getParent());
		
		File newfile2=new File("c:/temp/bcd/cde");
		System.out.println(newfile2.mkdirs()); // 복수로 만들때는 s 붙여야함
		
		File[] fnames=file.listFiles();
		for(File fname:fnames) {
			System.out.println((fname.isDirectory()?"폴더: ":"파일: ")+fname.getName()+"-"+fname.lastModified());
		}
	}

}
