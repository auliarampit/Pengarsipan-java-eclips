package Connection;
import java.sql.*;

public class Koneksi {
	
	private static String dbName 		= "agenda";
	private static String dbUser		= "root";
	private static String dbPass		= "";
	private static String URL			= "jdbc:mysql://localhost/" +dbName;
	public static Connection con		= null;
	public static Statement stat 		= null;
	
	public static void getConnection(){
		try {
			Koneksi.con = DriverManager.getConnection(URL, dbUser, dbPass);
			Koneksi.stat = Koneksi.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
