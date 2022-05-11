package pollResidencial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PollTemplate {
	private static PollTemplate instance;
	private String url = "jdbc:oracle:thin:@localhost:1522:xe";
	private String user = "c##tester";
	private String password = "1234";
	
	private PollTemplate() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static PollTemplate getInstance() {
		if(instance == null) {
			instance = new PollTemplate();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
