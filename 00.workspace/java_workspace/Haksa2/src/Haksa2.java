import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Haksa2 extends JFrame {
	
	JMenuBar mb=null;
	JMenu studentMenu=null;
	JMenuItem studentInfoMenuItem=null;
	
	public Haksa2() {
		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.mb=new JMenuBar();
		this.studentMenu=new JMenu("학생관리");
		this.studentInfoMenuItem=new JMenuItem("학생정보");
		
		this.studentMenu.add(this.studentInfoMenuItem);
		this.mb.add(this.studentMenu);
		this.setJMenuBar(mb);
		
		this.setSize(300,500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Haksa2();
	}

}
