package servicio;

import java.util.ArrayList;
import modelo.actividades.Actividad;
import modelo.actividades.Duelo;
import modelo.actividades.SesionCoaching;
import modelo.personas.Coach;
import modelo.personas.Jugador;
import modelo.personas.Persona;

public class GestorComunidad {
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Actividad> listaActividades;

    public GestorComunidad() {
        listaPersonas = new ArrayList<>();
        listaActividades = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) {
        if (persona != null) {
            listaPersonas.add(persona);
            System.out.println("Persona agregada correctamente.");
        } else {
            System.out.println("No se pudo agregar a la persona.");
        }
    }

    public Jugador buscarJugador(String nombreUsuario) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona personaActual = listaPersonas.get(i);
            if (personaActual instanceof Jugador) {
                if (personaActual.getNombreUsuario().equals(nombreUsuario)) {
                    return (Jugador) personaActual;
                }
            }
        }
        return null;
    }

    public Coach buscarCoach(String nombreUsuario) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona personaActual = listaPersonas.get(i);
            if (personaActual instanceof Coach) {
                if (personaActual.getNombreUsuario().equals(nombreUsuario)) {
                    return (Coach) personaActual;
                }
            }
        }
        return null;
    }

    public Actividad buscarActividad(String codigo) {
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad actividadActual = listaActividades.get(i);
            if (actividadActual.getCodigo().equals(codigo)) {
                return actividadActual;
            }
        }
        return null;
    }

    public void crearDuelo(String codigo, String fecha, String hora, String usuarioRetador, String usuarioContrincante) {
        Jugador retador = buscarJugador(usuarioRetador);
        Jugador contrincante = buscarJugador(usuarioContrincante);

        if (retador == null || contrincante == null) {
            System.out.println("Error: Uno o ambos jugadores no estan registrados.");
            return;
        }

        if (usuarioRetador.equals(usuarioContrincante)) {
            System.out.println("Error: No puedes crear un duelo con la misma persona.");
            return;
        }

        Duelo nuevoDuelo = new Duelo(codigo, fecha, hora, retador, contrincante);
        listaActividades.add(nuevoDuelo);
        System.out.println("Duelo creado con exito.");
    }

    public void crearSesionCoaching(String codigo, String fecha, String hora, String usuarioCoach, String usuarioJugador, String temaEntrenamiento, int horas) {
        Coach coachEncontrado = buscarCoach(usuarioCoach);
        Jugador jugadorEncontrado = buscarJugador(usuarioJugador);

        if (coachEncontrado == null) {
            System.out.println("Error: El coach no existe.");
            return;
        }

        if (jugadorEncontrado == null) {
            System.out.println("Error: El jugador no existe.");
            return;
        }

        if (horas <= 0) {
            System.out.println("Error: La cantidad de horas debe ser mayor a 0.");
            return;
        }

        SesionCoaching nuevaSesion = new SesionCoaching(codigo, fecha, hora, coachEncontrado, jugadorEncontrado, temaEntrenamiento, horas);
        listaActividades.add(nuevaSesion);
        System.out.println("Sesion de coaching registrada exitosamente.");
    }

    public void mostrarPersonas() {
        System.out.println("\n--- LISTA DE MIEMBROS REGISTRADOS ---");
        if (listaPersonas.isEmpty()) {
            System.out.println("Todavia no hay personas registradas.");
            return;
        }
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona personaActual = listaPersonas.get(i);
            personaActual.mostrarInformacion();
            System.out.println("---------------------------------");
        }
    }

    public void mostrarActividades() {
        System.out.println("\n--- LISTA DE ACTIVIDADES ---");
        if (listaActividades.isEmpty()) {
            System.out.println("Todavia no hay actividades creadas.");
            return;
        }
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad actividadActual = listaActividades.get(i);
            System.out.println("Codigo: " + actividadActual.getCodigo() + " | Fecha: " + actividadActual.getFecha() + " | Hora: " + actividadActual.getHora() + " | Estado: " + actividadActual.getEstado());
        }
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }
}
