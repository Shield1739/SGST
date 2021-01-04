package ts.sgst.models.inventario;

public abstract class BaseInventarioItem
{
	private int itemID;
	private String tipo;
	private String estado;
	private String notas;

	public BaseInventarioItem()
	{

	}

	/**
	 * Getters
	 */

	public int getItemID()
	{
		return itemID;
	}

	public String getTipo()
	{
		return tipo;
	}

	public String getEstado()
	{
		return estado;
	}

	public String getNotas()
	{
		return notas;
	}

	/**
	 * Setters
	 */

	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public void setNotas(String notas)
	{
		this.notas = notas;
	}

	/**
	 * Abstracts
	 */

	public abstract String getCategoria();
	public abstract String getSubCategoria();
}
