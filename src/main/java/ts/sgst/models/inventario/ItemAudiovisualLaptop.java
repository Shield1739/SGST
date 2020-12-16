package ts.sgst.models.inventario;

public class ItemAudiovisualLaptop extends ItemAudiovisual
{
	private String marca;
	private String modelo;
	private String numeroProducto;
	private String os;

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

	public String getOs()
	{
		return os;
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

	public void setOs(String os)
	{
		this.os = os;
	}
}
