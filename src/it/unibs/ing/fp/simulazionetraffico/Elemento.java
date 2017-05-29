package it.unibs.ing.fp.simulazionetraffico;

public abstract class Elemento {
	int id;
	Direzione direzione;
	char simbolo;
	int velocita;
	
	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	public void setDirezione(Direzione direzione) {
		this.direzione = direzione;
	}

	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}

	public Elemento(Direzione _direzione, char _simbolo, int _velocita ) {
		direzione = _direzione;
		simbolo = _simbolo;
		velocita = _velocita;
		id = this.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("%c",simbolo);
	}

	public int getId() {
		return id;
	}

	public Direzione getDirezione() {
		return direzione;
	}

	public int getVelocita() {
		return velocita;
	}
	
	public Coordinate nextPosizione(int x, int y) {
		
		switch (getDirezione()) {
		case DESTRA:
			x+=velocita;
			break;
			
		case SINISTRA:
			x-=velocita;
			break;
			
		case SU:
			y-=velocita;
			break;
			
		case GIU:
			y+=velocita;
			break;
			
		case STOP:
			break;

		default:
			break;
		}
		
		return new Coordinate(x, y);
		
	}
}
