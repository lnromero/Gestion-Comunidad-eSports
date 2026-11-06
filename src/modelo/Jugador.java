package persona;

import java.util.ArrayList;

public class Jugador extends Persona{
    private int puntos;
    private int nivel;
    private ArrayList<String> juegosAsociados;
    public Jugador(String nombre, String username, String disponiblidad, int nivel, int puntos){
        super(nombre, username, disponiblidad);
        this.puntos = puntos;
        this.nivel = nivel;
        this.juegosAsociados = new juegosAsociados<>();
    }
    
    // Método para agregar un juego a la lista
    public void agregarJuego(String nombreJuego) {
        if (nombreJuego != null && !nombreJuego.trim().isEmpty()) {
            this.juegosAsociados.add(nombreJuego);
            System.out.println("Juego '" + nombreJuego + "' agregado exitosamente.");
        } else {
            System.out.println("El nombre del juego no es válido.");
        }
    }

    // Método para eliminar un juego de la lista
    public void eliminarJuego(String nombreJuego) {
        if (this.juegosAsociados.remove(nombreJuego)) {
            System.out.println("Juego '" + nombreJuego + "' eliminado de la lista.");
        } else {
            System.out.println("El juego no se encuentra en la lista del jugador.");
        }
    }

    public ArrayList<String> getJuegosAsociados() {
                    return juegosAsociados;
    }
    
    //evitar un null
    public Jugador() {
        super();
        this.juegosAsociados = new ArrayList<>();
    }

    public int getNivel(){
            return nivel;
    }
    
    public void setNivel(int nivel) {
        
        if(nivel >= 1 && nivel<= 10){
            this.nivel=nivel;
        }
        else{
            System.out.println("Error: El nivel debe estar entre 1 y 10.");
        }
    
    }
          
    public int getPuntos(){
        return puntos;   
    }
    
    public void setPuntos(){
        
        if(puntos>= 0){
            this.puntos = puntos;         
        }
        
        else{          
            System.out.println("Su puntuación no es valida");
        }
    }
    
    
                
          
}


