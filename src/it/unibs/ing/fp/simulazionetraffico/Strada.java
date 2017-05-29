package it.unibs.ing.fp.simulazionetraffico;

import java.util.Random;

public class Strada {
	public final int LUNGHEZZA;
	public final int ALTEZZA;

	private int probAuto = 10;
	private int probPedone = 30;

	Elemento[][] mappa;

	public Strada(int l, int a) {
		LUNGHEZZA = l;
		ALTEZZA = a;
		mappa = new Elemento[ALTEZZA][LUNGHEZZA];
		initStrada();
	}

	public final void initStrada() {
		for (int r = 0; r < ALTEZZA; r++) {
			for (int c = 0; c < LUNGHEZZA; c++) {
				mappa[r][c] = new Vuoto();
			}
		}
		ingressoElementi();

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

		for (int r = 0; r < ALTEZZA; r++) {
			for (int c = 0; c < LUNGHEZZA; c++) {
				copia[r][c] = new Vuoto();
			}
		}

		for (int r = 0; r < ALTEZZA; r++) {
			for (int c = 0; c < LUNGHEZZA; c++) {
				if (!(mappa[r][c] instanceof Vuoto)) {
					Coordinate coord = mappa[r][c].nextPosizione(c, r);
					if (coord.isDentro(ALTEZZA, LUNGHEZZA)) {
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
