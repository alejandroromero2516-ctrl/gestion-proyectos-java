package gestionproyectos;

public class Tarea {

    public static final String PENDIENTE = "pendiente";
    public static final String EN_PROGRESO = "en progreso";
    public static final String TERMINADA = "terminada";

    private String nombre;
    private String responsable;
    private String estado;

    public Tarea(String nombre, String responsable) {
        this.nombre = validarTexto(nombre, "nombre");
        this.responsable = validarTexto(responsable, "responsable");
        this.estado = PENDIENTE;
    }

    public String getNombre() {
        return nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "nombre");
    }

    public void setResponsable(String responsable) {
        this.responsable = validarTexto(responsable, "responsable");
    }

    public void setEstado(String estado) {
        if (!esEstadoValido(estado)) {
            throw new IllegalArgumentException("Estado inválido: " + estado);
        }

        this.estado = estado;
    }

    public void iniciar() {
        if (PENDIENTE.equals(estado)) {
            estado = EN_PROGRESO;
            System.out.println("Tarea iniciada: " + nombre);
        } else {
            System.out.println("La tarea ya fue iniciada o terminada.");
        }
    }

    public void completar() {
        if (!TERMINADA.equals(estado)) {
            estado = TERMINADA;
            System.out.println("Tarea completada: " + nombre + " por " + responsable);
        } else {
            System.out.println("Esta tarea ya estaba terminada.");
        }
    }

    public void pausar() {
        if (EN_PROGRESO.equals(estado)) {
            estado = PENDIENTE;
            System.out.println("Tarea pausada: " + nombre);
        } else {
            System.out.println("Solo se puede pausar una tarea en progreso.");
        }
    }

    @Override
    public String toString() {
        return "[" + estado.toUpperCase() + "] " + nombre + " -> " + responsable;
    }

    private static String validarTexto(String texto, String campo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(
                    "El " + campo + " de la tarea no puede estar vacío."
            );
        }

        return texto.trim();
    }

    private static boolean esEstadoValido(String estado) {
        return PENDIENTE.equals(estado)
                || EN_PROGRESO.equals(estado)
                || TERMINADA.equals(estado);
    }
}
