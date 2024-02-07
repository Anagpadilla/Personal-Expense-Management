/* @author Ana García Padilla
	PAC DE DESARROLLO UF05 
	Madrid Curso 23/24  */

public abstract class Dinero
{
	protected double dinero;
	protected String description;
	
   	// Ahora crearemos nuestros métodos get (da valor a la variable) y set (devuelve la variable) 

	public double getDinero()
	{
		return dinero;
	}
	
	public void setDinero(double dinero) 
	{
		this.dinero = dinero;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
   	
}
