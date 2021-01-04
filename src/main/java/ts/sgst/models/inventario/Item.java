package ts.sgst.models.inventario;

public class Item
{
	private int ID;
	private String categoria;
	private String estado;
	private String marca;
	private String modelo;
	private String numeroProducto;
	private String notas;

	public Item()
	{

	}

	/**
	 * Getters
	 */

	public int getID()
	{
		return ID;
	}

	public String getCategoria()
	{
		return categoria;
	}

	public String getEstado()
	{
		return estado;
	}

	public String getMarca()
	{
		return marca;
	}

	public String getModelo()
	{
		return modelo;
	}

	public String getNumeroProducto()
	{
		return numeroProducto;
	}

	public String getNotas()
	{
		return notas;
	}

	/**
	 * Setters
	 */

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}

	public void setNumeroProducto(String numeroProducto)
	{
		this.numeroProducto = numeroProducto;
	}

	public void setNotas(String notas)
	{
		this.notas = notas;
	}
}
