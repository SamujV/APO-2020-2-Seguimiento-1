package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.UnderageException;
import exceptions.WrongDayException;

public class MiBarrioTeQuiereTest {

	private MiBarrioTeQuiere miBarrioTest;


	// Tener en cuenta que los numeros de documentos elegidos para las pruebas
	// estan pensados para pasarlas correctamente en un dia par 
	public void setupScenary1() {

		miBarrioTest = new MiBarrioTeQuiere();	
	}

	public void setupScenary2() {
		try {
			miBarrioTest = new MiBarrioTeQuiere();	
			miBarrioTest.registrarPersona("cc", 15194);
			miBarrioTest.registrarPersona("cp", 13572);
			miBarrioTest.registrarPersona("ce", 452155);

		}catch(UnderageException uae) {
			fail("");
		} catch (WrongDayException e) {
			fail("");
		}

	}

	@Test
	public void testRegistrarPersona_1() {
		setupScenary1();

		try {
			miBarrioTest.registrarPersona("cc", 10034);
			miBarrioTest.registrarPersona("ce", 144494);

			assertEquals("cc", miBarrioTest.getPersonas().get(0).getTipoDoc());
			assertEquals(10034, miBarrioTest.getPersonas().get(0).getNumero());
			assertEquals("ce", miBarrioTest.getPersonas().get(1).getTipoDoc());
			assertEquals(144494, miBarrioTest.getPersonas().get(1).getNumero());


		}catch(WrongDayException wre) {
			fail("WrongDayException was not expected here");
		}catch(UnderageException uae) {
			fail("UnderageException was not expected here");
		}		
	}


	@Test
	public void testRegistrarPersona_2() {
		setupScenary2();
		int agregados = miBarrioTest.getPersonas().size();
		try {
			miBarrioTest.registrarPersona("ti", 14592);
			fail("UnderageException was expected here ");


		}catch(WrongDayException wre) {
			fail("WrongDayException was not expected here");
		}catch(UnderageException uae) {
			assertTrue(agregados == miBarrioTest.getPersonas().size(),"The person shouldn't have been added");
		}		
	}


	@Test
	public void testRegistrarPersona_3() {
		setupScenary2();
		int agregados = miBarrioTest.getPersonas().size();
		try {
			miBarrioTest.registrarPersona("cc", 10024); 
			fail("WrongDayException was expected here ");


		}catch(WrongDayException wre) {
			assertTrue(agregados == miBarrioTest.getPersonas().size(),"The person shouldn't have been added because of the law");
		}catch(UnderageException uae) {
			fail("UnderageException was not expected here");
		}		
	}


}
