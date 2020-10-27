package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {
	
	Innlegg[] innleggtabell;
	int nesteledige;

	
	public Blogg() {
		this.innleggtabell=new Innlegg[20];
		nesteledige=0;
	}

	public Blogg(int lengde) {
		this.innleggtabell=new Innlegg[lengde];
		nesteledige=0;
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
		if(innleggtabell.length<=nesteledige) {ledig=false;}
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
		Innlegg[] utvidet = new Innlegg[innleggtabell.length*2];
		
		for(int i=0;i<innleggtabell.length;i++) {
			utvidet[i]=innleggtabell[i];
		}
		innleggtabell=utvidet;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean innlagt=false;
		
		if(!finnes(innlegg)&&ledigPlass()) {
			if(leggTil(innlegg)) {
				innlagt=true;
				}
		}
		else if(!finnes(innlegg)&&!ledigPlass()) {
			utvid();
			if(leggTil(innlegg)) {
				innlagt=true;
				}
		}
		
		return innlagt;
	}
	
	public boolean slett(Innlegg innlegg) {
		boolean slettet=false;
		if(finnes(innlegg)) {
			innleggtabell[finnInnlegg(innlegg)]=innleggtabell[nesteledige-1];
			nesteledige--;
			slettet=true;
		}
		return slettet;
	}
	
	public int[] search(String keyword) {
		int teller=0;
		int[] idTab=new int[nesteledige];
		for(int i=0;i<nesteledige;i++) {
			if(innleggtabell[i]!=null) {
				if(innleggtabell[i].toString().contains(keyword)) {
					idTab[i]=innleggtabell[i].getId();
					teller++;
				}
			}
		}
		int[] idTabUt=new int[teller];
		int teller2=0;
		for(int j=0;j<nesteledige;j++) {
			if(idTab[j]>0) {
				idTabUt[teller2]=idTab[j];
				teller2++;
			}
		}
		return idTabUt;
	}
}