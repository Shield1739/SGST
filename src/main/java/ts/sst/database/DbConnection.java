package ts.sst.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
	public static Connection getConnection()
	{
		Connection conn;
		try
		{
			// Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:db/sst.db";
			conn = DriverManager.getConnection(url);

			return conn;
		}
		catch (SQLException e)
		{
			System.out.println("DB CONNECTION ERROR");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
