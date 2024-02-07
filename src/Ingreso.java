/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Ingreso extends Dinero
{
// Las variables dinero y  description reciben nuevos valores desde la clase dinero.
	public Ingreso(double ingreso, String description)
	{
		this.dinero = ingreso;
		this.description = description;
		
		 
	}
	
	@Override //Para toString necesitamos los datos de la clase dinero.
	public String toString()
	{
		return "Ingreso de: " + getDescription() + 
				" Total: " + getDinero() + "€";
	}
}