import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class ClientDialog extends JDialog {
    private JTextField txtclientName;
    private JButton btnOK;
    private String serverName;
    private String clientName;

    public ClientDialog(Frame parent, String title) {
        super(parent, title, true); // 모달 다이얼로그
        setLayout(new FlowLayout());
        
        txtclientName = new JTextField(15);
        btnOK = new JButton("OK");
        
        add(new JLabel("닉네임 입력:"));
        add(txtclientName);
        add(btnOK);
        
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (txtclientName.getText() != null && !txtclientName.getText().trim().isEmpty()) {
                    System.out.println("입력된 닉네임: " + txtclientName.getText());
                    // 닉네임을 필요한 곳에 저장하거나 사용할 수 있음
                } else {
                	JOptionPane.showMessageDialog(null, "닉네임을 입력하세요.", "알림", JOptionPane.ERROR_MESSAGE);
					return;
                }
                clientName = txtclientName.getText(); // 입력 값 저장
                setVisible(false); // 다이얼로그 닫기
            }
        });
        
        setSize(300, 120);
        setLocationRelativeTo(parent); // 부모 프레임 중앙에 위치
        
        // 창이 닫힐 때의 동작을 정의
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(ClientDialog.this, "정말 닫으시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                	System.exit(0); // 프로그램 종료
                }else {
                	return;
                }
            }
        });
    }

    public String getclientName() {
        return clientName; // 입력된 닉네임 반환
    }
}

public class ChatClient extends JFrame implements ActionListener {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private Socket socket = null;
	private Receiver receiver = null; // JTextArea를 상속받고 Runnable 인터페이스를 구현한 클래스로서 받은 정보를 담는 객체
	private JTextField sender = null; // JTextField 객체로서 보내는 정보를 담는 객체
	
	public static String clientName=null;
	String serverName=null;
	
	public ChatClient() {
		// 다이얼로그 띄우기
        ClientDialog dialog = new ClientDialog(this, "닉네임 설정");
        dialog.setVisible(true); // 다이얼로그 보여주기
        
        // 입력된 닉네임을 가져오기
        clientName = dialog.getclientName();
		
		setTitle("클라이언트 ["+clientName+"]의 채팅 창"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout()); //BorderLayout 배치관리자의 사용
		receiver = new Receiver(); // 서버에서 받은 메시지를 출력할 컴퍼넌트
		receiver.setEditable(false); // 편집 불가
		
		sender = new JTextField();
		sender.addActionListener(this);

		c.add(new JScrollPane(receiver),BorderLayout.CENTER); // 스크롤바를 위해  ScrollPane 이용
		c.add(sender,BorderLayout.SOUTH);
		
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
		socket = new Socket("localhost", 9999); // 클라이언트 소켓 생성
		// System.out.println("연결됨");
		receiver.append("서버에 연결 완료");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 서버부터의 입력 스트림
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 서버로의 출력 스트림
	
	    // 클라이언트 이름을 서버에게 전송
	    out.write("CLIENT_NAME:"+clientName + "\n"); // 서버 이름 전송
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
					if (msg.startsWith("SERVER_NAME:")) {
	                    // 서버 이름을 설정
	                    serverName = msg.substring("SERVER_NAME:".length());
	                    this.append("\n[서버 이름] "+serverName+"\n");
	                }else {
	                	this.append("\n  "+serverName+" : " + msg); // 받은 문자열을 JTextArea에 출력	                	
	                }
				} catch (IOException e) {
					handleError(e.getMessage());
				} 
				int pos = this.getText().length();
				this.setCaretPosition(pos); // caret(커서)을 가장 마지막으로 이동
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // JTextField에 <Enter> 키 처리
		if (e.getSource() == sender) {
			String msg = sender.getText(); // 텍스트 필드에 사용자가 입력한 문자열
			try {
				out.write(msg+"\n"); // 문자열 전송
				out.flush();
				
				receiver.append("\n"+clientName+" : " + msg); // JTextArea에 출력
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
				sender.setText(null); // 입력창의 문자열 지움
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}
}
