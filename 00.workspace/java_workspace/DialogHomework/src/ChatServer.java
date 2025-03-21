import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ServerDialog extends JDialog {
    private JTextField txtserverName;
    private JButton btnOK;
    private String serverName;

    public ServerDialog(Frame parent, String title) {
        super(parent, title, true); // 모달 다이얼로그
        setLayout(new FlowLayout());
        
        txtserverName = new JTextField(15);
        btnOK = new JButton("OK");
        
        add(new JLabel("닉네임 입력:"));
        add(txtserverName);
        add(btnOK);
        
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (txtserverName.getText() != null && !txtserverName.getText().trim().isEmpty()) {
                    System.out.println("입력된 닉네임: " + txtserverName.getText());
                    // 닉네임을 필요한 곳에 저장하거나 사용할 수 있음
                } else {
                	JOptionPane.showMessageDialog(null, "닉네임을 입력하세요.", "알림", JOptionPane.ERROR_MESSAGE);
					return;
                }
                serverName = txtserverName.getText(); // 입력 값 저장
                setVisible(false); // 다이얼로그 닫기
            }
        });
        
        setSize(300, 120);
        setLocationRelativeTo(parent); // 부모 프레임 중앙에 위치
        
        // 창이 닫힐 때의 동작을 정의
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(ServerDialog.this, "정말 닫으시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                	System.exit(0); // 프로그램 종료
                }else {
                	return;
                }
            }
        });
    }

    public String getserverName() {
        return serverName; // 입력된 닉네임 반환
    }
}

public class ChatServer extends JFrame implements ActionListener {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	private Receiver receiver; // JTextArea를 상속받고 Runnable 인터페이스를 구현한 클래스로서 받은 정보를 담는 객체
	private JTextField sender; // JTextField 객체로서 보내는 정보를 담는 객체

	public static String serverName=null;
	String clientName=null;
	
	public ChatServer() {
		// 다이얼로그 띄우기
        ServerDialog dialog = new ServerDialog(this, "닉네임 설정");
        dialog.setVisible(true); // 다이얼로그 보여주기
        
        // 입력된 닉네임을 가져오기
        serverName = dialog.getserverName();
		
		System.out.println(serverName);
		setTitle("서버 ["+serverName+"]의 채팅 창"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout()); //BorderLayout 배치관리자의 사용
		receiver = new Receiver(); // 클라이언트에서 받은 메시지를 출력할 컴퍼넌트
		receiver.setEditable(false); // 편집 불가

		sender = new JTextField();
		sender.addActionListener(this);

		add(new JScrollPane(receiver),BorderLayout.CENTER); // 스크롤바를 위해  ScrollPane 이용
		add(sender,BorderLayout.SOUTH);
		
		setSize(400, 200); // 폭 400 픽셀, 높이 200 픽셀의 크기로 프레임 크기 설정
		setVisible(true); // 프레임이 화면에 나타나도록 설정
		
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		
		Thread th = new Thread(receiver); // 상대로부터 메시지 수신을 위한 스레드 생성
		th.start();
	}
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999); // 서버 소켓 생성
		socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
		//System.out.println("연결됨");
		receiver.append("클라이언트로부터 연결 완료");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력 스트림
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림
		
		// 서버 이름을 클라이언트에게 전송
	    out.write("SERVER_NAME:"+serverName + "\n"); // 서버 이름 전송
	    out.flush();
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg = in.readLine(); // 상대로부터 한 행의 문자열 받기
					if (msg.startsWith("CLIENT_NAME:")) {
	                    // 서버 이름을 설정
	                    clientName = msg.substring("CLIENT_NAME:".length());
	                    this.append("\n[클라이언트 이름] "+clientName+"\n");
	                }else {
	                	this.append("\n  "+clientName+" : " + msg); // 받은 문자열을 JTextArea에 출력	                	
	                }
				} catch (IOException e) {
					handleError(e.getMessage());
				} 
				int pos = this.getText().length();
				this.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // JTextField에 <Enter> 키 처리
		if (e.getSource() == sender) {
			String msg = sender.getText(); // 텍스트 필드에서 문자열 얻어옴
			try {
				out.write(msg+"\n"); // 문자열 전송
				out.flush();
				
				receiver.append("\n "+serverName+" : " + msg);// JTextArea에 출력
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
				sender.setText(null); // 입력창의 문자열 지움
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
