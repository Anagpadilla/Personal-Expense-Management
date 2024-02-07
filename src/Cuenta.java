//Estos import son los únicos permitidos para trabajar con listas.
import java.util.ArrayList;
import java.util.List;

/* @author Ana García Padilla
PAC DE DESARROLLO UF05 
Madrid Curso 23/24  */

public class Cuenta
{

   	//Antes de empezar tenemos que iniciar nuestras variables:
	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;
	
	//Ahora creamos la cuenta con los datos introducidos por el usuario.
	public Cuenta(Usuario usuario)
	{
		this.saldo = 0;
		this.usuario = usuario;
		this.gastos = new ArrayList<>();
		this.ingresos = new ArrayList<>();
	}
	
   	/* Ahora crearemos nuestros métodos get (da valor a la variable) y set (devuelve la variable) */
	public double getSaldo()
	{
		return saldo;
	}
	
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}
	
	public Usuario getUsuario()
	{
		return usuario;
	}
	
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	//En esta función agregaremos un nuevo ingreso utilizando la clase Ingreso. 
	public double addIngresos(String description, double cantidad)
	{
		ingresos.add(new Ingreso(cantidad, description));
		this.saldo = saldo + cantidad; // Sumaremos el ingreso al saldo actual.
		return saldo;
	}
	
	//En esta función agregaremos un nuevo gasto utilizando la clase Gasto. 
	public double addGastos(String description, double cantidad) throws GastoException 
	{
		if(this.saldo - cantidad < 0)  // Cuando el nuevo gasto sea inferior al saldo, dara error.
		{
			throw new GastoException(); //Aparecerá nuextra excepción.
		}
		
		gastos.add(new Gasto(cantidad, description));
		this.saldo = saldo - cantidad; 
		//Si no hay problemas, al saldo actual se le restará la cantidad introducida.
		return this.saldo;
	}
	
	//Estos métodos devuelven una lista de objetos para ingresos y para gastos.
	public List<Ingreso> getIngresos()
	{
		return ingresos;
	}
	
	public List<Gasto> getGastos()
	{
		return gastos;
	}
	
	@Override //Mostraremos el saldo actual del usuario. 
	public String toString()
	{
		return "El saldo de " + usuario.nombre 
				+ " es de " + saldo + "€" ;
	}
	
	
	
	
	
	
}
