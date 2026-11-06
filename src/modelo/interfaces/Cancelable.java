package modelo.interfaces;

import modelo.personas.Persona;

public interface Cancelable {
    boolean cancelar(Persona solicitante, String motivo);
}
