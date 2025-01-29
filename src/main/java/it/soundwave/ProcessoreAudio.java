package it.soundwave;

import javax.sound.sampled.*;

public class ProcessoreAudio {
	public static double catturaFrequenzaNota(int durataMs) {
		final int FREQUENZA_CAMPIONAMENTO = 44100;
		final int DIMENSIONE_BUFFER = FREQUENZA_CAMPIONAMENTO * durataMs / 1000;
		byte[] buffer = new byte[DIMENSIONE_BUFFER];

		try (TargetDataLine linea = AudioSystem
				.getTargetDataLine(new AudioFormat(FREQUENZA_CAMPIONAMENTO, 16, 1, true, true))) {
			linea.open();
			linea.start();
			linea.read(buffer, 0, buffer.length);
		} catch (Exception e) {
			System.err.println("Errore nella cattura audio: " + e.getMessage());
			return -1;
		}

		return AnalizzatoreFrequenza.calcolaFrequenza(buffer, FREQUENZA_CAMPIONAMENTO);
	}
}
