import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student extends JPanel{
	// field. 메서드입장에서 field는 전역변수역할.
	JTextField txtId=null;
	JTextField txtName=null;
	JTextField txtDept=null;
	JTextField txtAddress=null;
	
	DefaultTableModel model=null; //테이블의 데이터
	JTable table=null;
	
	JButton btnInsert=null; // 등록 Create
	JButton btnSelect=null; // 목록 Read
	JButton btnUpdate=null; // 수정 Update
	JButton btnDelete=null; // 삭제 Delete
	
	//search
	JButton btnSearch=null; //학번으로 학생 검색
	
	public Student() {
		
		
		//layout설정
		this.setLayout(new FlowLayout());
		
		this.add(new JLabel("학번"));
		this.txtId=new JTextField(20);
		this.add(this.txtId);
		
		this.add(new JLabel("이름"));
		this.txtName=new JTextField(15);
		this.add(this.txtName);
		
		this.btnSearch=new JButton("검색");
		this.btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				try {
					// oracle jdbc driver 로드
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","haein","shinystar");
					System.out.println("연결완료");
					
					// statement객체생성
					Statement stmt=conn.createStatement();
					
					// select
					ResultSet rs=stmt.executeQuery("select * from studentHaksa where name='"+txtName.getText()+"'");
					
					// JTaable 초기화
					model.setNumRows(0); // model의 행의 수를 0으로 설정(초기화)
					
					while(rs.next()) {
						String[] row=new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						model.addRow(row); // 모델에 추가
					}
					rs.close();
					stmt.close();
					conn.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}});
		this.add(this.btnSearch);
		
		this.add(new JLabel("학과"));
		this.txtDept=new JTextField(20);
		this.add(this.txtDept);
		
		this.add(new JLabel("주소"));
		this.txtAddress=new JTextField(20);
		this.add(this.txtAddress);
		
		String[] colname= {"학번","이름","학과","주소"};//컬럼명
		this.model=new DefaultTableModel(colname,0);//모델생성
		this.table=new JTable(model);//table에 model 바인딩
		this.table.setPreferredScrollableViewportSize(new Dimension(250,270));
//		this.add(this.table);
		JScrollPane sp=new JScrollPane(this.table);//스크롤생성
		this.table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
//				table=(JTable)e.getComponent();
				model=(DefaultTableModel)table.getModel();
				txtId.setText((String)model.getValueAt(table.getSelectedRow(), 0));
				txtName.setText((String)model.getValueAt(table.getSelectedRow(), 1));
				txtDept.setText((String)model.getValueAt(table.getSelectedRow(), 2));
				txtAddress.setText((String)model.getValueAt(table.getSelectedRow(), 3));				
			}

			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			});
		this.add(sp);
		
		this.btnInsert=new JButton("등록");
		this.btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				try {
					// oracle jdbc driver 로드
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","haein","shinystar");
					System.out.println("연결완료");
					
					//statement객체생성
					Statement stmt=conn.createStatement();
					//insert
					stmt.executeUpdate("insert into studentHaksa values('"+txtId.getText()+"','"+txtName.getText()+"','"+txtDept.getText()+"','"+txtAddress.getText()+"')");

					stmt.close();
					conn.close();
					
					list();//목록
					resetTextField();//텍스트필드초기화
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}});
		this.add(this.btnInsert);
		
		
		
		this.btnSelect=new JButton("목록");
		this.btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list();//목록			
				resetTextField();
			}});
		this.add(this.btnSelect);
		
		this.btnUpdate=new JButton("수정");
		this.btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				try {
					// oracle jdbc driver 로드
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","haein","shinystar");
					System.out.println("연결완료");
					
					//statement객체생성
					Statement stmt=conn.createStatement();
					
					stmt.executeUpdate("update studentHaksa set name='"+txtName.getText()+"',dept='"+txtDept.getText()+"' where id='"+txtId.getText()+"'");
					
					stmt.close();
					conn.close();
					
					list();//목록
					resetTextField();//텍스트필드초기화
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}});
		this.add(this.btnUpdate);
		
		this.btnDelete=new JButton("삭제");
		this.btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn=null;
				Statement stmt=null;
				try {
					// oracle jdbc driver 로드
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","haein","shinystar");
					System.out.println("연결완료");
					//statement객체생성
					stmt=conn.createStatement();						
					ResultSet rs = stmt.executeQuery("select * from studentHaksa where id='" + txtId.getText() + "'");
					// 입력된 id가 존재하지 않으면
					if(!rs.next()) {
						JOptionPane.showMessageDialog(null, "올바른 아이디를 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					rs.close();					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				int result=JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);

				// yes를 클릭했을 때
				if(result==JOptionPane.YES_OPTION) {
					try {
						//delete
						stmt.executeUpdate("delete from studentHaksa where id='"+txtId.getText()+"'");
						
						stmt.close();
						conn.close();
						
						list();//목록
						resetTextField();//텍스트필드초기화
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}});
		this.add(this.btnDelete);
		
		
		this.setSize(280,500);
		this.setVisible(true);
		
		
	}

	//목록
	public void list() {
		Connection conn=null;
		try {
			// oracle jdbc driver 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","haein","shinystar");
			System.out.println("연결완료");
			
			//statement객체생성
			Statement stmt=conn.createStatement();					
			//select
			ResultSet rs=stmt.executeQuery("select * from studentHaksa");
			//JTable초기화
			model.setNumRows(0);// model의 행의수를 0으로 설정
			
			while(rs.next()) {
				String[] row=new String[4]; //행
				row[0]=rs.getString("id");
				row[1]=rs.getString("name");
				row[2]=rs.getString("dept");
				row[3]=rs.getString("address");
				model.addRow(row); //모델에 추가
				
				
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	// TextField초기화
	public void resetTextField() {
		this.txtId.setText("");
		this.txtName.setText("");
		this.txtDept.setText("");
		this.txtAddress.setText("");
	}
}
