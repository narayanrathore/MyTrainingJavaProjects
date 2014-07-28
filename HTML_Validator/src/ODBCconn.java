import java.sql.*;
public class ODBCconn 
{
	@SuppressWarnings("finally")
	public static Connection createConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/html","web","websa");
		} catch(Exception e)
		{
			System.err.println(e);
		} finally
		{
			return conn;
		}
	}
}
