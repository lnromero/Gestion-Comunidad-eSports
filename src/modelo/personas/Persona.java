package modelo.personas;

public abstract class Persona {
    protected String nombreCompleto;
    protected String nombreUsuario;
    protected String[][] matrizDisponibilidad;

    public Persona() {
        this.matrizDisponibilidad = new String[24][7];
        inicializarMatrizDisponibilidad();
    }

    public Persona(String nombreCompleto, String nombreUsuario) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.matrizDisponibilidad = new String[24][7];
        inicializarMatrizDisponibilidad();
    }

    private void inicializarMatrizDisponibilidad() {
        for (int fila = 0; fila < matrizDisponibilidad.length; fila++) {
            for (int columna = 0; columna < matrizDisponibilidad[fila].length; columna++) {
                matrizDisponibilidad[fila][columna] = "LIBRE";
            }
        }
    }

    public abstract void mostrarInformacion();

    public void setMatrizDisponibilidad(String[][] matrizDisponibilidad) {
        this.matrizDisponibilidad = matrizDisponibilidad;
    }

    public String[][] getMatrizDisponibilidad() {
        return matrizDisponibilidad;
    }

    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
            this.nombreCompleto = nombreCompleto;
        } else {
            System.out.println("Error: El nombre no puede estar vacio.");
        }
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            this.nombreUsuario = nombreUsuario;
        } else {
            System.out.println("Error: El nombre de usuario no puede estar vacio.");
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
