package Persona;
public class Persona{
    protected String nombre;
    protected String username;
    protected String[][] disponibilidad;

    //construcotr vacio
    public Persona() {
        this.disponibilidad = new String[24][7]; // Ejemplo: 24 horas y 7 días de la semana
        inicilizaciónDisponiblidad();
    }
   
    
    public Persona(String nombre, String username, String[][] disponiblidad){
        this.nombre = nombre;
        this.username = username;
        this.disponibilidad = disponiblidad;  
        inicilizaciónDisponiblidad();
    }
   
    //incializar la matriz evitar erroes
    private void inicilizaciónDisponiblidad(){
           for(int i=0; i<disponibilidad.length; i++){
               for(int j=0; j<disponibilidad[i].length; j++){
                   disponibilidad[i][j] = "[]";
               }
           }
    }
    
    public void setDisponibilidad(String[][] disponibilidad){
        this.disponibilidad =  disponibilidad;
    }
    
    public String[][] getDisponibilidad(){
        return disponibilidad;
    }
    
    public void setNombre(String nombre){
        if(nombre != null && nombre.trim().isEmpty()){
            this.nombre = nombre;
        }
        else{
            System.out.println("Error: El nombre no puede estar vacío.");
        }
    }
 
    public String getNombre(){
        return nombre;
    }
     
    public void setUsername(String nombre){
        if(nombre != null && nombre.trim().isEmpty()){
            this.nombre = nombre;
        }
        else{
            System.out.println("Error: El Username no puede estar vacío.");
        }
     }
     
     public String getUsermane(){
        return nombre;
     }
}
