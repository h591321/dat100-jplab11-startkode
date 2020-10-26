package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {
	
	Innlegg[] innleggtabell;
	int nesteledige;
	int lengde;
	
	public Blogg() {
		this.innleggtabell=new Innlegg[20];
		nesteledige=0;
	}

	public Blogg(int lengde) {
		this.innleggtabell=new Innlegg[lengde];
		nesteledige=0;
		this.lengde=lengde;
	}

	public int getAntall() {
		return nesteledige;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int ret=-1;
		for(int i=0;i<nesteledige;i++) {
			if(innlegg.erLik(innleggtabell[i])) {ret=i;}
		}
		return ret;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean fins=false;
		for(int i=0;i<nesteledige;i++) {
			if(innlegg.erLik(innleggtabell[i])) {fins=true;}
		}
		return fins;
	}

	public boolean ledigPlass() {
		boolean ledig=true;
		if(lengde<=nesteledige) {ledig=false;}
		return ledig;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil=false;
		
		if(!finnes(innlegg)) {
			innleggtabell[nesteledige]=innlegg;
			lagtTil=true;
			nesteledige++;
		}
		return lagtTil;
	}
	
	public String toString() {
		String ut=nesteledige+"\n";
		for(int i=0;i<nesteledige;i++) {
			ut+=innleggtabell[i].toString();
		}
		return ut;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}