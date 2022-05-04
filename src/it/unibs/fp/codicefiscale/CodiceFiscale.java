package it.unibs.fp.codicefiscale;

public class CodiceFiscale {
	String cognome = new String();
	String nome = new String();
	int anno;
	int giorno;
	String mese = new String();
	String luogoNS = new String(); //lettera luogo nascita
	int[] luogoNI = new int[3]; //cifra luogo nascita
	String carControllo = new String();
	
	
}

CodiceFiscale generaCF(Persona Persona){
	this.anno = Persona.anno % 100;
}
