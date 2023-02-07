package cuentaCorriente;
import java.util.Scanner;



import java.util.ArrayList;
import java.util.List;

class Banco {

   
    public static void main(String[] args) {
    	
    
    	
    	CuentaCorriente ccc = new CuentaCorriente();
		
    	List<CuentaCorriente> listaCcc = new ArrayList<>();
    	Scanner entradaOpcion = new Scanner(System.in);
    	int opcion;
    	Boolean cerrarMenu = false;
    	while(!cerrarMenu) {  
    	MostrarMenu();
    
    	System.out.println("Introduza la opción deseada: ");
		 opcion = entradaOpcion.nextInt();
		System.out.println("[INFO] - Has seleccionado la opcion " + opcion);
		
		  
			 Scanner sc = new Scanner(System.in);
			   
				
					switch (opcion) {
				
					case 1:
						opcion = 1;
						listaCcc.add(ccc.CrearCuenta());					
						System.out.println("Cuenta creada: " + listaCcc.get(listaCcc.size()-1).toString());
						
						break;
					case 2:
						opcion = 2;
						listaCcc = ccc.IngresoCuenta(listaCcc);
						System.out.println("El dinero ha sido ingresado correctamente: Tu saldo actual es" +  listaCcc.get(listaCcc.size()-1).toString());
						break;
					case 3:
						opcion =3;
						System.out.println("Sacaste la cantidad deseada correctamente: Tu saldo actual es" +  listaCcc.get(listaCcc.size()-1).toString());;
						
						break;
					case 4:
						opcion =4;
						break;
					case 5:
						cerrarMenu = true;
						break;
						default:
			}
					
		} 
   
    
   
    	
//        Creamos la cuenta
//        Cuenta Cuenta1;
//        
//        Cuenta1 = new Cuenta(1 ,0.0);
//        
//        System.out.println( " Saldo de Cuenta " + totalCuenta + " €");
//       
//        // Consultamos el saldo
//        totalCuenta = Cuenta1.saldo();
//        
//       
//
//        // Hacemos un ingreso en la cuenta
//        double ingreso;
//        
//        System.out.println("Cuanto quiere Ingresar?");
//        Scanner sc = new Scanner(System.in);
//        ingreso = sc.nextDouble();
//                Cuenta1.depositar(ingreso);
//        
//        System.out.println("-------------------------------------------------");
//        
//        
//        // Consultamos el saldo de nuevo
//        totalCuenta = Cuenta1.saldo();
//        System.out.println("Total actual en la cuenta: " + totalCuenta + " €");        
//        
    }
    
   
    
    public static void MostrarMenu() {
        System.out.println("\n\n\n\n\t\t\t");
        System.out.println(" 	 ╔══════════════════════════════╗");
        System.out.println("     ║             MENU             ║");
        System.out.println("     ╠══════════════════════════════╣");
        System.out.println("	 ║                              ║");
        System.out.println("	 ║    1.- Elegir Cuenta         ║");
        System.out.println("	 ║    2.- Ingresar dinero       ║");
        System.out.println("	 ║    3.- Retirar dinero        ║");
        System.out.println("	 ║    4.- Modificar Datos       ║");
        System.out.println("	 ║                              ║");
        System.out.println("	 ║          0) Salir            ║");
        System.out.println("	 ║                              ║");
        System.out.println("	 ╚══════════════════════════════╝");
        System.out.println("	 Introduce una opción: ");
    
        
    }
    
}