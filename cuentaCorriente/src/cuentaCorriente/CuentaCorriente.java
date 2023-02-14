package cuentaCorriente;
import java.util.ArrayList;
import java.util.Scanner;



import java.util.List;

/**
 * Modelos de las cuetnas corrientes a gestionar 
 * 
 */
public class CuentaCorriente {
	/*CONSTRUCTORES
	 * 	 
	 *  PARA ESTA PRACTICA NO ME HACE FALTA CREAR UN CONSTRUCTOR CON CAMPOS ESPECIFICOS 
	 *	Por lo tanto no hace falta crear ningun constructor puesto que se quedaria por defecto,
	 *	es decir el primero que aparece en el comentario, aunque no se vea, es el que usa.	
	 *--------------------------------------------------------------------------------*
	 *	public CuentaCorriente() {
		super();
	}
	public CuentaCorriente(String dniTit, String nombreTitual, double saldo) {
		super();
		this.dniTit = dniTit;
		this.nombreTitual = nombreTitual;
		this.saldo = saldo;
	}*/
	
	//Atrributos	
    private String dniTit;
    private String nombreTitular;
    private double saldo;
    private int contador;
    
    //Getters y Setters
    
	public String getDniTit() {
		return dniTit;
	}	
	public void setDniTit(String dniTit) {
		this.dniTit = dniTit;
	}
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}		
	
	
	
	@Override
	public String toString() {
		return "CuentaCorriente [dni del Titular=" + dniTit + ", nombre del Titular=" + nombreTitular + ", saldo=" + saldo + "]";
	}
	public CuentaCorriente() {
		super();
		// TODO Auto-generated constructor stub
		
		
		//Metodos
	}	
	public static CuentaCorriente CrearCuenta() {
		System.out.println("Crear cuenta: ");
		Scanner entradaDniTit = new Scanner(System.in);	
		Scanner entradaNombreTitular = new Scanner(System.in);	
		String opcionEntradaDniTit;
		String opcionEntradaNombreTitular;
		System.out.println("Introduza el DNI del titular: ");
		opcionEntradaDniTit = entradaDniTit.next();
		System.out.println("Introduza el nombre completo del titular: ");
		opcionEntradaNombreTitular = entradaNombreTitular.next();
		
		//Opción 1, constructor vacío
		CuentaCorriente cccVacio = new CuentaCorriente();
		cccVacio.setDniTit(opcionEntradaDniTit);
		cccVacio.setNombreTitular(opcionEntradaNombreTitular);
		cccVacio.setSaldo(0);
		return cccVacio;
		
	}
		
	//este Metodo devulve una lista de tipo CuentaCorriente, sirve para modificar los datos de saldo, con el cual podremos ingresar dinero
	//buscara la cuenta atraves del dni una vez encontrada te dara la opcion de ingresar dinero
	public List<CuentaCorriente> IngresoCuenta(List<CuentaCorriente> bd)  {
		
		System.out.println("INGRESAR CUENTA: ");
		Scanner entradaDni = new Scanner(System.in);
		System.out.println("Indique dni de cuenta: ");
		String buscaDniTit = entradaDni.next();
		//buscar la cuenta	

		if(BuscaCuenta(buscaDniTit,bd)) {
			System.out.println("Indique saldo a ingresar: ");
			Scanner entradaIngreso = new Scanner(System.in);
			double ingreso = entradaIngreso.nextDouble();
			double saldoActual = bd.get(contador).getSaldo();
			bd.get(contador).setSaldo(saldoActual+ingreso);
			double saldoNuevo = saldoActual+ingreso;
			System.out.println("Saldo anterior: "+saldoActual+"Saldo nuevo: "+ingreso);
			return bd;
		}
		//en caso de error al buscar la cuenta saldra este mensaje avisandono de que la cuenta esta mal o no exite
		else System.err.println("No existe cuenta para el dni indicaco: "+buscaDniTit);
			return bd;		
	}
	//este Metodo devulve una lista de tipo CuentaCorriente, sirve para modificar los datos de saldo, con el cual podremos sacar dinero
	//buscara la cuenta atraves del dni una vez encontrada te dara la opcion de ingresar dinero
	public List<CuentaCorriente> SacarCuenta(List<CuentaCorriente> bd){
		
		//buscamos la cuenta primero
		
		System.out.println("INGRESO CUENTA: ");
		//para ello pedimos el dni
		Scanner entradaDni = new Scanner(System.in);
		System.out.println("Indique dni de cuenta: ");
		String buscaDniTit = entradaDni.next();
		//al introdudcir con este bucle busca la cuenta comprobando el dni 
				
		// aqui ya decimos cuanto saldo queremos sacar mira y resta lo que decidimo sacar
		if(BuscaCuenta(buscaDniTit,bd)) {
			System.out.println("Indique saldo a sacar: ");
			Scanner entradaSacar = new Scanner(System.in);
			double sacar = entradaSacar.nextDouble();
			double saldoActual = bd.get(contador).getSaldo();
			bd.get(contador).setSaldo(saldoActual-sacar);
			double saldoNuevo = saldoActual-sacar;
			System.out.println("Saldo anterior: "+saldoActual+"Saldo nuevo: "+sacar);
		}
		//en caso de error al buscar la cuenta saldra este mensaje avisandono de que la cuenta esta mal o no exite
		else {
			System.err.println("No existe cuenta para el dni indicaco: "+buscaDniTit);
			return bd;
		}
		return bd;
	}
	//este metodo devolvera una lista de tip CuentaCorriente en la cual se veran reflejados los datos de la cuenta que deseamos ver 
	// buscara los datos de la cuenta atraves del dni como hemos dicho en las anterires veces
	public String MostrarCuenta(List<CuentaCorriente> bd){
		String datos="";
		Scanner encontrarDNI=new Scanner(System.in);
		System.out.println("Introduzca su dni: ");
		String buscaDNI=encontrarDNI.next();
		//si busca cuenta si existe mostrara los datos dni nombre y saldo		
		if(BuscaCuenta(buscaDNI,bd)) {
			String dniTit=bd.get(contador).getDniTit();
			String nombreTitular=bd.get(contador).getNombreTitular();
			double saldo=bd.get(contador).getSaldo();
			datos=("Numero dni del titular: "+dniTit+"; Nombre del Titular: "+nombreTitular+"; Saldo de la cuenta: "+saldo);	 
		}
		//si no encuentra la cuenta dara error
		else System.err.println("No se ha encontrado la cuenta.");
		return datos;
	}
		//este metodo es el que utilizaramos todo el tiempo para buscar la cuenta utilizando el dni como referencia
		
		private boolean BuscaCuenta (String DNI,List<CuentaCorriente> bd) {
			//se declara un contador a 0
			 contador=0;
			//recorro la lista en busca del dni que sea igual en ella.
			for (int i = 0; i < bd.size(); i++) {
				//Que significa la siguiente linea:
				//1.De la lista va buscando cada cuenta y de cada cuenta el dni y lo guarda en una variable.
				String nuevoDNI=bd.get(i).getDniTit();
				//2.Si el DNI que se ha guardado es igual al que se ha introducido devuelve true
				//Se usa el equals poque con == no funciona bien con strings.
				if(nuevoDNI.equals(DNI)) 
					return true;
				
				//Aumenta el contador cada vuelta hasta que se de true.
				contador++;
			}
			return false;
		}	

}

	

	
	
	
	