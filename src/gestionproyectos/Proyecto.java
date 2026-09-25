package gestionproyectos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Proyecto {

    private final String nombre;
    private double presupuesto;
    private final List<Tarea> tareas;

    public Proyecto(String nombre, double presupuesto) {
        this.nombre = validarNombre(nombre);
        validarPresupuesto(presupuesto);
        this.presupuesto = presupuesto;
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public List<Tarea> getTareas() {
        return Collections.unmodifiableList(tareas);
    }

    public void setPresupuesto(double presupuesto) {
        validarPresupuesto(presupuesto);
        this.presupuesto = presupuesto;
    }

    public void agregarTarea(Tarea tarea) {
        if (tarea == null) {
            throw new IllegalArgumentException("La tarea no puede ser null.");
        }

        tareas.add(tarea);
        System.out.println("Tarea agregada: " + tarea.getNombre());
    }

    public double calcularAvance() {
        if (tareas.isEmpty()) {
            return 0.0;
        }

        int terminadas = 0;
        for (Tarea tarea : tareas) {
            if (Tarea.TERMINADA.equals(tarea.getEstado())) {
                terminadas++;
            }
        }

        return (double) terminadas / tareas.size() * 100;
    }

    public void listarTareas() {
        System.out.println("\n=============================");
        System.out.println(" PROYECTO: " + nombre);
        System.out.printf(" Presupuesto: $%,.0f%n", presupuesto);
        System.out.printf(" Avance: %.1f%%%n", calcularAvance());
        System.out.println("=============================");

        int numero = 1;
        for (Tarea tarea : tareas) {
            System.out.println(" " + numero++ + ". " + tarea);
        }

        System.out.println("=============================");
    }

    public Tarea buscarPorResponsable(String responsable) {
        if (responsable == null || responsable.isBlank()) {
            return null;
        }

        for (Tarea tarea : tareas) {
            if (responsable.equals(tarea.getResponsable())) {
                return tarea;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ROOT,
                "[%s] Avance: %.1f%%",
                nombre,
                calcularAvance()
        );
    }

    private static String validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del proyecto no puede estar vacío.");
        }

        return nombre.trim();
    }

    private static void validarPresupuesto(double presupuesto) {
        if (presupuesto < 0 || !Double.isFinite(presupuesto)) {
            throw new IllegalArgumentException("El presupuesto debe ser un número positivo.");
        }
    }
}
