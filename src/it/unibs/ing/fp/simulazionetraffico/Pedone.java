package it.unibs.ing.fp.simulazionetraffico;

public class Pedone extends Elemento {

	public Pedone(Direzione _direzione, int _velocita) {
		super(_direzione, '*', _velocita);
	}
	public Pedone() {
		super(Direzione.SU, '*', 0);
	}
	public boolean prevaleSu(Elemento e) {
		return true;
	}

}
