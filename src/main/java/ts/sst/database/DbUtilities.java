package ts.sst.database;

import java.sql.Connection;

public class DbUtilities
{
	/**
	 * Private Open Connection
	 */
	private Connection openDB()
	{
		Connection c = DbConnection.getConnection();
		if (c == null)
		{
			System.exit(2);
		}

		return c;
	}
	/*
	//authentication
	/*
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
		openDB();

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

		//close();
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
