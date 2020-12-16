package ts.sgst.models.inventario;

public class ItemAudiovisualRaspberry extends ItemAudiovisual
{
	private String modelo;
	private String numeroProducto;

	/**
	 * Getters
	 */

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

	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}

	public void setNumeroProducto(String numeroProducto)
	{
		this.numeroProducto = numeroProducto;
	}
}
