package it.soundwave;

public class RiconoscitoreNota {
	static final String[] NOTE = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };

	public static String identificaNota(double frequenza) {
		if (frequenza <= 0)
			return "Sconosciuta";

		double A4 = 440.0;
		int numeroNota = (int) Math.round(12 * Math.log(frequenza / A4) / Math.log(2)) + 49;

		if (numeroNota < 1)
			return "Sconosciuta";

		return NOTE[(numeroNota - 1) % 12];
	}
}
