/* @author Ana García Padilla
	PAC DE DESARROLLO UF05 
	Madrid Curso 23/24  */

public class GastoException extends Exception
/* Al extender la clase Exception, GastoException se convierte en una clase de excepción 
 * personalizada que puedes usar en tu código para manejar situaciones específicas de
 *  excepción relacionadas con gastos.*/
{
	private static final long serialVersionUID = 1L; //Controlamos la versión de la serialización de objetos. 

	public GastoException()
   	{
   		super("Saldo insufucuente"); //Mensaje que describe la excepción. 
   	}
}
