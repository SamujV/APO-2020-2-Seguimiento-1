package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MiBarrioTeQuiere {
	public static final String TI = "ti";
	public static final String CC = "cc";
	public static final String PP = "pp";
	public static final String CE = "ce";
	List<Persona> personas ;
	
	private int intentosDeIngreso;
	private int diaDelMes;

	public MiBarrioTeQuiere() {
		personas = new ArrayList<>();
		diaDelMes = LocalDate.now().getDayOfMonth();
		intentosDeIngreso = 0;
	}
	
	
	public void registrarPersona(String tipoDoc, int numero) {
		
		String a = numero + "";
		int penultimoNum = Integer.parseInt(a.substring(a.length()-2,a.length()-1));
		
		if(tipoDoc != TI) {
			Persona p = new Persona(tipoDoc,numero);
			if(penultimoNum % 2 == 0 && diaDelMes % 2 == 1 ) {
				personas.add(p);
			}else if(penultimoNum % 2 == 1 && diaDelMes % 2 == 0) {
				personas.add(p);
			}			
		}		
		intentosDeIngreso++;
	}
	
	
	public int ConsultarIntentos() {
		return intentosDeIngreso;
	}
	
	
	
	
	
	
	
	
}
