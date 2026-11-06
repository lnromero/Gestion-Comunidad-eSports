package modelo.personas;

public abstract class Persona {
    protected String identificacion;
    protected String nombreCompleto;
    protected String correoElectronico;
    protected boolean[][] disponibilidadSemanal;

    public Persona(String identificacion, String nombreCompleto, String correoElectronico) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.disponibilidadSemanal = new boolean[7][4];
    }

    public abstract void mostrarInformacion();

    public boolean estaDisponible(int dia, int franja) {
        if (dia < 0 || dia >= 7 || franja < 0 || franja >= 4) {
            return false;
        }
        return disponibilidadSemanal[dia][franja];
    }

    public void setDisponibilidad(int dia, int franja, boolean estado) {
        if (dia >= 0 && dia < 7 && franja >= 0 && franja < 4) {
            disponibilidadSemanal[dia][franja] = estado;
        }
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean[][] getDisponibilidadSemanal() {
        return disponibilidadSemanal;
    }
}
