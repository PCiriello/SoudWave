# SoundWave - Riconoscimento Note e Costruzione di Scale Musicali

SoundWave è un software scritto in Java che analizza le frequenze audio per identificare le note musicali e generare automaticamente le scale musicali corrispondenti.

Funzionalità:
- Riconoscimento delle note in tempo reale tramite microfono
- Costruzione automatica di scale musicali (Maggiore, Minore, Pentatonica)
- Elaborazione del segnale audio con FFT (Fast Fourier Transform)

Tecnologie Utilizzate
- Java (OOP, gestione input audio)
- Apache Commons Math (FFT per analisi della frequenza)
- Java Sound API (Acquisizione audio)

Utilizzo
- Avvia l'applicazione
- Riproduci una nota musicale (es. con uno strumento o la voce)
- Dopo 2 secondi, il software rileverà la nota corrispondente
- Scegli una scala musicale tra maggiore, minore o pentatonica
- SoundWave genererà la scala a partire dalla nota riconosciuta
