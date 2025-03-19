import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame{
	MyFrame(){
		setTitle("채팅");
		
		// 레이아웃 설정
		setLayout(new FlowLayout());
		
		// 버튼생성
		JButton btn1=new JButton("send");
		// 이벤트처리
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// callback(자동호출-버튼을 클릭 했을 때)
				System.out.println("클릭");
			}});
		
		add(btn1);
		
		setSize(300,300);
		setVisible(true);
	}
}
public class SwingTest {

	public static void main(String[] args) {
		new MyFrame();
	}

}
