package it.unibs.fp.PgAr2022_LilMain_CodiceFiscale;

public class Persona {
	
	private String cognome;
	private String nome;
	private String sesso;
	private String comuneNascita;
	private Comune comune;


	private int giorno;
	private int mese;
	private int anno;
	private String CF;
	
	private boolean checkCF = false;
	
	

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
	public boolean isCheckCF() {
		return checkCF;
	}
	public void setCheckCF(boolean checkCF) {
		this.checkCF = checkCF;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public Comune getComune() {
		return comune;
	}
	public void setComune(Comune comune) {
		this.comune = comune;
	}
	
	
	
public void generaCF(){
		
		String cognomeCF = "";
		String nomeCF = "";
		String cons = "";
		String voc = "";
		String meseCF = "";
		String giornoESessoCF = "";
		String comuneCF= "";
		String carattereControllo = "";
		
	
		
	//cognome CF
		//....
		for (int i = 0; i < cognome.length() && cognomeCF.length() < 3 ; i++) {
			if(cognome.charAt(i)!='a' && cognome.charAt(i)!='e' && cognome.charAt(i)!='i' && cognome.charAt(i)!='o' && cognome.charAt(i)!='u' &&
					cognome.charAt(i)!='A' && cognome.charAt(i)!='E' && cognome.charAt(i)!='I' && cognome.charAt(i)!='O' && cognome.charAt(i)!='U') //aggiunge solo le consonanti fino a max 3
			{
				cognomeCF+=cognome.charAt(i);
			}
			
				} 
		
		while(cognomeCF.length() < 3 ){
			for (int i = 0; i < cognome.length() && cognomeCF.length() < 3 ; i++) {
				if(cognome.charAt(i)=='a' && cognome.charAt(i)=='e' && cognome.charAt(i)=='i' && cognome.charAt(i)=='o' && cognome.charAt(i)=='u' &&
						cognome.charAt(i)=='A' && cognome.charAt(i)=='E' && cognome.charAt(i)=='I' && cognome.charAt(i)=='O' && cognome.charAt(i)=='U')
				{ cognomeCF += cognome.charAt(i); }
									
				} 
			
			cognomeCF += 'X'; // aggiunge la X se non ci sono abbastanza lettere

			} // aggiunge vocali in caso ci siano meno di 3 consonanti
		
		
		
	//nomeCF
		//....
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
						voc += nome.charAt(i);
					}
					
				}
				nomeCF = nomeCF + cons + voc;
				if(nomeCF.length()<3) nomeCF+='X';// se il cognome ha meno di 3 lettere aggiunge una X
}
		
			
	//annoCF
		//....
			int annoCFN = anno % 100;
			String annoCF = Integer.toString(annoCFN);
			
			
			
	//meseCF
		//....
			switch(mese) {// assegna le lettere ai mesi
			case 1:
				meseCF = "A";
				break;
			case 2:
				meseCF = "B";
				break;
			case 3:
				meseCF = "C";
				break;
			case 4:
				meseCF = "D";
				break;
			case 5:
				meseCF = "E";
				break;
			case 6:
				meseCF = "H";
				break;
			case 7: 
				meseCF = "L";
				break;
			case 8: 
				meseCF = "M";
				break;
			case 9:
				meseCF = "P";
				break;
			case 10:
				meseCF = "R";
				break;
			case 11: 
				meseCF = "S";
				break;
			case 12: 
				meseCF = "T";
				break;
				
			}
	
	//giornoCF e sessoCF
		//....
			switch(sesso) {
			case "M":
				
					giornoESessoCF=Integer.toString(giorno);
					if(giornoESessoCF.length()<2) giornoESessoCF = "0" + giornoESessoCF; //se il giorno è compreso tra 1 e 9 aggiunge zero davanti
				break;
			
			case "F":
					giornoESessoCF=Integer.toString(giorno+40);
					if(giornoESessoCF.length()<2) giornoESessoCF = "0" + giornoESessoCF;
				break;
			}
			
			
	//comune di nascita CF
			comuneCF = comune.getCodice();
			
	// codice fiscale senza carattere di controllo		
			String CFTemporaneo = "";
			CFTemporaneo = cognomeCF + nomeCF + annoCF + meseCF + giornoESessoCF + comuneCF;
			
			
	//carattere di controllo CF
		
			int caratterePari = 0;
			int  carattereDispari = 0;
			int sommaPariEDispari = 0;

			for(int i = 0; i < CFTemporaneo.length(); i++) {
				if(i%2==0) {
					switch(CFTemporaneo.charAt(i)) {
					case '0' :
						 caratterePari  += 0;
						break;
					case '1':
						 caratterePari  += 1;
						break;
					case '2':
						 caratterePari  += 2;
						break;
					case '3':
						 caratterePari  += 3;
						break;
					case '4':
						 caratterePari  += 4;
						break;
					case '5':
						 caratterePari  += 5;
						break;
					case '6':
						 caratterePari  += 6;
						break;
					case '7':
						 caratterePari += 7;
						break;
					case '8':
						 caratterePari  += 8;
						break;
					case '9':
						 caratterePari  += 9;
						break;
					case 'A':
						 caratterePari  += 0;
						break;
					case 'B':
						 caratterePari  += 1;
						break;
					case 'C':
						 caratterePari  += 2;
						break;
					case 'D':
						 caratterePari  += 3;
						break;
					case 'E':
						 caratterePari  += 4;
						break;
					case 'F':
						 caratterePari  += 5;
						break;
					case 'G':
						 caratterePari += 6;
						break;
					case 'H' :
						 caratterePari  += 7;
						break;
					case 'I' :
						 caratterePari  += 8;
						break;
					case 'J' :
						 caratterePari  += 9;
						break;
					case 'K' :
						 caratterePari  += 10;
						break;
					case 'L' :
						 caratterePari  += 11;
						break;
					case 'M' :
						 caratterePari  += 12;
						break;
					case 'N' :
						 caratterePari  += 13;
						break;
					case 'O' :
						 caratterePari  += 14;
						break;
					case 'P' :
						 caratterePari  += 15;
						break;
					case 'Q' :
						 caratterePari  += 16;
						break;
					case 'R' :
						 caratterePari  += 17;
						break;
					case 'S' :
						 caratterePari  += 18;
						break;
					case 'T' :
						 caratterePari  += 19;
						break;
					case 'U' :
						 caratterePari  += 20;
						break;
					case 'V' :
						 caratterePari  += 21;
						break;
					case 'W' :
						 caratterePari  += 22;
						break;
					case 'X' :
						 caratterePari  += 23;
						break;
					case 'Y' :
						 caratterePari  += 24;
						break;
					case 'Z' :
						 caratterePari  += 25;
						break;
					}
					
					
				}
				else {
					switch(CFTemporaneo.charAt(i)) {
					case '0' :
						carattereDispari  += 1;
						break;
					case '1':
						carattereDispari  += 0;
						break;
					case '2':
						carattereDispari  += 5;
						break;
					case '3':
						carattereDispari += 7;
						break;
					case '4':
						carattereDispari  += 9;
						break;
					case '5':
						carattereDispari  += 13;
						break;
					case '6':
						carattereDispari  += 15;
						break;
					case '7':
						carattereDispari += 17;
						break;
					case '8':
						carattereDispari += 19;
						break;
					case '9':
						carattereDispari  += 21;
						break;
					case 'A':
						carattereDispari  += 1;
						break;
					case 'B':
						carattereDispari  += 0;
						break;
					case 'C':
						carattereDispari += 5;
						break;
					case 'D':
						carattereDispari  += 7;
						break;
					case 'E':
						carattereDispari  += 9;
						break;
					case 'F':
						carattereDispari += 13;
						break;
					case 'G':
						carattereDispari  += 15;
						break;
					case 'H' :
						carattereDispari += 17;
						break;
					case 'I' :
						carattereDispari  += 19;
						break;
					case 'J' :
						carattereDispari  += 21;
						break;
					case 'K' :
						carattereDispari  += 2;
						break;
					case 'L' :
						carattereDispari  += 4;
						break;
					case 'M' :
						carattereDispari += 18;
						break;
					case 'N' :
						carattereDispari += 20;
						break;
					case 'O' :
						carattereDispari  += 11;
						break;
					case 'P' :
						carattereDispari  += 3;
						break;
					case 'Q' :
						carattereDispari  += 6;
						break;
					case 'R' :
						carattereDispari  += 8;
						break;
					case 'S' :
						carattereDispari  += 12;
						break;
					case 'T' :
						carattereDispari  += 14;
						break;
					case 'U' :
						carattereDispari  += 16;
						break;
					case 'V' :
						carattereDispari  += 10;
						break;
					case 'W' :
						carattereDispari += 22;
						break;
					case 'X' :
						carattereDispari  += 25;
						break;
					case 'Y' :
						carattereDispari += 24;
						break;
					case 'Z' :
						carattereDispari  += 23;
						break;
					}
					
				}
				
			}
			
			sommaPariEDispari = caratterePari + carattereDispari;
	
			int codiceIdentificativo=0;
			codiceIdentificativo = sommaPariEDispari%26;
			
			switch(codiceIdentificativo) {
			case 0:
				carattereControllo = "A";
				break;
			case 1:
				carattereControllo = "B";
				break;
			case 2:
				carattereControllo = "C";
				break;
			case 3:
				carattereControllo = "D";
				break;
			case 4:
				carattereControllo = "E";
				break;
			case 5:
				carattereControllo = "F";
				break;
			case 6:
				carattereControllo = "G";
				break;
			case 7:
				carattereControllo = "H";
				break;
			case 8:
				carattereControllo = "I";
				break;
			case 9:
				carattereControllo = "J";
				break;
			case 10:
				carattereControllo = "K";
				break;
			case 11:
				carattereControllo = "L";
				break;
			case 12:
				carattereControllo = "M";
				break;
			case 13:
				carattereControllo = "N";
				break;
			case 14:
				carattereControllo = "O";
				break;
			case 15:
				carattereControllo = "P";
				break;
			case 16:
				carattereControllo = "Q";
				break;
			case 17:
				carattereControllo = "R";
				break;
			case 18:
				carattereControllo = "S";
				break;
			case 19:
				carattereControllo = "T";
				break;
			case 20:
				carattereControllo = "U";
				break;
			case 21:
				carattereControllo = "V";
				break;
			case 22:
				carattereControllo = "W";
				break;
			case 23:
				carattereControllo = "X";
				break;
			case 24:
				carattereControllo = "Y";
				break;
			case 25:
				carattereControllo = "Z";
				break;
			}
			
				String CodiceFiscale = CFTemporaneo + carattereControllo;
				this.CF = CodiceFiscale;
}

}

