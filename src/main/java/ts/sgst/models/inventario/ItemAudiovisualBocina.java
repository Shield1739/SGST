package ts.sgst.models.inventario;

public class ItemAudiovisualBocina extends ItemAudiovisual
{
	private String marca;
	private String modelo;
	private String numeroProducto;

	@Override
	public String getSubCategoria()
	{
		return "Bocina";
	}

	/**
	 * Getters
	 */

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

	/**
	 * Setters
	 */

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
}
