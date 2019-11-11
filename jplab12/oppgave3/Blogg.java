package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	Innlegg[] innleggsTabell;
	private int nesteledig;

	public Blogg() {
		innleggsTabell = new Innlegg[20];

	}

	public Blogg(int lengde) {
		innleggsTabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig; // samme som antall
	}

	public Innlegg[] getSamling() {
		return innleggsTabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		int p = -1;
		int i = 0;
		while (i < nesteledig && p == -1) {
			if (innleggsTabell[i].erLik(innlegg)) {
				p = i;
			}
			i++;
		}
		return p;
	}

	public boolean finnes(Innlegg innlegg) {
		int i = finnInnlegg(innlegg);
		boolean finnes = true;
		if (i == -1) {
			finnes = false;

		}
		return finnes;
	}

	public boolean ledigPlass() {
		boolean ledig = false;
		if (innleggsTabell.length > nesteledig) { // sjekker om det er plass i tabellen
			ledig = true;
		}
		return ledig;
	}

	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil;
		if (finnes(innlegg)) {
			lagtTil = false;

		} else if (!ledigPlass()) {
			lagtTil = false;

		} else {
			innleggsTabell[nesteledig] = innlegg;
			lagtTil = true;
			nesteledig++;

		}
		return lagtTil;
	}

	public String toString() {
		String s = getAntall() + "\n";
		for (int i = 0; i < innleggsTabell.length; i++) {
			s += innleggsTabell[i].toString();

		}
		return s;
	}

// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] kopiTab = innleggsTabell;
		innleggsTabell = new Innlegg[kopiTab.length * 2];

		int i = 0;
		for (Innlegg innlegg : kopiTab) {
			innleggsTabell[i] = innlegg;
			i++;
		}

	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagttil = false;

		for (Innlegg x : innleggsTabell) {
			if (!innlegg.erLik(x)) {
				lagttil = true;
			} else {
				if (nesteledig < innleggsTabell.length) {
					innleggsTabell[nesteledig] = innlegg;
				}
			}
			return lagttil;
		}

	}

	public boolean slett(Innlegg innlegg) {
		Innlegg[] kopiTab = innleggsTabell;
		innleggsTabell = new Innlegg[kopiTab.length * 2];

		boolean slettet = false;

		for (Innlegg x : kopiTab) {
			if (x.erLik(innlegg)) {
				slettet = true;
				x = null;
				nesteledig--;

			}
		}
		int i = 0;
		for (Innlegg x : kopiTab) {
			if (x != null) {
				innleggsTabell[i] = x;
				i++;
			}
		}
		return slettet;
	}
}
//	//public int[] search(String keyword) {

//}