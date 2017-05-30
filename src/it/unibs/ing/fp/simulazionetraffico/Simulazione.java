package it.unibs.ing.fp.simulazionetraffico;

import java.util.concurrent.TimeUnit;

public class Simulazione {

	public static void main(String[] args) throws InterruptedException {
		Strada strada = new Strada(50, 10); // Lunghezza, altezza
		int timeSimulation = 400;// Millisecondi

		for (; true;) {
			strada.paintStrada();
			strada.avanzaSimulazione();
			clearScreen();
			TimeUnit.MILLISECONDS.sleep(timeSimulation);
		}

	}

	public static void clearScreen() {
		System.out.print("\n\n\n\n\n\n\n\n");
	}

}
