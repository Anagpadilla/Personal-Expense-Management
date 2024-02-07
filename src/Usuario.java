

/* @author Ana García Padilla
	PAC DE DESARROLLO UF05 
	Madrid Curso 23/24  */


public class Usuario 
{
	//Creamos al variables que utilizaemos para nuestro usuario.
   	String nombre;
   	private int edad;
   	private String DNI;
   	
   	//Creamos nuestro método Usuario el cual necesitaremos en nuestro Main.
   	public Usuario()
   	{
   		nombre = "";
   		edad = 0;
   		DNI = "";
   		
   	}

   	/* Ahora crearemos nuestros métodos get (da valor a la variable) y set (devuelve la variable) */
   	public String getNombre()
   	{
   		return nombre;
   	}
   	
   	public void setNombre(String nombre)
   	{
   		this.nombre = nombre;
   	}
   	
   	public int getEdad()
   	{
   		return edad;
   	}
   	
   	public void setEdad(int edad)
   	{
   		this.edad = edad;
   	}
   	
   	/* Ahora debemos comprobar que el DNI sigue este formado: 
   	 * Formato correcto:
   	 * ✓ Los primeros 8 caracteres solo podrán ser numéricos.
   	 * ✓ El ultimo caracteres deberá ser una letra MINÚSCULA entre la a y la z.
   	 * ✓ El guion entre los números y la letra es opcional, admitiendo ambas posibilidades.
   	 * ✓ DNI: 78844112m
   	 * ✓ DNI: 78844112-m   
   	 * 
   	 * Esto se establece en la variable patron con expresiones regulares:
   	 * "\\d{8} - ->decimal de 8 cifras
   	 * [-]?  --> acepte guión entre medias
   	 * [a-z]" --> con una letra minúscula
   	 *  */
   	
   	public String getDNI()
   	{
   		return DNI;
   	}
   	
   	public boolean setDNI(String DNI)
   	{
   		String patron = "\\d{8}[-]?[a-z]";
   		
   		if (DNI.matches(patron)) 
   		{
   			this.DNI = DNI;
   			return true;
   		}
   		else
   		{
   			return false;
   		}
   	}
   	
   	@Override
   	public String toString()
   	{
   		return "Nombre: " + nombre + "\n"
   				+ "Edad: " + edad + "\n"
   				+ "DNI: " + DNI + "\n";
   	}
}
