package ts.sgst.models.inventario;

public class ItemAudiovisual extends BaseInventarioItem
{
	@Override
	public String getCategoria()
	{
		return "Audiovisual";
	}

	@Override
	public String getSubCategoria()
	{
		if (this instanceof ItemAudiovisualBocina)
		{
			ItemAudiovisualBocina item = (ItemAudiovisualBocina) this;
			return item.getSubCategoria();
		}
		else if (this instanceof ItemAudiovisualCable)
		{
			ItemAudiovisualCable item = (ItemAudiovisualCable) this;
			return item.getSubCategoria();
		}
		else if (this instanceof ItemAudiovisualLaptop)
		{
			ItemAudiovisualLaptop item = (ItemAudiovisualLaptop) this;
			return item.getSubCategoria();
		}
		else if (this instanceof ItemAudiovisualProyector)
		{
			ItemAudiovisualProyector item = (ItemAudiovisualProyector) this;
			return item.getSubCategoria();
		}
		else if (this instanceof ItemAudiovisualRaspberry)
		{
			ItemAudiovisualRaspberry item = (ItemAudiovisualRaspberry) this;
			return item.getSubCategoria();
		}
		else
		{
			return null;
		}
	}
}
