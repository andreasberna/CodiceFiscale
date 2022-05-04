package it.unibs.fp.codicefiscale;

import javax.xml.XMLConstants;
import javax.xml.crypto.Data;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLInputFactory;
import java.io.FileInputStream;
import java.util.ArrayList;


public class CodiceFiscaleMain {

	public static void main(String[] args) {
			
		ArrayList<Persona> persone = new ArrayList<Persona>();
		String nomePersona = null; //private?
		String cognomePersona = null;//private?
		String sessoPersona = null;//private?
		String comunePersona = null;//private?
		String dataPersona = null;//private?
		String annoS = null ;
		String meseS = null;
		String giornoS = null;
		int anno = 0 ;
		int mese = 0;
		int giorno = 0;
		String tipo = null;

		
		
			
			XMLInputFactory xmlif = null;
			XMLStreamReader xmlr = null;
			try {
			 xmlif = XMLInputFactory.newInstance();
			 xmlr = xmlif.createXMLStreamReader("inputPersone.xml", new FileInputStream("inputPersone.xml"));
			} catch (Exception e) {
			 System.out.println("Errore nell'inizializzazione del reader:");
			 System.out.println(e.getMessage());
			}

			
			try {
				while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
					 
					
					
					
					switch (xmlr.getEventType()) { // switch sul tipo di evento
					 case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
					 System.out.println("Start Read Doc " + "inputPersone"); break;
					 
					 case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
					 System.out.println("Tag " + xmlr.getLocalName());
					 tipo = xmlr.getLocalName(); //per capire che tipo di dato sta leggendo
					 for (int i = 0; i < xmlr.getAttributeCount(); i++) {
					 System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i)); 			
					 }
					
					 break;
					 
					 
					 case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
					 System.out.println("END-Tag " + xmlr.getLocalName()); break;
					 
					 case XMLStreamConstants.COMMENT:
					 System.out.println("// commento " + xmlr.getText()); break; // commento: ne stampa il contenuto
					 
					 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
						 if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
							 System.out.println("-> " + xmlr.getText()); 
						 
						//per capire se sta leggendo un nome o un cognome o una data...
						 switch(tipo) { //penso il programma sia sbagliato in questa parte,  i casi dei case
						 case "nome": 
						 {	
							 nomePersona = xmlr.getText();
							 break;
							 
						 } 
						 case "cognome":
						 {
							 cognomePersona = xmlr.getText();
							 break;
						 }  
						 
						 case "sesso":
						 {
							 sessoPersona = xmlr.getText();
							 break;
						 }  
						 
						 case "comune_nascita":
						 {
							 comunePersona = xmlr.getText();
							 break;
						 }  
						
						 case "data_nascita":
						 {
							 dataPersona = xmlr.getText(); //per convertire la data e "spezzarla"
							 char[] annoC = new char[4];
							 for(int j = 0 ; j < 4 ; j++)
								 annoC[j]=dataPersona.charAt(j);
							  annoS = String.copyValueOf(annoC) ;
							  
							 char[] meseC = new char[2];
							  meseC[0]=dataPersona.charAt(5);
							  meseC[1]=dataPersona.charAt(6);
							  meseS = String.copyValueOf(meseC) ;
							  
							 char[] giornoC = new char[2];
							  giornoC[0]=dataPersona.charAt(8);
							  giornoC[1]=dataPersona.charAt(9);
							  giornoS = String.copyValueOf(giornoC) ;
							  
							  anno = Integer.parseInt(annoS);
							  mese = Integer.parseInt(meseS);
							  giorno = Integer.parseInt(giornoS);
							
							  
							  Persona persona = new Persona(cognomePersona, nomePersona, sessoPersona, comunePersona, giorno, mese, anno); 
								persone.add(persona);
								break;
						 }  
						
											 
						 }
						
						 
						 break;
					 }
					 xmlr.next();
				}
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
			
		
			
			
		
			
			
		}
	

}
