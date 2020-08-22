package ui;
import modelo.MiBarrioTeQuiere;
import java.util.Scanner;
import exceptions.UnderageException;
import exceptions.WrongDayException;
public class Menu{

	private MiBarrioTeQuiere miBarrio;
	public static final int SALIR = 3;

	Scanner i = new Scanner(System.in);


	public Menu(){
		miBarrio = new MiBarrioTeQuiere();
		showWelcome();
		manageMenu();
	}


	public void manageMenu(){
		int option;
		do{
			showMenu();
			option =Integer.parseInt(i.nextLine());
			//i.nextLine();
			doOperation(option);

		}while(option != SALIR);


	}

	public void doOperation(int option){

		switch(option){

		case 1:
			registrarPersona();
			break;

		case 2:
			consultarIntentos();
			break;

		case 3:
			bye();
			break;


		default: error();

		}
	}

	public void registrarPersona() {
		try {
		mensajeRegistrar();
		int numero;
		String tipo;

		System.out.println("Digite el numero de identidad ");
		numero = Integer.parseInt(i.nextLine());		
		System.out.println("Digite el tipo");
		System.out.println("TI");
		System.out.println("CC");
		System.out.println("PP");
		System.out.println("CE");
		tipo = i.nextLine();
		boolean salir = false;
		while(!salir) {

			if(tipo.equalsIgnoreCase("TI")) {
				salir = true;
			}else if(tipo.equalsIgnoreCase("CC")) {
				salir = true;
			}else if(tipo.equalsIgnoreCase("PP")) {
				salir = true;
			}else if(tipo.equalsIgnoreCase("CE")) {
				salir = true;
			}else {
				System.out.println("Ingrese una opcion valida");
				tipo = i.nextLine();

			}

		}
		try {

			miBarrio.registrarPersona(tipo, numero);
			System.out.println("\nRegistro exitoso");
		}catch(WrongDayException wre) {
			System.out.println("Hoy no puede ingresar al establecimiento");
		}catch(UnderageException uae) {
			System.out.println("Los menores de edad no pueden ingresar al establecimiento. ");
			manageMenu();
		}
		}catch(NumberFormatException nfe) {
			System.out.println("Ingrese un formato valido porfavor");
			manageMenu();
		}
	}

	public void consultarIntentos() {


		System.out.println("\nIntentos totales de ingreso: "+ miBarrio.ConsultarIntentos());

	}


	public void showMenu(){
		System.out.println("\n");
		System.out.println("1. Registrar persona. ");
		System.out.println("2. Consultar cantidad de intentos de ingreso.");
		System.out.println("3. Salir.");
	}


	public void showWelcome(){
		System.out.println("\n");

		System.out.println("Bienvenido");
	}

	public void mensajeRegistrar() {
		System.out.println("\n");

		System.out.println("Registrar Persona. ");

	}

	public void error(){
		System.out.print("Seleccione una opcion disponbile ");
	}

	public void bye(){

		System.out.println("Adios");
	}
}