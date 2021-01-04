package ts.sgst.models.inventario;

public class ItemInmobiliario extends BaseInventarioItem
{
	@Override
	public String getCategoria()
	{
		return "Inmobiliario";
	}

	@Override
	public String getSubCategoria()
	{
		return null;
	}
}
