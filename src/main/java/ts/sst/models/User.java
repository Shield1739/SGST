package ts.sst.models;

import java.io.Serializable;

public class User implements Serializable
{
	private String correo;
	private String nombre;
	private String apellido;
	private int typeID;
	private String tipo;

	public User()
	{

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

	public void setTypeID(int typeID)
	{
		this.typeID = typeID;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
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

	public int getTypeID()
	{
		return typeID;
	}

	public String getTipo()
	{
		return tipo;
	}
}
