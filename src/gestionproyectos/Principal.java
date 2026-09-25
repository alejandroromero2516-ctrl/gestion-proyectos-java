package gestionproyectos;

public class Principal {

    public static void main(String[] args) {
        Tarea t1 = new Tarea("Análisis de requisitos", "Ana");
        Tarea t2 = new Tarea("Diseño de la base de datos", "Carlos");
        Tarea t3 = new Tarea("Desarrollo backend", "Luis");
        Tarea t4 = new Tarea("Testing", "María");

        Proyecto proyecto = new Proyecto("Sistema de nómina", 50_000_000);

        proyecto.agregarTarea(t1);
        proyecto.agregarTarea(t2);
        proyecto.agregarTarea(t3);
        proyecto.agregarTarea(t4);

        proyecto.listarTareas();

        t1.completar();
        t2.iniciar();
        t3.iniciar();

        System.out.println("\nEstado actualizado:");
        proyecto.listarTareas();
        System.out.println(proyecto);
    }
}
