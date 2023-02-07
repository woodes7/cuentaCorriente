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
    
    //Getters y Setters
    
	public String getDniTit() {
		return dniTit;
	}
	public void setDniTit(String dniTit) {
		this.dniTit = dniTit;
	}
	public String getNombreTitual() {
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
    
	
	public String toString() {
		return "CuentaCorriente [dniTit=" + dniTit + ", nombreTitular=" + nombreTitular + ", saldo=" + saldo + "]";
	}
	public CuentaCorriente() {
		super();
		// TODO Auto-generated constructor stub
		
		
		//Metodos
	}
	public static CuentaCorriente CrearCuenta() {
		System.out.println("CREAR CUENTA: ");
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

	public List<CuentaCorriente> IngresoCuenta(List<CuentaCorriente> bd)  {
		
		System.out.println("INGRESAR CUENTA: ");
		Scanner entradaDni = new Scanner(System.in);
		System.out.println("Indique dni de cuenta: ");
		String opcionEntradaDni = entradaDni.next();
		//buscar la cuenta
		int contador = 0;
		boolean esEncontrado = false;
		for(CuentaCorriente cuenta: bd) {			
			String dniBd = cuenta.getDniTit();
			if(dniBd.equals(opcionEntradaDni)) {
				esEncontrado = true;
				break;
			}
			contador++;			
		}		

		if(esEncontrado) {
			System.out.println("Indique saldo a ingresar: ");
			Scanner entradaIngreso = new Scanner(System.in);
			double ingreso = entradaIngreso.nextDouble();
			double saldoActual = bd.get(contador).getSaldo();
			bd.get(contador).setSaldo(saldoActual+ingreso);
			double saldoNuevo = saldoActual+ingreso;
			System.out.println("Saldo anterior: "+saldoActual+"Saldo nuevo: "+ingreso);
		}else {
			System.out.println("No existe cuenta para el dni indicaco: "+opcionEntradaDni);
			return bd;
		}
		return bd;
	}
	

	public static ArrayList<CuentaCorriente> MostrarCuentaUsuario(String dniUsuario) {
		
		return null;
	}
	public List<CuentaCorriente> SacarCuenta(List<CuentaCorriente> bd){
		
		//buscamos la cuenta primero
		
		System.out.println("INGRESO CUENTA: ");
		//para ello pedimos el dni
		Scanner entradaDni = new Scanner(System.in);
		System.out.println("Indique dni de cuenta: ");
		String opcionEntradaDni = entradaDni.next();
		//al introdudcir con este bucle busca la cuenta comprobando el dni sino esta craria la cuenta 
		int contador = 0;
		boolean esEncontrado = false;
		for(CuentaCorriente cuenta: bd) {			
			String dniBd = cuenta.getDniTit();
			if(dniBd.equals(opcionEntradaDni)) {
				esEncontrado = true;
				break;
			}
			contador++;			
		}		
		// aqui ya decimos cuanto saldo queremos sacar mira y resta lo que decidimo sacar
		if(esEncontrado) {
			System.out.println("Indique saldo a sacar: ");
			Scanner entradaSacar = new Scanner(System.in);
			double sacar = entradaSacar.nextDouble();
			double saldoActual = bd.get(contador).getSaldo();
			bd.get(contador).setSaldo(saldoActual-sacar);
			double saldoNuevo = saldoActual-sacar;
			System.out.println("Saldo anterior: "+saldoActual+"Saldo nuevo: "+sacar);
		}else {
			System.out.println("No existe cuenta para el dni indicaco: "+opcionEntradaDni);
			return bd;
		}
		return bd;
	}
	}
	
	

	
	
	
	