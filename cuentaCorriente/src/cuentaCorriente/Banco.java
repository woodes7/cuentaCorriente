package cuentaCorriente;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Banco {

   
    public static void main(String[] args) {
    	
    
    	//Instancio Cuenta Corriente
    	CuentaCorriente ccc = new CuentaCorriente();
    	//Lista que funciona como base de datos ,se guardaran todas las cuentas.
    	List<CuentaCorriente> listaCcc = new ArrayList<>();
    	Scanner entradaOpcion = new Scanner(System.in);
    	// declaraciones de las opciones de menu
    	int opcion;
    	Boolean cerrarMenu = false; 
    	    	
     	do {
     	 //mostrara menu
     	MostrarMenu();
     	//entrada de la opcion del menu que desamos realizar
    	System.out.println("Introduza la opción deseada: ");
		 opcion = entradaOpcion.nextInt();
		System.out.println("[INFO] - Has seleccionado la opcion " + opcion);
		
				//este switch es para  elegir las opciones del menu
					switch (opcion) {
				
					case 1:
						//Opcion crear cuenta devolvera luego los datos grabados en la cuenta
						opcion = 1;								
						listaCcc.add(ccc.CrearCuenta());
						System.err.println("Se ha creado la cuenta.");
						System.out.println("Cuenta creada: " + listaCcc.get(listaCcc.size()-1).toString());
						break;
					case 2: //opcion ingresar en cuenta, llamara al metodo IngresCuenta, al terminar devolvera el saldo ingresado en la cuenta
						opcion = 2; 
						listaCcc = ccc.IngresoCuenta(listaCcc);
						System.out.println("El dinero ha sido ingresado correctamente: Tu saldo actual es" +  listaCcc.get(listaCcc.size()-1).toString());
						break;
					case 3:	//Opcion sacar dinero de cuenta, llamara al metodo SacarCuenta, al terminar devolvera el saldo sacado, y includo si se queda en negativo 
						opcion =3;  
						listaCcc = ccc.SacarCuenta(listaCcc);
						System.out.println("Sacaste la cantidad deseada correctamente: Tu saldo actual es" +  listaCcc.get(listaCcc.size()-1).toString());;
						
						break;
					case 4: //Opcion MOstrar cuenta , llamara al metodo MostrarCuenta, devolvera los datos de la cuenta buscada.
						opcion =4;						
						System.out.println(ccc.MostrarCuenta(listaCcc));
						break;
					case 5: //opcion cerrar menu
						cerrarMenu = true;
						break;
						default:
					}	
					}while(!cerrarMenu);  
	 		             	
    }   
   
    
    //este metodo es para mostrar el menu del cajero del banco
    public static void MostrarMenu() {
        System.out.println("\n\n\n\n\t\t\t");
        System.out.println(" 	 ╔══════════════════════════════╗");
        System.out.println("         ║             MENU             ║");
        System.out.println("         ╠══════════════════════════════╣");
        System.out.println("	 ║                              ║");
        System.out.println("	 ║    1.- Crear Cuenta          ║");
        System.out.println("	 ║    2.- Ingresar dinero       ║");
        System.out.println("	 ║    3.- Sacar dinero          ║");
        System.out.println("	 ║    4.- Mostrar Cuenta        ║");
        System.out.println("	 ║                              ║");
        System.out.println("	 ║          5) Salir            ║");
        System.out.println("	 ║                              ║");
        System.out.println("	 ╚══════════════════════════════╝");
        System.out.println("	 Introduce una opción: ");
    
        
    }
    
}