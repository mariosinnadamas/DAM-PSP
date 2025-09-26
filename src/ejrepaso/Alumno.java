package ejrepaso;

public class Alumno {
    private String nombre;
    private Double nota;

    public Alumno(String nombre, Double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }
}
