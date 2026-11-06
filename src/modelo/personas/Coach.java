package modelo.personas;

public class Coach extends Persona {
    private String especialidad;
    private int aniosExperiencia;
    private double costoPorHora;

    public Coach() {
        super();
        this.especialidad = "General";
        this.aniosExperiencia = 0;
        this.costoPorHora = 0.0;
    }

    public Coach(String nombreCompleto, String nombreUsuario, String especialidad, int aniosExperiencia, double costoPorHora) {
        super(nombreCompleto, nombreUsuario);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.costoPorHora = costoPorHora;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Coach: " + nombreCompleto + " | Usuario: " + nombreUsuario);
        System.out.println("Especialidad: " + especialidad + " | Experiencia: " + aniosExperiencia + " anios | Costo/Hora: $" + costoPorHora);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad != null && !especialidad.trim().isEmpty()) {
            this.especialidad = especialidad;
        } else {
            System.out.println("Error: La especialidad no puede estar vacia.");
        }
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia >= 0) {
            this.aniosExperiencia = aniosExperiencia;
        } else {
            System.out.println("Error: Los anios de experiencia no pueden ser negativos.");
        }
    }

    public double getCostoPorHora() {
        return costoPorHora;
    }

    public void setCostoPorHora(double costoPorHora) {
        if (costoPorHora >= 0) {
            this.costoPorHora = costoPorHora;
        } else {
            System.out.println("Error: El costo por hora no puede ser negativo.");
        }
    }
}
