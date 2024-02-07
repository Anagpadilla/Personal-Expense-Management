
import java.util.Scanner;
/* El único import permitido en la clase Main es Scanner, el cuál utilizaremos para que se queden guardados
	los datos introducidos por pantalla por parte del usuario */


/* @author Ana García Padilla
	PAC DE DESARROLLO UF05 
	Madrid Curso 23/24
	
	
	En esta clase Main dividiremos el código en varias partes. En la primera crearemos una cuenta con los
	datos del usuario: nombre, edad y DNI. 
	En la segunda parte mostraremos un menu al usuario para que elija la opción que desea realizar.
	Según el número escogido se realizará una opción u otra trabajando con los ingresos y gastos del usuario.
	
 */


public class Main {

    public static void main(String[] args)
    {
    	
    	//Iniciamos nuestra variable scanner(sc) que nos ayudará a utilizar los datos escritos por pantalla.
    	
    	Scanner sc = new Scanner(System.in);
    	
    	// Creamos una instancia para el objeto Usuario 
    	Usuario usuario = new Usuario();
    	
    	// Creamos el usuario llamando al método crearUsuario.
    	crearUsuario(usuario, sc);
    	
    	/* Una vez hayamos creado nuestro usuario correctamente, se lo hacemos saber al usuario por pantalla
    	 * y llamamos a la función toString de la clase usuario para que muestre los datos del usuario. 
    	 */
    	System.out.println("\nUsuario creado correctamente.");
    	System.out.println(usuario.toString());
    	
    	//Creamos la cuenta a través de un nuevo objto con los datos de la clase usuario.
    	Cuenta cuenta = new Cuenta(usuario);
    	
    	/* Iniciamos un integer en -1 para que el usuario pueda elegir que pción desea realizar. 
    	 * No se puede iniciar en 0 porque es una de las opciones con valor de salida(Salir). 
    	 */
    	int opcion = -1; 
    	while(opcion != 0) //Mientras el número no sea 0, mostrará el menu al usuario.
    	{
    	
    		menuUsuario(); //Función que muestra por pantalla el menu de nuestra aplicación.
    		System.out.println("Introduce una opción: ");
    		opcion = Integer.parseInt(sc.nextLine()); 
    		
    		/* Una vez que el usuario elige una opción y escribe un número, pasamos ese número de 
    		String a int para trabajar con el en el siguiente método: */
    	
    		elegirCaso(opcion, sc, cuenta);
    		
    	}
    	sc.close();
    		System.out.println("Fin del programa.\n"
    				+ "Gracias por utilizar la aplicación de M03B en el curso 1s2324.");
    	// Una vez el usuario presione 0, se cierra Scanner y se muestra el mensaje de salida.
    }
    
    public static void crearUsuario(Usuario usuario, Scanner sc)
    {
    	String nombre = introducirNombre(sc);
    	int edad = introducirEdad(sc);
    	String DNI = introducirDNI(sc, usuario);
    	
    	usuario.setNombre(nombre); //Guarda nombre de usuario introducido por pantalla.
    	usuario.setEdad(edad); //Guarda edad de usuario introducida por pantalla.
    	usuario.setDNI(DNI); ////Guarda DNI de usuario introducido por pantalla.
    }
    
    	
    	
    public static String introducirNombre(Scanner sc)
    {
    	System.out.println("Introduce el nombre: ");
    	return sc.nextLine();
    }
    
    public static int introducirEdad(Scanner sc)
    {
    	int edad;
    	
    	while(true)  //El bucle no parará hasta que el usuario escriba un número correcto.
   		{
   			System.out.println("Introduce la edad: ");
    		if(sc.hasNextInt())
    		{
   				edad = sc.nextInt(); 
   			//Convertimos el número introducido como String en Int con parseInt y paramos el bucle.
   				sc.nextLine();
   				break;
   				
    		}
    		else
    		{
   				System.out.println("Edad: Debes introducir números");
   				sc.nextLine();
   			}
   		}
    	return edad;
    }
    
    public static String introducirDNI(Scanner sc, Usuario usuario)
    {
    	String DNI;
    	
    	System.out.println("Introduce un DNI: ");
   		DNI = sc.nextLine();
    	
   		while(!usuario.setDNI(DNI)) //Si el usuario no escribe el dni correctamente da mensaje de error.
  		{
   			System.out.println("DNI Incorrecto, debe introducir 8 números y una letra minúscula."
    				+ " Ejemplo: 83746529e o 83746529-e. ");
   			System.out.println("Introduce un DNI: ");
   			DNI = sc.nextLine(); //Damos nueva oportunidad al usuario para que escriba su dni.
   		}
   		return DNI;
    }
    
