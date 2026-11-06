# Sistema de Gestión de Comunidad eSports

Proyecto académico para la materia de Programación Orientada a Objetos (POO).

## Descripción del Sistema
Sistema en consola desarrollado en Java para gestionar una comunidad de jugadores y coaches de eSports. Permite la administración de perfiles, disponibilidad semanal, programación y cancelación de duelos, sesiones de coaching y consolidación de estadísticas y sanciones.

## Conceptos POO Aplicados
- Clases abstractas (`Persona`, `Actividad`) y clases concretas (`Jugador`, `Coach`, `Duelo`, `SesionCoaching`).
- Interfaces de comportamiento (`Cancelable`, `Reprogramable`).
- Encapsulamiento con validaciones de atributos.
- Polimorfismo y sobreescritura de métodos (`@Override`).
- Colecciones dinámicas (`ArrayList`), arreglos estáticos y matrices bidimensionales (`boolean[][]`).
- Upcasting, downcasting y uso de clases Wrapper.

## Tecnologías Utilizadas
- Lenguaje: Java (JDK 17+)
- IDE: Apache NetBeans
- Control de versiones: Git & GitHub

## Instrucciones de Ejecución
1. Clonar o descargar el repositorio.
2. Abrir la carpeta del proyecto en Apache NetBeans.
3. Compilar y ejecutar la clase principal `MainConsola.java` ubicada en el paquete `vista`.
