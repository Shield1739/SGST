package ts.sgst.database;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ts.sgst.models.User;

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
			String query = "SELECT " +
				"u.Correo, u.Nombre, u.Apellido, ut.Nombre AS 'tipo' " +
				"FROM Usuario u " +
				"JOIN UserType ut ON ut.UsuarioTypeID = u.TypeID " +
				"WHERE u.Correo=? AND u.Password=?";
			user = runner.query(c, query, beanHandler, correo, password);

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
