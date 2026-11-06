package modelo.actividades;

import modelo.personas.Jugador;

public class RegistroEstadistica {
    private Jugador jugador;
    private int eliminaciones;
    private int muertes;
    private int asistencias;
    private int danioTotal;

    public RegistroEstadistica(Jugador jugador, int eliminaciones, int muertes, int asistencias, int danioTotal) {
        this.jugador = jugador;
        this.eliminaciones = eliminaciones;
        this.muertes = muertes;
        this.asistencias = asistencias;
        this.danioTotal = danioTotal;
    }

    public void mostrarEstadistica() {
        System.out.println("  Estadisticas de " + jugador.getNombreUsuario() + " -> K/D/A: " + eliminaciones + "/" + muertes + "/" + asistencias + " | Danio: " + danioTotal);
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getEliminaciones() {
        return eliminaciones;
    }

    public void setEliminaciones(int eliminaciones) {
        this.eliminaciones = eliminaciones;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getDanioTotal() {
        return danioTotal;
    }

    public void setDanioTotal(int danioTotal) {
        this.danioTotal = danioTotal;
    }
}
