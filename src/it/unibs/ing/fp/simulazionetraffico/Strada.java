package it.unibs.ing.fp.simulazionetraffico;

import java.util.Random;

public class Strada {
	public final int LUNGHEZZA;
	public final int ALTEZZA;

	private int probAuto = 7;
	private int probPedone = 15;

	Elemento[][] mappa;

	public Strada(int l, int a) {
		LUNGHEZZA = l;
		ALTEZZA = a;
		mappa = new Elemento[ALTEZZA][LUNGHEZZA];
		initStrada(mappa);
		ingressoElementi();
	}

	public final void initStrada(Elemento e[][]) {
		for (int r = 0; r < ALTEZZA; r++) {
			for (int c = 0; c < LUNGHEZZA; c++) {
				e[r][c] = new Vuoto();
			}
		}

	}
	


	private Elemento generaAuto() {
		Random r = new Random();
		int num = r.nextInt(probAuto);
		int v;
		do {
			v = (int) Math.abs(((r.nextGaussian()+2)));
		}while(v==0);
		if (num == 1)
			return new Auto(Direzione.DESTRA, v);
		else
			return new Vuoto();

	}

	private Elemento generaPedone() {
		Random r = new Random();
		int num = r.nextInt(probPedone);

		if (num == 1)
			return new Pedone(Direzione.SU, 1);
		else
			return new Vuoto();

	}

	private void ingressoElementi() {
		for (int r = 0; r < ALTEZZA - 1; r++) {
			mappa[r][0] = generaAuto();
		}

		for (int c = 1; c < LUNGHEZZA; c++) {
			mappa[ALTEZZA - 1][c] = generaPedone();
		}
	}

	public void avanzaSimulazione() {
		Elemento[][] copia = new Elemento[ALTEZZA][LUNGHEZZA];

		initStrada(copia);

		for (int r = 0; r < ALTEZZA; r++) {
			for (int c = 0; c < LUNGHEZZA; c++) {
				if ((mappa[r][c] instanceof Auto)) {
					Coordinate coord = mappa[r][c].getProssimaPosizione(c, r);
					if (coord.isDentro(ALTEZZA, LUNGHEZZA)) {
						copia[coord.getY()][coord.getX()] = mappa[r][c];
					} else {
						copia[r][c] = new Vuoto();
					}
				}
				
				if ((mappa[r][c] instanceof Pedone)) {
					Coordinate coord = mappa[r][c].getProssimaPosizione(c, r);
					if (coord.isDentro(ALTEZZA, LUNGHEZZA)) {
						if(copia[coord.getY()][coord.getX()] instanceof Auto ) {
							System.out.println("Collisione in posizione: Asse X " + (coord.getX()+1) + " - Asse Y " + (ALTEZZA - coord.getY()) );
						}
						copia[coord.getY()][coord.getX()] = mappa[r][c];
					} else {
						copia[r][c] = new Vuoto();
					}
				}
			}
		}

		mappa = copia;
		ingressoElementi();
	}

	// private int[] rilevaCollisione() {}

	private void rimuoviAuto() {
	}

	public void paintStrada() {

		for (int c = 0; c < LUNGHEZZA; c++)
			System.out.print("-");
		System.out.println();

		for (int r = 0; r < ALTEZZA; r++) {
			for (int c = 0; c < LUNGHEZZA; c++) {
				System.out.print(mappa[r][c]);
			}
			System.out.print("\n");
			for (int c = 0; c < LUNGHEZZA; c++) {
				System.out.print("-");
			}
			System.out.print("\n");
		}

	}
}
