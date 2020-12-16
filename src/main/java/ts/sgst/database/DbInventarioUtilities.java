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
	//MAYBE wrap the runners and connections
	public List<ItemAudiovisual> getAllItems()
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<List<ItemAudiovisual>> beanListHandler = new BeanListHandler<>(ItemAudiovisual.class);

		List<ItemAudiovisual> items = new ArrayList<>();

		try
		{
			//language=SQL
			String query = "SELECT " +
				"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas " +
				"FROM InventarioItem i " +
				"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
				"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID";

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

	public ItemAudiovisualLaptop getLaptopItem(int itemID)
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<ItemAudiovisualLaptop> beanHandler = new BeanHandler<>(ItemAudiovisualLaptop.class);

		ItemAudiovisualLaptop laptop = null;

		try
		{
			//language=SQL
			String query = "SELECT " +
				//"i.ItemID, iec.Nombre AS 'estado', i.Notas, " +
				"l.Marca, l.Modelo, l.NumeroProducto, l.OS " +
				"FROM InventarioItem i " +
				"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
				"JOIN Laptop l on l.InventarioItemID = i.ItemID " +
				"WHERE i.ItemID=?";

			laptop = runner.query(c, query, beanHandler, itemID);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return laptop;
	}

	public List<ItemAudiovisualLaptop> getAllLaptopItems()
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<List<ItemAudiovisualLaptop>> beanListHandler = new BeanListHandler<>(ItemAudiovisualLaptop.class);

		List<ItemAudiovisualLaptop> laptops = new ArrayList<>();

		try
		{
			//language=SQL
			String query = "SELECT " +
				"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
				"l.Marca, l.Modelo, l.NumeroProducto, l.OS " +
				"FROM InventarioItem i " +
				"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
				"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
				"JOIN Laptop l on l.InventarioItemID = i.ItemID";

			laptops = runner.query(c, query, beanListHandler);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return laptops;
	}

	public ItemAudiovisualRaspberry getRaspberryItem(int itemID)
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<ItemAudiovisualRaspberry> beanHandler = new BeanHandler<>(ItemAudiovisualRaspberry.class);

		ItemAudiovisualRaspberry raspberry = null;

		try
		{
			//language=SQL
			String query = "SELECT " +
				//"i.ItemID, iec.Nombre AS 'estado', i.Notas, " +
				"r.Modelo, r.NumeroProducto " +
				"FROM InventarioItem i " +
				"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
				"JOIN Raspberry r on r.InventarioItemID = i.ItemID " +
				"WHERE i.ItemID=?";

			raspberry = runner.query(c, query, beanHandler, itemID);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return raspberry;
	}

	public List<ItemAudiovisualRaspberry> getAllRaspberryItems()
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<List<ItemAudiovisualRaspberry>> beanListHandler = new BeanListHandler<>(ItemAudiovisualRaspberry.class);

		List<ItemAudiovisualRaspberry> raspberrys = new ArrayList<>();

		try
		{
			//language=SQL
			String query = "SELECT " +
				"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
				"r.Modelo, r.NumeroProducto " +
				"FROM InventarioItem i " +
				"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
				"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
				"JOIN Raspberry r on r.InventarioItemID = i.ItemID";

			raspberrys = runner.query(c, query, beanListHandler);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return raspberrys;
	}

	public ItemAudiovisualProyector getProyectorItem(int itemID)
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<ItemAudiovisualProyector> beanHandler = new BeanHandler<>(ItemAudiovisualProyector.class);

		ItemAudiovisualProyector proyector = null;

		try
		{
			//language=SQL
			String query = "SELECT " +
				"i.ItemID, iec.Nombre AS 'estado', i.Notas, " +
				"p.Modelo, p.NumeroProducto " +
				"FROM InventarioItem i " +
				"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
				"JOIN Proyector p on p.InventarioItemID = i.ItemID " +
				"WHERE i.ItemID=?";

			proyector = runner.query(c, query, beanHandler, itemID);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return proyector;
	}

	public List<ItemAudiovisualProyector> getAllProyectorItems()
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<List<ItemAudiovisualProyector>> beanListHandler = new BeanListHandler<>(ItemAudiovisualProyector.class);

		List<ItemAudiovisualProyector> proyectores = new ArrayList<>();

		try
		{
			//language=SQL
			String query = "SELECT " +
				"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
				"p.Modelo, p.NumeroProducto " +
				"FROM InventarioItem i " +
				"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
				"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
				"JOIN Proyector p on p.InventarioItemID = i.ItemID";

			proyectores = runner.query(c, query, beanListHandler);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return proyectores;
	}

	public ItemAudiovisualGeneral getGeneralItem(int itemID)
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<ItemAudiovisualGeneral> beanHandler = new BeanHandler<>(ItemAudiovisualGeneral.class);

		ItemAudiovisualGeneral audiovisual = null;

		try
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

			audiovisual = runner.query(c, query, beanHandler, itemID);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return audiovisual;
	}

	public List<ItemAudiovisualGeneral> getAllGeneralItems()
	{
		QueryRunner runner = new QueryRunner();
		Connection c = DbConnection.getConnection();
		ResultSetHandler<List<ItemAudiovisualGeneral>> beanListHandler = new BeanListHandler<>(ItemAudiovisualGeneral.class);

		List<ItemAudiovisualGeneral> audiovisuales = new ArrayList<>();

		try
		{
			//language=SQL
			String query = "SELECT " +
				"i.ItemID, itc.Nombre AS 'tipo', iec.Nombre AS 'estado', i.Notas, " +
				"a.Descripcion, a.Cantidad " +
				"FROM InventarioItem i " +
				"JOIN ItemTipoCategoria itc on itc.ItemTipoCategoriaID = i.TipoID " +
				"LEFT JOIN ItemEstadoCategoria iec on iec.ItemEstadoCategoriaID = i.EstadoID " +
				"JOIN Audiovisual a on a.InventarioItemID = i.ItemID";

			audiovisuales = runner.query(c, query, beanListHandler);
		}
		catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		finally
		{
			DbUtils.closeQuietly(c);
		}

		return audiovisuales;
	}
}
