package it.soundwave;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.*;

public class AnalizzatoreFrequenza {
	public static double calcolaFrequenza(byte[] buffer, int frequenzaCampionamento) {
		int n = buffer.length;
		int nuovaDimensione = prossimaPotenzaDiDue(n);
		double[] campioni = new double[nuovaDimensione];

		for (int i = 0; i < n; i++) {
			campioni[i] = (buffer[i] / 128.0) * finestraHann(i, n);
		}

		FastFourierTransformer fft = new FastFourierTransformer(DftNormalization.STANDARD);
		Complex[] spettro = fft.transform(campioni, TransformType.FORWARD);

		int indicePicco = 0;
		double massimaAmpiezza = 0;
		for (int i = 1; i < spettro.length / 2; i++) {
			double ampiezza = spettro[i].abs();
			if (ampiezza > massimaAmpiezza) {
				massimaAmpiezza = ampiezza;
				indicePicco = i;
			}
		}

		return (double) frequenzaCampionamento * indicePicco / nuovaDimensione;
	}

	private static int prossimaPotenzaDiDue(int numero) {
		int potenza = 1;
		while (potenza < numero) {
			potenza *= 2;
		}
		return potenza;
	}

	
	//Migliora il riconoscimento della nota
	private static double finestraHann(int indice, int dimensione) {
		return 0.5 * (1 - Math.cos(2 * Math.PI * indice / (dimensione - 1)));
	}
}
