package ts.sgst.models;

public class User
{
	private String correo;
	private String nombre;
	private String apellido;
	private String rol;
	private int nivelAcceso;

	public User()
	{
	}

	/**
	 * Getters
	 */

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

	public String getRol()
	{
		return rol;
	}

	public int getNivelAcceso()
	{
		return nivelAcceso;
	}

	/**
	 * Setters
	 */

	public void setCorreo(String correo)
	{
		this.correo = correo;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public void setRol(String rol)
	{
		this.rol = rol;
	}

	public void setNivelAcceso(int nivelAcceso)
	{
		this.nivelAcceso = nivelAcceso;
	}

}
