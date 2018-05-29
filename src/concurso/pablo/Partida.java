package concurso.pablo;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Dificultad dificultad;

    public Partida(Jugador jugador1, Jugador jugador2, Dificultad dificultad) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.dificultad = dificultad;
    }

    public void empezarPartida() {
        boolean terminarPartida;
        if (dificultad == Dificultad.FACIL) {
            do {
                terminarPartida = new Turno(jugador1, jugador2).jugar();
            } while (terminarPartida);
        } else {
            do {
                terminarPartida = new Turno(jugador1, jugador2).jugar();
                if (terminarPartida)
                    terminarPartida = new Turno(jugador2, jugador1).jugar();
            } while (terminarPartida);
        }

    }


}
