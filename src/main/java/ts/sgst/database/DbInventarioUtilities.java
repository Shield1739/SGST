package ts.sgst.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ts.sgst.models.inventario.Item;

public class DbInventarioUtilities
{
	public List<Item> getAllItems()
	{
		//language=SQL
		String query = "SELECT " +
			"ItemID AS \"ID\", " +
			"vlItemCategoriaNombre AS \"Categoria\", " +
			"vlItemEstadoValor AS \"Estado\"," +
			"ItemMarca AS \"Marca\", " +
			"ItemModelo AS \"Modelo\", " +
			"ItemNumeroProducto AS \"NumeroProducto\"," +
			"ItemNotas AS \"Notas\" " +
			"FROM dt_Item " +
			"JOIN vt_ItemCategoria ON vlItemCategoriaID = ItemCategoriaID " +
			"JOIN vt_ItemEstado ON vlItemEstadoID = ItemEstadoID";

		return runBeanListQuery(Item.class, query);
	}

	//Query runners *DEPRECATE IF NECCESARY
	public <T extends Item> List<T> runBeanListQuery(Class<T> T, String query)
	{
		List<T> items = new ArrayList<>();
		ResultSetHandler<List<T>> beanListHandler = new BeanListHandler<>(T);

		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();

		try
		{
			items = runner.query(c, query, beanListHandler);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return items;
	}

	public <T extends Item> T runBeanQuery(Class<T> T, String query, int itemID)
	{
		T item = null;
		ResultSetHandler<T> beanHandler = new BeanHandler<>(T);

		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();

		try
		{
			item = runner.query(c, query, beanHandler, itemID);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return item;
	}

}
