package modelo.personas;

import java.util.ArrayList;

public class Jugador extends Persona {
    private int puntos;
    private int nivel;
    private ArrayList<String> juegosAsociados;

    public Jugador() {
        super();
        this.puntos = 0;
        this.nivel = 1;
        this.juegosAsociados = new ArrayList<>();
    }

    public Jugador(String nombreCompleto, String nombreUsuario, int nivel, int puntos) {
        super(nombreCompleto, nombreUsuario);
        this.puntos = puntos;
        this.nivel = nivel;
        this.juegosAsociados = new ArrayList<>();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Jugador: " + nombreCompleto + " | Usuario: " + nombreUsuario);
        System.out.println("Nivel: " + nivel + " | Puntos: " + puntos);
        System.out.println("Juegos asociados: " + juegosAsociados);
    }

    public void agregarJuego(String nombreJuego) {
        if (nombreJuego != null && !nombreJuego.trim().isEmpty()) {
            this.juegosAsociados.add(nombreJuego);
            //System.out.println("Juego '" + nombreJuego + "' agregado exitosamente.");
        } else {
            System.out.println("El nombre del juego no es valido.");
        }
    }

    public void eliminarJuego(String nombreJuego) {
        if (this.juegosAsociados.remove(nombreJuego)) {
            System.out.println("Juego '" + nombreJuego + "' eliminado de la lista.");
        } else {
            System.out.println("El juego no se encuentra en la lista del jugador.");
        }
    }

    public ArrayList<String> getJuegosAsociados() {
        return juegosAsociados;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel >= 1 && nivel <= 10) {
            this.nivel = nivel;
        } else {
            System.out.println("Error: El nivel debe estar entre 1 y 10.");
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        if (puntos >= 0) {
            this.puntos = puntos;
        } else {
            System.out.println("Su puntuacion no es valida.");
        }
    }
}
