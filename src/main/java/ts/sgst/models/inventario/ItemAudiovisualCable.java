package ts.sgst.models.inventario;

public class ItemAudiovisualCable extends ItemAudiovisual
{
	private String descripcion;
	private int cantidad;

	@Override
	public String getSubCategoria()
	{
		return "Cable";
	}

	/**
	 * Getters
	 */

	public String getDescripcion()
	{
		return descripcion;
	}

	public int getCantidad()
	{
		return cantidad;
	}

	/**
	 * Setters
	 */

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
}
