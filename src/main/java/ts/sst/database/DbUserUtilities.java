package ts.sst.database;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ts.sst.models.User;

public class DbUserUtilities
{
	public User login(String correo, String password)
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<User> beanHandler = new BeanHandler<>(User.class);

		User user = null;

		try
		{
			//language=SQL
			String query = "SELECT * FROM Usuario WHERE Correo=? AND Password=?";
			user = runner.query(c, query, beanHandler, correo, password);

			if (user != null)
			{
				ResultSetHandler<String> scalarHandler = new ScalarHandler<>();
				//language=SQL
				String query2 = "SELECT Nombre FROM UserType WHERE UsuarioTypeID=?";
				String tipo = runner.query(c, query2, scalarHandler, user.getTypeID());
				user.setTipo(tipo);
			}
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return user;
	}
}
