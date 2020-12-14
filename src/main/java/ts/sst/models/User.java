package ts.sst.models;

public class User
{
	private final String correo;
	private final String nombre;
	private final String apellido;
	private final String tipo;

	public User(String correo, String nombre, String apellido, String tipo)
	{
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
	}

	public String getCorreo()
	{
		return correo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public String getApellido()
	{
		return apellido;
	}

	public String getTipo()
	{
		return tipo;
	}
}
