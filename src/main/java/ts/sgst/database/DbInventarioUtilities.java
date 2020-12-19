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
import ts.sgst.models.inventario.ItemAudiovisual;
import ts.sgst.models.inventario.ItemAudiovisualLaptop;
import ts.sgst.models.inventario.ItemAudiovisualRaspberry;
import ts.sgst.models.inventario.ItemAudiovisualProyector;
import ts.sgst.models.inventario.ItemAudiovisualGeneral;

public class DbInventarioUtilities
{
	//Query runners
	public <T extends ItemAudiovisual> List<T> runBeanListQuery(Class<T> T, String query)
	{
		//T inst = T.newInstance();
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

	public <T extends ItemAudiovisual> T runBeanQuery(Class<T> T, String query, int itemID)
	{
		//T inst = T.newInstance();
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

	//Queries
	//MAYBE Queries repeat, add item to all?
	public List<ItemAudiovisual> getAllItems()
	{
		//language=SQL
		String query = "SELECT " +
			"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas " +
			"FROM InventarioItem i " +
			"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID";

		return runBeanListQuery(ItemAudiovisual.class, query);
	}

	public ItemAudiovisualLaptop getLaptopItem(int itemID)
	{
		//language=SQL
		String query = "SELECT " +
			//"i.ItemID, iec.Nombre AS 'estado', i.Notas, " +
			"l.Marca, l.Modelo, l.NumeroProducto, l.OS " +
			"FROM InventarioItem i " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
			"JOIN Laptop l on l.InventarioItemID = i.ItemID " +
			"WHERE i.ItemID=?";

		return runBeanQuery(ItemAudiovisualLaptop.class, query, itemID);
	}

	public List<ItemAudiovisualLaptop> getAllLaptopItems()
	{
		//language=SQL
		String query = "SELECT " +
			"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
			"l.Marca, l.Modelo, l.NumeroProducto, l.OS " +
			"FROM InventarioItem i " +
			"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
			"JOIN Laptop l on l.InventarioItemID = i.ItemID";

		return runBeanListQuery(ItemAudiovisualLaptop.class, query);
	}

	public ItemAudiovisualRaspberry getRaspberryItem(int itemID)
	{
		//language=SQL
		String query = "SELECT " +
			//"i.ItemID, iec.Nombre AS 'estado', i.Notas, " +
			"r.Modelo, r.NumeroProducto " +
			"FROM InventarioItem i " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
			"JOIN Raspberry r on r.InventarioItemID = i.ItemID " +
			"WHERE i.ItemID=?";

		return runBeanQuery(ItemAudiovisualRaspberry.class, query, itemID);
	}

	public List<ItemAudiovisualRaspberry> getAllRaspberryItems()
	{
		//language=SQL
		String query = "SELECT " +
			"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
			"r.Modelo, r.NumeroProducto " +
			"FROM InventarioItem i " +
			"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
			"JOIN Raspberry r on r.InventarioItemID = i.ItemID";

		return runBeanListQuery(ItemAudiovisualRaspberry.class, query);
	}

	public ItemAudiovisualProyector getProyectorItem(int itemID)
	{
		//language=SQL
		String query = "SELECT " +
			"i.ItemID, iec.Nombre AS 'estado', i.Notas, " +
			"p.Modelo, p.NumeroProducto " +
			"FROM InventarioItem i " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
			"JOIN Proyector p on p.InventarioItemID = i.ItemID " +
			"WHERE i.ItemID=?";

		return runBeanQuery(ItemAudiovisualProyector.class, query, itemID);
	}

	public List<ItemAudiovisualProyector> getAllProyectorItems()
	{
		//language=SQL
		String query = "SELECT " +
			"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
			"p.Modelo, p.NumeroProducto " +
			"FROM InventarioItem i " +
			"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
			"JOIN Proyector p on p.InventarioItemID = i.ItemID";

		return runBeanListQuery(ItemAudiovisualProyector.class, query);
	}

	public ItemAudiovisualGeneral getGeneralItem(int itemID)
	{
		//language=SQL
		String query = "SELECT " +
			"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
			"a.Descripcion, a.Cantidad " +
			"FROM InventarioItem i " +
			"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
			"JOIN Audiovisual a on a.InventarioItemID = i.ItemID " +
			"WHERE i.ItemID=?";

		return runBeanQuery(ItemAudiovisualGeneral.class, query, itemID);
	}

	public List<ItemAudiovisualGeneral> getAllGeneralItems()
	{
		//language=SQL
		String query = "SELECT " +
			"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
			"a.Descripcion, a.Cantidad " +
			"FROM InventarioItem i " +
			"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
			"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
			"JOIN Audiovisual a on a.InventarioItemID = i.ItemID";

		return runBeanListQuery(ItemAudiovisualGeneral.class, query);
	}
}
