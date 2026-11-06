package modelo.actividades;

import modelo.enums.EstadoActividad;
import modelo.personas.Jugador;

public class Duelo extends Actividad {
    private Jugador retador;
    private Jugador contrincante;
    private Jugador ganador;
    private RegistroEstadistica estadisticaRetador;
    private RegistroEstadistica estadisticaContrincante;

    public Duelo(String codigo, String fecha, String hora, Jugador retador, Jugador contrincante) {
        super(codigo, fecha, hora);
        this.retador = retador;
        this.contrincante = contrincante;
        this.ganador = null;
    }

    @Override
    public void iniciarActividad() {
        if (this.estado == EstadoActividad.PROGRAMADO) {
            System.out.println("Comenzando duelo [" + codigo + "] entre " + retador.getNombreUsuario() + " vs " + contrincante.getNombreUsuario());
        } else {
            System.out.println("No se puede iniciar el duelo porque su estado es: " + this.estado);
        }
    }

    @Override
    public void finalizarActividad() {
        this.estado = EstadoActividad.FINALIZADO;
        System.out.println("Duelo [" + codigo + "] finalizado con exito.");
    }

    public void registrarResultado(Jugador ganador, RegistroEstadistica statsRetador, RegistroEstadistica statsContrincante) {
        this.ganador = ganador;
        this.estadisticaRetador = statsRetador;
        this.estadisticaContrincante = statsContrincante;

        if (ganador.equals(retador)) {
            retador.setPuntos(retador.getPuntos() + 25);
            contrincante.setPuntos(Math.max(0, contrincante.getPuntos() - 10));
        } else if (ganador.equals(contrincante)) {
            contrincante.setPuntos(contrincante.getPuntos() + 25);
            retador.setPuntos(Math.max(0, retador.getPuntos() - 10));
        }

        finalizarActividad();
    }

    public Jugador getRetador() {
        return retador;
    }

    public Jugador getContrincante() {
        return contrincante;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public RegistroEstadistica getEstadisticaRetador() {
        return estadisticaRetador;
    }

    public RegistroEstadistica getEstadisticaContrincante() {
        return estadisticaContrincante;
    }
}
