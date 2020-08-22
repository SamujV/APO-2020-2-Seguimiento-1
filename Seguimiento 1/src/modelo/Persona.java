package modelo;

public class Persona {

	private String tipoDoc;
	private int numero;

	public Persona(String tipoDoc, int numero) {
		this.tipoDoc = tipoDoc;
		this.numero = numero;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public int getNumero() {
		return numero;
	}



}
