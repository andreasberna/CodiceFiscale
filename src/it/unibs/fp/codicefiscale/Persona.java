package it.unibs.fp.codicefiscale;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
public class Persona {
	
	private String cognome;
	private String nome;
	private String sesso;
	private String comuneNascita;
	private int giorno;
	private int mese;
	private int anno;
	
	public Persona(String cognome, String nome, String sesso, String comuneNascita, int giorno, int mese, int anno) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.sesso = sesso;
		this.comuneNascita = comuneNascita;
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		
	}
	
	
	


	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getGiorno() {
		return giorno;
	}
	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}
	public int getMese() {
		return mese;
	}
	public void setMese(int mese) {
		this.mese = mese;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}


	
String generaCF(){
		int annoCF = anno % 100;
		String cognomeCF = "";
		String nomeCF = "";
		String cons = null;
		String voc = null;
		char meseCF = ' ';
		
	
		for (int i = 0; i < cognome.length() && cognomeCF.length() < 3 ; i++) {
			if(cognome.charAt(i)!='a' && cognome.charAt(i)!='e' && cognome.charAt(i)!='i' && cognome.charAt(i)!='o' && cognome.charAt(i)!='u' &&
					cognome.charAt(i)!='A' && cognome.charAt(i)!='E' && cognome.charAt(i)!='I' && cognome.charAt(i)!='O' && cognome.charAt(i)!='U') //aggiunge solo le consonanti fino a max 3
			{
				cognomeCF+=cognome.charAt(i);
			}
			
				} // fine ciclo for
		
		while(cognomeCF.length() < 3 ){
			for (int i = 0; i < cognome.length() && cognomeCF.length() < 3 ; i++) {
				if(cognome.charAt(i)=='a' && cognome.charAt(i)=='e' && cognome.charAt(i)=='i' && cognome.charAt(i)=='o' && cognome.charAt(i)=='u' &&
						cognome.charAt(i)=='A' && cognome.charAt(i)=='E' && cognome.charAt(i)=='I' && cognome.charAt(i)=='O' && cognome.charAt(i)=='U')
				{ cognomeCF += cognome.charAt(i); }
									
				} // fine ciclo for
			
			cognomeCF += 'X'; // aggiunge la X se non ci sono abbastanza lettere

			} // aggiunge vocali in caso ci siano meno di 3 consonanti
		
		for(int i=0; i< nome.length(); i++) { //conta le consonanti
			if(nome.charAt(i)!='a' && nome.charAt(i)!= 'e' && nome.charAt(i)!= 'i' && nome.charAt(i)!='o' && nome.charAt(i)!='u' && 
					nome.charAt(i)!='A' && nome.charAt(i)!= 'E' && nome.charAt(i)!= 'I' && nome.charAt(i)!='O' && nome.charAt(i)!='U') {
				cons+= nome.charAt(i);
			}
		}
			if (cons.length()>= 4) { //se sono 4 o più prende la prima la terza e la quarta
				
				nomeCF = nomeCF + cons.charAt(0) + cons.charAt(2) + cons.charAt(3);
		}
			else if (cons.length()== 3) { // se sono 3 prende solo quelle
				nomeCF = nomeCF + cons.charAt(0) +  cons.charAt(1) +  cons.charAt(2);
			}
			else {//se sono meno di 3 prende anche le vocali a completare
				for(int i=0; i<nome.length(); i++) {
					if(nome.charAt(i)=='a' && nome.charAt(i)== 'e' && nome.charAt(i)== 'i' && nome.charAt(i)=='o' && nome.charAt(i)=='u' && 
							nome.charAt(i)=='A' && nome.charAt(i)== 'E' && nome.charAt(i)== 'I' && nome.charAt(i)=='O' && nome.charAt(i)=='U') {
						voc+= nome.charAt(i);
					}
					
				}
				nomeCF = nomeCF + cons + voc;
				if(nomeCF.length()<3) nomeCF+='X';// se il cognome ha meno di 3 lettere aggiunge una X
}
		
			switch(mese) {// assegna i char ai mesi
			case 1:
				meseCF = 'A';
				break;
			case 2:
				meseCF = 'B';
				break;
			case 3:
				meseCF = 'C';
				break;
			case 4:
				meseCF = 'D';
				break;
			case 5:
				meseCF = 'E';
				break;
			case 6:
				meseCF = 'H';
				break;
			case 7: 
				meseCF = 'L';
				break;
			case 8: 
				meseCF = 'M';
				break;
			case 9:
				meseCF = 'P';
				break;
			case 10:
				meseCF = 'R';
				break;
			case 11: 
				meseCF = 'S';
				break;
			case 12: 
				meseCF = 'T';
				break;
				
			}
}

}

