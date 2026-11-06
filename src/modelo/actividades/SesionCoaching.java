package modelo.actividades;

import modelo.enums.EstadoActividad;
import modelo.personas.Coach;
import modelo.personas.Jugador;

public class SesionCoaching extends Actividad {
    private Coach coachAsignado;
    private Jugador jugadorCliente;
    private String temaEntrenamiento;
    private int duracionHoras;
    private double costoTotal;

    public SesionCoaching(String codigo, String fecha, String hora, Coach coachAsignado, Jugador jugadorCliente, String temaEntrenamiento, int duracionHoras) {
        super(codigo, fecha, hora);
        this.coachAsignado = coachAsignado;
        this.jugadorCliente = jugadorCliente;
        this.temaEntrenamiento = temaEntrenamiento;
        this.duracionHoras = duracionHoras;
        this.costoTotal = coachAsignado.getCostoPorHora() * duracionHoras;
    }

    @Override
    public void iniciarActividad() {
        if (this.estado == EstadoActividad.PROGRAMADO) {
            System.out.println("Iniciando sesion de coaching con el Coach " + coachAsignado.getNombreCompleto() + " para " + jugadorCliente.getNombreUsuario());
            System.out.println("Tema principal: " + temaEntrenamiento);
        } else {
            System.out.println("No se puede iniciar la sesion en estado: " + this.estado);
        }
    }

    @Override
    public void finalizarActividad() {
        this.estado = EstadoActividad.FINALIZADO;
        System.out.println("Sesion de coaching [" + codigo + "] finalizada. Total a cancelar: $" + costoTotal);
    }

    public Coach getCoachAsignado() {
        return coachAsignado;
    }

    public Jugador getJugadorCliente() {
        return jugadorCliente;
    }

    public String getTemaEntrenamiento() {
        return temaEntrenamiento;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
}
