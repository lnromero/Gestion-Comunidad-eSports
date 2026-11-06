# Proyecto: Sistema de Gestión de Comunidad eSports

Proyecto desarrollado para el primer parcial de Programación Orientada a Objetos (POO).

## ¿De qué trata el proyecto?
Es una aplicación por consola en Java para administrar una comunidad de jugadores y coaches de eSports. El sistema permite registrar usuarios, gestionar horarios semanales de disponibilidad, coordinar duelos y sesiones de entrenamiento, y llevar el registro de victorias, derrotas y penalizaciones.

## Conceptos de la materia aplicados
- **Clases y Herencia:** Superclases abstractas (`Persona`, `Actividad`) y clases hijas (`Jugador`, `Coach`, `Duelo`, `SesionCoaching`).
- **Interfaces:** `Cancelable` y `Reprogramable` para estandarizar las acciones de las actividades.
- **Polimorfismo:** Sobreescritura de métodos (`@Override`) para resolver cancelaciones y sanciones según el tipo de actividad.
- **Estructuras de datos:** 
  - Matrices (`boolean[][]`) para las franjas horarias semanales.
  - Arreglos estáticos y dinámicos (`ArrayList`) para gestionar usuarios, actividades y estadísticas en memoria.
- **Buenas prácticas:** Encapsulamiento con getters/setters, validación de datos por teclado sin excepciones y uso de wrappers (`Integer`).

## Tecnologías
- **Lenguaje:** Java
- **IDE:** Apache NetBeans
- **Control de versiones:** Git y GitHub

## Cómo ejecutarlo
1. Descargar o clonar este repositorio.
2. Abrir la carpeta del proyecto en NetBeans.
3. Ir al paquete `vista`, hacer clic derecho sobre `MainConsola.java` y seleccionar **Run File**.
