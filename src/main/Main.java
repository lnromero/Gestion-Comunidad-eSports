package main;

import java.util.Scanner;
import modelo.actividades.Actividad;
import modelo.actividades.Duelo;
import modelo.actividades.RegistroEstadistica;
import modelo.personas.Coach;
import modelo.personas.Jugador;
import servicio.GestorComunidad;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestorComunidad gestor = new GestorComunidad();

        // Datos iniciales de prueba
        Jugador jugadorUno = new Jugador("Carlos Mendoza", "Shadow99", 5, 100);
        jugadorUno.agregarJuego("Valorant");
        gestor.agregarPersona(jugadorUno);

        Jugador jugadorDos = new Jugador("Andrea Paz", "ViperQueen", 6, 150);
        jugadorDos.agregarJuego("Valorant");
        gestor.agregarPersona(jugadorDos);

        Coach coachUno = new Coach("Mateo Silva", "CoachSilva", "Estrategia", 3, 12.5);
        gestor.agregarPersona(coachUno);

        String opcionSeleccionada = "";

        do {
            System.out.println("\n==================================");
            System.out.println("     SISTEMA COMUNIDAD ESPORTS    ");
            System.out.println("==================================");
            System.out.println("1. Registrar jugador");
            System.out.println("2. Registrar coach");
            System.out.println("3. Crear duelo");
            System.out.println("4. Crear sesion de coaching");
            System.out.println("5. Finalizar duelo");
            System.out.println("6. Ver personas");
            System.out.println("7. Ver actividades");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opcion: ");

            opcionSeleccionada = teclado.nextLine().trim();

            if (opcionSeleccionada.equals("1")) {
                System.out.println("\n--- REGISTRO DE JUGADOR ---");
                System.out.print("Nombre completo: ");
                String nombreCompleto = teclado.nextLine();

                System.out.print("Username: ");
                String nombreUsuario = teclado.nextLine();

                System.out.print("Nivel inicial (1-10): ");
                int nivel = teclado.nextInt();

                System.out.print("Puntos iniciales: ");
                int puntos = teclado.nextInt();
                teclado.nextLine(); // Limpia el salto de linea de nextInt

                System.out.print("Juego favorito: ");
                String juegoFavorito = teclado.nextLine();

                Jugador nuevoJugador = new Jugador(nombreCompleto, nombreUsuario, nivel, puntos);
                nuevoJugador.agregarJuego(juegoFavorito);
                gestor.agregarPersona(nuevoJugador);

            } else if (opcionSeleccionada.equals("2")) {
                System.out.println("\n--- REGISTRO DE COACH ---");
                System.out.print("Nombre completo: ");
                String nombreCompleto = teclado.nextLine();

                System.out.print("Username: ");
                String nombreUsuario = teclado.nextLine();

                System.out.print("Especialidad: ");
                String especialidad = teclado.nextLine();

                System.out.print("Anios de experiencia: ");
                int aniosExperiencia = teclado.nextInt();

                System.out.print("Costo por hora: ");
                double costoPorHora = teclado.nextDouble();
                teclado.nextLine(); // Limpia el salto de linea de nextDouble

                Coach nuevoCoach = new Coach(nombreCompleto, nombreUsuario, especialidad, aniosExperiencia, costoPorHora);
                gestor.agregarPersona(nuevoCoach);

            } else if (opcionSeleccionada.equals("3")) {
                System.out.println("\n--- CREAR DUELO ---");
                System.out.print("Codigo de la partida: ");
                String codigoPartida = teclado.nextLine();

                System.out.print("Fecha: ");
                String fecha = teclado.nextLine();

                System.out.print("Hora: ");
                String hora = teclado.nextLine();

                System.out.print("Username Retador: ");
                String usuarioRetador = teclado.nextLine();

                System.out.print("Username Contrincante: ");
                String usuarioContrincante = teclado.nextLine();

                gestor.crearDuelo(codigoPartida, fecha, hora, usuarioRetador, usuarioContrincante);

            } else if (opcionSeleccionada.equals("4")) {
                System.out.println("\n--- CREAR SESION DE COACHING ---");
                System.out.print("Codigo: ");
                String codigoSesion = teclado.nextLine();

                System.out.print("Fecha: ");
                String fecha = teclado.nextLine();

                System.out.print("Hora: ");
                String hora = teclado.nextLine();

                System.out.print("Username del Coach: ");
                String usuarioCoach = teclado.nextLine();

                System.out.print("Username del Jugador: ");
                String usuarioJugador = teclado.nextLine();

                System.out.print("Tema a entrenar: ");
                String temaEntrenamiento = teclado.nextLine();

                System.out.print("Duracion en horas: ");
                int duracionHoras = teclado.nextInt();
                teclado.nextLine(); // Limpia el salto de linea

                gestor.crearSesionCoaching(codigoSesion, fecha, hora, usuarioCoach, usuarioJugador, temaEntrenamiento, duracionHoras);

            } else if (opcionSeleccionada.equals("5")) {
                System.out.println("\n--- FINALIZAR DUELO ---");
                System.out.print("Ingrese el codigo del duelo: ");
                String codigoDuelo = teclado.nextLine();

                Actividad actividadBuscada = gestor.buscarActividad(codigoDuelo);
                if (actividadBuscada != null && actividadBuscada instanceof Duelo) {
                    Duelo dueloEncontrado = (Duelo) actividadBuscada;
                    System.out.print("Username del ganador (" + dueloEncontrado.getRetador().getNombreUsuario() + " o " + dueloEncontrado.getContrincante().getNombreUsuario() + "): ");
                    String usuarioGanador = teclado.nextLine();

                    Jugador jugadorGanador = gestor.buscarJugador(usuarioGanador);
                    if (jugadorGanador != null) {
                        RegistroEstadistica estadisticaRetador = new RegistroEstadistica(dueloEncontrado.getRetador(), 12, 5, 3, 1500);
                        RegistroEstadistica estadisticaContrincante = new RegistroEstadistica(dueloEncontrado.getContrincante(), 5, 12, 1, 800);
                        dueloEncontrado.registrarResultado(jugadorGanador, estadisticaRetador, estadisticaContrincante);
                        System.out.println("Duelo finalizado y puntos asignados.");
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                } else {
                    System.out.println("No existe un duelo con ese codigo.");
                }

            } else if (opcionSeleccionada.equals("6")) {
                gestor.mostrarPersonas();

            } else if (opcionSeleccionada.equals("7")) {
                gestor.mostrarActividades();

            } else if (opcionSeleccionada.equals("8")) {
                System.out.println("Saliendo del programa... Gracias por usar el sistema.");

            } else {
                System.out.println("Opcion no valida. Elija un numero del 1 al 8.");
            }

        } while (!opcionSeleccionada.equals("8"));

        teclado.close();
    }
}
