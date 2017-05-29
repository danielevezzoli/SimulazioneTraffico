package it.unibs.ing.fp.simulazionetraffico;

public class Coordinate {
	int x;
	int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	} 
	
	public boolean isDentro(int lunghezza, int altezza) {
		if(x<altezza && x>=0) {
			if(y<lunghezza && y>=0) {
				return true;
			}
		}
		return false;
	}
	
}
