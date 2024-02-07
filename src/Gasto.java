/* @author Ana García Padilla
	PAC DE DESARROLLO UF05 
	Madrid Curso 23/24  */

public class Gasto extends Dinero
{
	// Las variables dinero y  description reciben nuevos valores desde la clase dinero.
	public Gasto(double gasto, String description)
	{
		this.dinero = gasto;
		this.description = description;
	}
	
	@Override //Para toString necesitamos los datos de la clase dinero.
	public String toString()
	{
		return "Gasto de: " + getDescription() + 
				" Total: " + getDinero() + "€";
	}
}
