package ts.sst.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ts.sst.models.User;

public class DbUtilities
{
	private Connection c;

	//Private Utility
	private void open()
	{
		this.c = DbConnection.getConnection();

		if (this.c == null)
		{
			System.exit(2);
		}
	}

	private void close()
	{
		try
		{
			this.c.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	//authentication
	public User login(String correo, String password)
	{
		User user = null;
		//language=SQL
		String userQuery = "SELECT * FROM Usuario WHERE Correo=? AND Password=?";

		open();

		try
		{
			PreparedStatement userStmt = this.c.prepareStatement(userQuery);
			//Parametros
			userStmt.setString(1, correo);
			userStmt.setString(2, password);
			//Run
			ResultSet userRs = userStmt.executeQuery();

			if (userRs.next())
			{
				int tipoID = userRs.getInt("TypeID");
				//language=SQL
				String userTypeQuery = "SELECT Nombre FROM UserType WHERE UsuarioTypeID=?";

				PreparedStatement userTypeStmt = this.c.prepareStatement(userTypeQuery);
				//Parametros
				userTypeStmt.setInt(1, tipoID);
				//Run
				ResultSet userTypeRs = userTypeStmt.executeQuery();

				if (userTypeRs.next())
				{
					String nombre = userRs.getString("Nombre");
					String apellido = userRs.getString("Apellido");
					String tipo = userTypeRs.getString("Nombre");

					user = new User(correo, nombre, apellido, tipo);
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		close();

		return user;
	}

	//table operations
	public void getTodosTable()
	{
		//language=SQL
		String query =
			"SELECT" +
				"    i.ItemID AS 'ID', " +
				"    icat.Nombre AS 'Categoria', " +
				"    ecat.Nombre AS 'Estado', " +
				"    iinfo.PrestamoID AS 'Prestamo' " +
				"FROM Inventario i " +
				"JOIN ItemCategoria icat ON icat.ItemCategoriaID = i.CategoriaID " +
				"JOIN InventarioItemEstadoInfo iinfo ON iinfo.InventarioItemID = i.ItemID " +
				"JOIN EstadoCategoria ecat ON ecat.EstadoCategoriaID = iinfo.EstadoCategoriaID ";
		open();

		try
		{
			PreparedStatement stmt = this.c.prepareStatement(query);
			//Parametros
			//userStmt.setString(1, correo);
			//userStmt.setString(2, password);
			//Run
			ResultSet rs = stmt.executeQuery();

			while (rs.next())
			{
				System.out.println("WORKS?");
				System.out.println(rs.getInt("ID") + " " + rs.getString("Categoria"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		close();
	}
	/*
	SELECT
    i.ItemID AS 'ID',
    icat.Nombre AS 'Categoria',
    ecat.Nombre AS 'Estado',
    iinfo.PrestamoID AS 'Prestamo'
	FROM Inventario i
	JOIN ItemCategoria icat ON icat.ItemCategoriaID = i.CategoriaID
	JOIN InventarioItemEstadoInfo iinfo ON iinfo.InventarioItemID = i.ItemID
	JOIN EstadoCategoria ecat ON ecat.EstadoCategoriaID = iinfo.EstadoCategoriaID
	 */
}
