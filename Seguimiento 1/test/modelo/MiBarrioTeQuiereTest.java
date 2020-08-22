package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.UnderageException;
import exceptions.WrongDayException;

public class MiBarrioTeQuiereTest {

	private MiBarrioTeQuiere miBarrio;

	
// Tener en cuenta que los numeros de documentos elegidos para las pruebas
// estan pensados para pasarlas correctamente en un dia par 
	public void setupScenary1() {
		
		miBarrio = new MiBarrioTeQuiere();	
	}
	
   public void setupScenary2() {
		try {
			miBarrio = new MiBarrioTeQuiere();	
			miBarrio.registrarPersona("cc", 116692);
			miBarrio.registrarPersona("cc", 116692);
			miBarrio.registrarPersona("cc", 116692);
	   	
		}catch(UnderageException uae) {
			fail("");
		} catch (WrongDayException e) {
			fail("");
		}
		
   }
	
	@Test
	void testRegistrarPersona_1() {
		setupScenary1();
		
		try {
			miBarrio.registrarPersona("cc", 10034);
			miBarrio.registrarPersona("ce", 144494);
			
			assertEquals("cc", miBarrio.getPersonas().get(0).getTipoDoc());
			assertEquals(10034, miBarrio.getPersonas().get(0).getNumero());
			assertEquals("ce", miBarrio.getPersonas().get(1).getTipoDoc());
			assertEquals(144494, miBarrio.getPersonas().get(1).getNumero());
			
				
		}catch(WrongDayException wre) {
			fail("WrongDayException was not expected here");
		}catch(UnderageException uae) {
			fail("UnderageException was not expected here");
		}		
	}
	
	
	@Test
	void testRegistrarPersona_2() {
		setupScenary2();
		int agregados = miBarrio.getPersonas().size();
		try {
			miBarrio.registrarPersona("ti", 10034);
			fail("UnderageException was expected here ");
						
				
		}catch(WrongDayException wre) {
			fail("WrongDayException was not expected here");
		}catch(UnderageException uae) {
			assertTrue(agregados == miBarrio.getPersonas().size(),"The person shouldn't have been added");
		}		
	}
	
	
	@Test
	void testRegistrarPersona_3() {
		setupScenary2();
		int agregados = miBarrio.getPersonas().size();
		try {
			miBarrio.registrarPersona("cc", 10024); 
			fail("WrongDayException was expected here ");
						
				
		}catch(WrongDayException wre) {
			assertTrue(agregados == miBarrio.getPersonas().size(),"The person shouldn't have been added because of the law");
		}catch(UnderageException uae) {
			fail("UnderageException was not expected here");
		}		
	}
	

}
