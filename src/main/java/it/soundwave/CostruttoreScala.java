package it.soundwave;

import java.util.HashMap;
import java.util.Map;

public class CostruttoreScala {
	private static final Map<String, int[]> SCALE = new HashMap<>();

	static {
		SCALE.put("maggiore", new int[] { 0, 2, 4, 5, 7, 9, 11 });
		SCALE.put("minore", new int[] { 0, 2, 3, 5, 7, 8, 10 });
		SCALE.put("pentatonica", new int[] { 0, 2, 4, 7, 9 });
	}

	public static String[] costruisciScala(String notaBase, String tipoScala) {
		if (!SCALE.containsKey(tipoScala))
			return null;

		int indiceNotaBase = trovaIndiceNota(notaBase);
		if (indiceNotaBase == -1)
			return null;

		String[] scala = new String[SCALE.get(tipoScala).length];
		for (int i = 0; i < scala.length; i++) {
			scala[i] = RiconoscitoreNota.NOTE[(indiceNotaBase + SCALE.get(tipoScala)[i]) % 12];
		}
		return scala;
	}

	private static int trovaIndiceNota(String nota) {
		for (int i = 0; i < RiconoscitoreNota.NOTE.length; i++) {
			if (RiconoscitoreNota.NOTE[i].equals(nota))
				return i;
		}
		return -1;
	}
}
