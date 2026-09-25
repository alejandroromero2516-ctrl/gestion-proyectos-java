# Gestión de proyectos

Proyecto educativo en Java que modela un proyecto y sus tareas mediante
programación orientada a objetos.

## Clases

- `Principal`: crea y ejecuta un ejemplo completo.
- `Proyecto`: almacena el presupuesto y administra sus tareas.
- `Tarea`: controla los estados pendiente, en progreso y terminada.

## Requisitos

- JDK 17 o superior.

## Compilar y ejecutar

Desde la raíz del proyecto, en PowerShell:

```powershell
New-Item -ItemType Directory -Force out
javac -encoding UTF-8 -d out src/gestionproyectos/Principal.java src/gestionproyectos/Proyecto.java src/gestionproyectos/Tarea.java
java -cp out gestionproyectos.Principal
```

El ejemplo crea cuatro tareas, completa una e inicia dos. Por lo tanto, el
avance final del proyecto es de 25 %.
