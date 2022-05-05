package it.unibs.fp.PgAr2022_LilMain_CodiceFiscale;

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
		String nomeComune = null;
		String codiceComune = null;
		int anno = 0 ;
		int mese = 0;
		int giorno = 0;
		String tipo = null;

		
		
	//lettura inputPersone.xml
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
					 
					 tipo = xmlr.getLocalName(); //per capire che tipo di dato sta leggendo, servirà più avanti
					 
					 for (int i = 0; i < xmlr.getAttributeCount(); i++) {
					 System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i)); 			
					 }
					
					 break;
					 
					 
					 case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
					 System.out.println("END-Tag " + xmlr.getLocalName()); 
					 break;
					 
					 case XMLStreamConstants.COMMENT:
					 System.out.println("// commento " + xmlr.getText()); break; // commento: ne stampa il contenuto
					 
					 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
						 if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
							 System.out.println("-> " + xmlr.getText()); 
						
						//per capire se sta leggendo un nome o un cognome o una data...
						 switch(tipo) { 
						 case "nome": 
						 {	
							 if(!xmlr.getText().equals("\n        ")) {
								 nomePersona = xmlr.getText();
							 	}
							 
							 break;
							 
						 } 
						 case "cognome":
						 {
							 if(!xmlr.getText().equals("\n        ")) {
								 cognomePersona = xmlr.getText();
							 }
							 break;
						 }  
						 
						 case "sesso":
						 {
							 if(!xmlr.getText().equals("\n        ")) {
								 sessoPersona = xmlr.getText();
							 }
							 break;
						 }  
						 
						 case "comune_nascita":
						 {
							 if(!xmlr.getText().equals("\n        ")) {
								 comunePersona = xmlr.getText();
							 }
							 break;
						 }  
						
						 case "data_nascita": //qua dentro si crea direttamente la persona in quanto è l'ultimo attributo
						 {
							 if(!xmlr.getText().equals("\n        ")) {
								 dataPersona = xmlr.getText(); //per convertire la data e "spezzarla"
								 //se non funziona rimettere fuori dall'if
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
							  
							 }
							 
							 tipo = "niente";
							
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
	//fine lettura inputPersone.xml
			
			
	//lettura comuni.xml
			//....
			ArrayList<Comune> listaComuni = new ArrayList<>() ;
			
			XMLInputFactory xmlif2 = null;
			XMLStreamReader xmlr2 = null;
			try {
			 xmlif2 = XMLInputFactory.newInstance();
			 xmlr2 = xmlif2.createXMLStreamReader("comuni.xml", new FileInputStream("comuni.xml"));
			} catch (Exception e) {
			 System.out.println("Errore nell'inizializzazione del reader:");
			 System.out.println(e.getMessage());
			}
			
			
			try {
				while (xmlr2.hasNext()) { // continua a leggere finché ha eventi a disposizione
					
					switch (xmlr2.getEventType()) { // switch sul tipo di evento
					 case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
					 System.out.println("Start Read Doc " + "Comuni"); break;
					 
					 case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
					 System.out.println("Tag " + xmlr2.getLocalName());
					 
					 tipo = xmlr2.getLocalName(); //per capire che tipo di dato sta leggendo, servirà più avanti
					 
					 for (int i = 0; i < xmlr2.getAttributeCount(); i++) {
					 System.out.printf(" => attributo %s->%s%n", xmlr2.getAttributeLocalName(i), xmlr2.getAttributeValue(i)); 			
					 }
					
					 break;
					 
					 
					 case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
					 System.out.println("END-Tag " + xmlr2.getLocalName()); 
					 break;
					 
					 case XMLStreamConstants.COMMENT:
					 System.out.println("// commento " + xmlr2.getText()); break; // commento: ne stampa il contenuto
					 
					 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
						 if (xmlr2.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
							 System.out.println("-> " + xmlr2.getText()); 
						
						//per capire se sta leggendo un nome o un cognome o una data...
						 switch(tipo) { 
						 case "nome": 
						 {	
							 if(!xmlr2.getText().equals("\n        ")) {
								 nomeComune = xmlr2.getText();
								 
								 }
								 
								 
							 	}
							 
							 break;
							  
						 case "codice":
						 {
							 if(!xmlr2.getText().equals("\n        ")) {
								 codiceComune = xmlr2.getText();
								//se non funziona rimettere fuori dall'if 
								 Comune comune = new Comune(nomeComune, codiceComune); 

								 for(int i = 0 ; i < persone.size() ; i++) {
									 if(persone.get(i).getComuneNascita().equals(nomeComune))
										 persone.get(i).setComune(comune);
									 
									 
									listaComuni.add(comune);
							 }
				
							 break;
						 }  
						 		 
						 }
						 }
						 tipo = "niente";
						 
						 break;
					 }
					 xmlr2.next();
				}
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
			
	//lettura codiciFiscali.xml
		//....
			ArrayList<String> listaCF = new ArrayList<>() ;
			String CFTemp = null ;	
			
			XMLInputFactory xmlif3 = null;
			XMLStreamReader xmlr3 = null;
			try {
			 xmlif3 = XMLInputFactory.newInstance();
			 xmlr3 = xmlif3.createXMLStreamReader("codiciFiscali.xml", new FileInputStream("codiciFiscali.xml"));
			} catch (Exception e) {
			 System.out.println("Errore nell'inizializzazione del reader:");
			 System.out.println(e.getMessage());
			}
			
			
			try {
				while (xmlr3.hasNext()) { // continua a leggere finché ha eventi a disposizione
					
					switch (xmlr3.getEventType()) { // switch sul tipo di evento
					 case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
					 System.out.println("Start Read Doc " + "codiciFiscali"); break;
					 
					 case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
					 System.out.println("Tag " + xmlr3.getLocalName());
					 
					 tipo = xmlr3.getLocalName(); //per capire che tipo di dato sta leggendo, servirà più avanti
					 
					 for (int i = 0; i < xmlr3.getAttributeCount(); i++) {
					 System.out.printf(" => attributo %s->%s%n", xmlr3.getAttributeLocalName(i), xmlr3.getAttributeValue(i)); 			
					 }
					
					 break;
					 
					 
					 case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
					 System.out.println("END-Tag " + xmlr3.getLocalName()); 
					 break;
					 
					 case XMLStreamConstants.COMMENT:
					 System.out.println("// commento " + xmlr3.getText()); break; // commento: ne stampa il contenuto
					 
					 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
						 if (xmlr3.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
							 System.out.println("-> " + xmlr3.getText()); 
						
						//per capire se sta leggendo un nome o un cognome o una data...
						 switch(tipo) { 
						 
						 case "codice":
						 {
							 if(!xmlr3.getText().equals("\n        ")) {
								 CFTemp = xmlr3.getText();
								 	listaCF.add(CFTemp);
							 }
				
							 break;
						 }  
						 		 
						 }
						
						 tipo = "niente";
						 
						 break;
					 }
					 xmlr3.next();
				}
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
			
			
	
			
	//creazione CF e verifica corrispondenza con lista CF
		//....
			for(int i = 0; i < persone.size() ; i++) {
				persone.get(i).generaCF();
				
				for(int j = 0 ; j < listaCF.size() ; j++) {
					if(persone.get(i).getCF().equals(listaCF.get(j)))
						persone.get(i).setCheckCF(true);
					
					if(!persone.get(i).isCheckCF()) {
						System.out.println("Manca il CF di" + persone.get(i).getNome()); //test
					}
				}
			}
			
			
			
			
		}
	
}
:D
