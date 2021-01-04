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
	public User login(String correo, String contraseña)
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<User> beanHandler = new BeanHandler<>(User.class);

		User user = null;

		try
		{
			//language=SQL
			String query =
     				"SELECT " +
						"UsuarioID, " +
						"UsuarioNombre AS \"Nombre\", " +
						"UsuarioApellido AS \"Apellido\", " +
						"UsuarioNivelAcceso AS \"NivelAcceso\", " +
						"vlUsuarioRolValor AS \"Rol\" " +
					"FROM dt_Usuario " +
					"JOIN vt_UsuarioRol ON vlUsuarioRolID = UsuarioRolID " +
					"WHERE UsuarioCorreo=? AND UsuarioToken=?";

			user = runner.query(c, query, beanHandler, correo, contraseña);

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
