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

    public void agregarPersona(Persona p) {
        if (p != null) {
            listaPersonas.add(p);
            System.out.println("Persona agregada correctamente.");
        } else {
            System.out.println("No se pudo agregar a la persona.");
        }
    }

    public Jugador buscarJugador(String usuario) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona p = listaPersonas.get(i);
            if (p instanceof Jugador) {
                if (p.getNombreUsuario().equalsIgnoreCase(usuario)) {
                    return (Jugador) p;
                }
            }
        }
        return null;
    }

    public Coach buscarCoach(String usuario) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona p = listaPersonas.get(i);
            if (p instanceof Coach) {
                if (p.getNombreUsuario().equalsIgnoreCase(usuario)) {
                    return (Coach) p;
                }
            }
        }
        return null;
    }

    public Actividad buscarActividad(String codigo) {
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad a = listaActividades.get(i);
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                return a;
            }
        }
        return null;
    }

    public void crearDuelo(String codigo, String fecha, String hora, String user1, String user2) {
        Jugador j1 = buscarJugador(user1);
        Jugador j2 = buscarJugador(user2);

        if (j1 == null || j2 == null) {
            System.out.println("Error: Uno o ambos jugadores no estan registrados.");
            return;
        }

        if (user1.equalsIgnoreCase(user2)) {
            System.out.println("Error: No puedes crear un duelo con la misma persona.");
            return;
        }

        Duelo nuevoDuelo = new Duelo(codigo, fecha, hora, j1, j2);
        listaActividades.add(nuevoDuelo);
        System.out.println("Duelo creado con exito.");
    }

    public void crearSesionCoaching(String codigo, String fecha, String hora, String userCoach, String userJugador, String tema, int horas) {
        Coach c = buscarCoach(userCoach);
        Jugador j = buscarJugador(userJugador);

        if (c == null) {
            System.out.println("Error: El coach no existe.");
            return;
        }

        if (j == null) {
            System.out.println("Error: El jugador no existe.");
            return;
        }

        if (horas <= 0) {
            System.out.println("Error: La cantidad de horas debe ser mayor a 0.");
            return;
        }

        SesionCoaching sesion = new SesionCoaching(codigo, fecha, hora, c, j, tema, horas);
        listaActividades.add(sesion);
        System.out.println("Sesion de coaching registrada exitosamente.");
    }

    public void mostrarPersonas() {
        System.out.println("\n--- LISTA DE MIEMBROS REGISTRADOS ---");
        if (listaPersonas.isEmpty()) {
            System.out.println("Todavia no hay personas registradas.");
            return;
        }
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona p = listaPersonas.get(i);
            p.mostrarInformacion();
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
            Actividad a = listaActividades.get(i);
            System.out.println("Codigo: " + a.getCodigo() + " | Fecha: " + a.getFecha() + " | Hora: " + a.getHora() + " | Estado: " + a.getEstado());
        }
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }
}
