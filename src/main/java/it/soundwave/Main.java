package it.soundwave;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Ascolto una nota musicale per 2 secondi...");
		double frequenza = ProcessoreAudio.catturaFrequenzaNota(2000); // 2 secondi di ascolto
		String nota = RiconoscitoreNota.identificaNota(frequenza);

		System.out.println("Nota rilevata: " + nota);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Scegli una scala musicale (maggiore, minore, pentatonica): ");
		String tipoScala = scanner.nextLine().toLowerCase();

		String[] scala = CostruttoreScala.costruisciScala(nota, tipoScala);
		if (scala != null) {
			System.out.println("Scala " + tipoScala + ": " + String.join(", ", scala));
		} else {
			System.out.println("Tipo di scala non valido.");
		}
		scanner.close();
	}
}
