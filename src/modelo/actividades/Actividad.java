package modelo.actividades;

import modelo.enums.EstadoActividad;
import modelo.interfaces.Cancelable;
import modelo.interfaces.Reprogramable;
import modelo.personas.Persona;

public abstract class Actividad implements Cancelable, Reprogramable {
    protected String codigo;
    protected String fecha;
    protected String hora;
    protected EstadoActividad estado;
    protected String motivoCancelacion;

    public Actividad(String codigo, String fecha, String hora) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = EstadoActividad.PROGRAMADO;
        this.motivoCancelacion = "";
    }

    public abstract void iniciarActividad();
    public abstract void finalizarActividad();

    @Override
    public boolean cancelar(Persona solicitante, String motivo) {
        if (this.estado == EstadoActividad.PROGRAMADO) {
            this.estado = EstadoActividad.CANCELADO;
            this.motivoCancelacion = (motivo != null ? motivo : "Sin motivo especificado");
            System.out.println("Actividad " + codigo + " cancelada por " + solicitante.getNombreCompleto() + ". Motivo: " + this.motivoCancelacion);
            return true;
        }
        System.out.println("No se puede cancelar una actividad en estado: " + this.estado);
        return false;
    }

    @Override
    public boolean reprogramar(String nuevaFecha, String nuevaHora) {
        if (this.estado == EstadoActividad.PROGRAMADO) {
            this.fecha = nuevaFecha;
            this.hora = nuevaHora;
            System.out.println("Actividad " + codigo + " reprogramada para el " + nuevaFecha + " a las " + nuevaHora);
            return true;
        }
        System.out.println("Solo se pueden reprogramar actividades en estado PROGRAMADO.");
        return false;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public EstadoActividad getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividad estado) {
        this.estado = estado;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }
}
