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
        this.listaPersonas = new ArrayList<>();
        this.listaActividades = new ArrayList<>();
    }

    public void registrarPersona(Persona persona) {
        if (persona != null) {
            this.listaPersonas.add(persona);
            System.out.println("Registro exitoso: " + persona.getNombreCompleto() + " agregado al sistema.");
        } else {
            System.out.println("Error: No se puede registrar una persona nula.");
        }
    }

    public Jugador buscarJugadorPorUsuario(String nombreUsuario) {
        for (Persona persona : listaPersonas) {
            if (persona instanceof Jugador && persona.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return (Jugador) persona;
            }
        }
        return null;
    }

    public Coach buscarCoachPorUsuario(String nombreUsuario) {
        for (Persona persona : listaPersonas) {
            if (persona instanceof Coach && persona.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return (Coach) persona;
            }
        }
        return null;
    }

    public Actividad buscarActividadPorCodigo(String codigo) {
        for (Actividad actividad : listaActividades) {
            if (actividad.getCodigo().equalsIgnoreCase(codigo)) {
                return actividad;
            }
        }
        return null;
    }

    public boolean agendarDuelo(String codigo, String fecha, String hora, String usuarioRetador, String usuarioContrincante) {
        Jugador retador = buscarJugadorPorUsuario(usuarioRetador);
        Jugador contrincante = buscarJugadorPorUsuario(usuarioContrincante);

        if (retador == null || contrincante == null) {
            System.out.println("Error: Uno o ambos jugadores no existen en el sistema.");
            return false;
        }

        if (retador.equals(contrincante)) {
            System.out.println("Error: Un jugador no puede retarse a si mismo.");
            return false;
        }

        Duelo nuevoDuelo = new Duelo(codigo, fecha, hora, retador, contrincante);
        listaActividades.add(nuevoDuelo);
        System.out.println("Duelo [" + codigo + "] programado con exito.");
        return true;
    }

    public boolean agendarSesionCoaching(String codigo, String fecha, String hora, String usuarioCoach, String usuarioJugador, String tema, int horas) {
        Coach coach = buscarCoachPorUsuario(usuarioCoach);
        Jugador jugador = buscarJugadorPorUsuario(usuarioJugador);

        if (coach == null || jugador == null) {
            System.out.println("Error: El coach o el jugador especificado no existen.");
            return false;
        }

        if (horas <= 0) {
            System.out.println("Error: La duracion de la sesion debe ser mayor a 0 horas.");
            return false;
        }

        SesionCoaching nuevaSesion = new SesionCoaching(codigo, fecha, hora, coach, jugador, tema, horas);
        listaActividades.add(nuevaSesion);
        System.out.println("Sesion de coaching [" + codigo + "] programada con exito.");
        return true;
    }

    public void listarPersonas() {
        System.out.println("\n--- LISTA GENERAL DE MIEMBROS ---");
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay personas registradas aun.");
            return;
        }
        for (Persona persona : listaPersonas) {
            persona.mostrarInformacion();
            System.out.println("---------------------------------");
        }
    }

    public void listarActividades() {
        System.out.println("\n--- LISTA DE ACTIVIDADES REGISTRADAS ---");
        if (listaActividades.isEmpty()) {
            System.out.println("No hay actividades registradas aun.");
            return;
        }
        for (Actividad actividad : listaActividades) {
            System.out.println("Codigo: " + actividad.getCodigo() + " | Fecha: " + actividad.getFecha() + " | Hora: " + actividad.getHora() + " | Estado: " + actividad.getEstado());
        }
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }
}
