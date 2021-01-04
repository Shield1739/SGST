package ts.sgst.database;

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
			String url = "jdbc:h2:tcp://localhost/C:/Users/Luisf/IdeaProjects/ACADEMY/SST/db/SGST;DATABASE_TO_UPPER=false";
			String user = "sa";
			String ps = "admin";
			conn = DriverManager.getConnection(url, user, ps);

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
