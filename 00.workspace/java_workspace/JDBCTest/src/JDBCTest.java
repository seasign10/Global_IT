import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			// oracle jdbc driver 로드
			// 패키지 : oracle.jdbc.driver
			// 클래스 : OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// SID : ex
			// Oracle UserName : haein
			// User Password : shinystar
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","haein","shinystar");
			System.out.println("연결완료");
			
			// statement 객체생성
			// java.sql.Statment 임포트
			Statement stmt=conn.createStatement();
			
			// (insert, update, delete) executeUpdate를 사용 (자동 commit) Oracle 응용 프로그램에서만 commit 수동
			// insert
			// stmt.executeUpdate("insert into student2 values('K202001','왕건','국문학과')");
			
			// update
			// stmt.executeUpdate("update student2 set name='혼길돈' where id='M202001'");
			
			// delete
			// stmt.executeUpdate("delete from student2 where id='S202003'");
			
			// select
			ResultSet rs=stmt.executeQuery("select * from student2");
			while(rs.next()) {
				// 한줄 씩 읽음(fetch)
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("dept"));
			}
			rs.close(); // rs 는 stmt에 종속된 것이기 때문에 먼저 닫아야 함 (역순)
			stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			conn.close();			
		}
	}

}
