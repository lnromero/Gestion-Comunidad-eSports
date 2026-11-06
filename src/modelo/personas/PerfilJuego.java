package modelo.personas;

import modelo.enums.GrupoNivel;

public class PerfilJuego {
    private String nombreUsuario;
    private String videojuegoPrincipal;
    private GrupoNivel nivelHabilidad;
    private int puntosClasificacion;

    public PerfilJuego(String nombreUsuario, String videojuegoPrincipal, GrupoNivel nivelHabilidad, int puntosClasificacion) {
        this.nombreUsuario = nombreUsuario;
        this.videojuegoPrincipal = videojuegoPrincipal;
        this.nivelHabilidad = nivelHabilidad;
        this.puntosClasificacion = puntosClasificacion;
    }

    public void modificarPuntos(int puntos) {
        this.puntosClasificacion += puntos;
        if (this.puntosClasificacion < 0) {
            this.puntosClasificacion = 0;
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getVideojuegoPrincipal() {
        return videojuegoPrincipal;
    }

    public void setVideojuegoPrincipal(String videojuegoPrincipal) {
        this.videojuegoPrincipal = videojuegoPrincipal;
    }

    public GrupoNivel getNivelHabilidad() {
        return nivelHabilidad;
    }

    public void setNivelHabilidad(GrupoNivel nivelHabilidad) {
        this.nivelHabilidad = nivelHabilidad;
    }

    public int getPuntosClasificacion() {
        return puntosClasificacion;
    }

    public void setPuntosClasificacion(int puntosClasificacion) {
        this.puntosClasificacion = puntosClasificacion;
    }
}