    private static void menuUsuario()
    {
    		System.out.println("Realiza una nueva acción");
    		System.out.println("(1) Introduce un nuevo gasto");
    		System.out.println("(2) Introduce un nuevo ingreso");
    		System.out.println("(3) Mostrar gastos");
    		System.out.println("(4) Mostrar ingresos");
    		System.out.println("(5) Mostrar saldo");
    		System.out.println("(0) Salir");
    }		
   		
    private static void elegirCaso(int opcion, Scanner sc, Cuenta cuenta) 
    {
		switch(opcion)
		{
		 	case 1: //si el número introducido por pantalla es 1: introducimos un nuevo gasto.
		 	{
		    	System.out.println("Introduce una descripción para el gasto: ");
		    	String description = sc.nextLine();
		    				
		    	
		    	System.out.println("Introduce una cantidad: ");
		    	
    			double cantidad = Double.valueOf(sc.nextLine());
    			/* Como vamos a trabajar con variables doubles en vez de Int, pasamos el número introducido
    			por pantalla (String) a double. */
    			
    			/* El programa intentara realizar la función addGastos en la clase cuenta pero si hay 
    			algún error,como que el saldo sea inferior a la cantidad del gasto, lanzará una excepción 
    			de tipo GastoException */
		    	try 
		    	{ 
					cuenta.addGastos(description, cantidad); 
					System.out.println("Gasto introducido correctamente\n");
				} 
		    	catch (GastoException e) // La e significa error.
		    	{
					
		    		System.out.println("No hay suficiente saldo para tu gasto\n");
				}
		    	
		    	/*Pra finalizar llamamos a nuestra función toString en la clase cuenta, remplazando los 
		    	puntos de los doubles, por comas. Adaptándolo al sistema de euros como pide el enunciado */
		    	System.out.println(cuenta.toString().replace('.', ',') + "\n");
		    	
		    	break;
		 	}
	
		 	case 2: //Si el número introducido por pantalla es 2: introducimos un nuevo ingreso.
		 	{
		    	System.out.println("Introduce una descripción para el ingreso: ");
		    	String description = sc.nextLine();
		    						    	
		    	
		    	System.out.println("Introduce una cantidad: ");
		    	
		    	//Se repite lo mismo que en el caso anterior pero sin usar try/catch.
		    	double cantidad = Double.valueOf(sc.nextLine().replace(',', '.'));
		    	
		    	cuenta.addIngresos(description, cantidad);
		    	
		    	
		    	System.out.println("Ingreso introducido correctamente\n");
		    	
		    	System.out.println(cuenta.toString().replace('.', ',') + "\n");
	
		    	break;		    				
		    }
		 	
		 	case 3: //Si el número introducido por pantalla es 3: mostraremos los gastos realizados.
		 	{
		    	if (cuenta.getGastos().isEmpty()) //Si no se han realizado gastos, da mensaje de error.
		    	{
		    		System.out.println("No hay gastos\n");
		    	}
		    	else
		    	{
		    		for(Gasto gasto : cuenta.getGastos()) //Es igual que un bucle for each.
		    		{
		    			System.out.println(gasto.toString()+ "\n");
		    			/* Recorre la lista de gastos almacenados en el objeto cuenta e imprime cada gasto
		    			  en la consola en una representación de cadena. */
		    		}
		    		System.out.println();
		    	}
		    	break;		    				
		    }
		 	
		 	case 4: //Si el número introducido por pantalla es 4: mostraremos los ingresos realizados.
		 	{
		 		// Igual que el caso anterior, pero con los ingresos.
		    	if (cuenta.getIngresos().isEmpty()) 
		    	{
		    		System.out.println("No hay ingresos\n: ");
		    	}
		    	else
		    	{
		    		for(Ingreso ingreso : cuenta.getIngresos())
		    		{
		    			System.out.println(ingreso.toString() + "\n");
		    		}
		    		System.out.println();
		    	}
		    	break;
		    }
		 	
		 	case 5: //Si el número introducido por pantalla es 5: mostraremos el saldo actual.
		 	{
		 		System.out.println(cuenta  + "\n");
		 	}
		 	
		}
    }
}
 	