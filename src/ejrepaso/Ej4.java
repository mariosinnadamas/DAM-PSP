package ejrepaso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Alumno> alumnos = new ArrayList<>();

        System.out.println("Introduce los datos de 6 alumnos (nombre y nota).");
        System.out.println("Si no quieres introducir una nota, presiona enter");

        for (int i = 1; i <= 6; i++) {
            System.out.println("Alumno " + i + ":");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("No se ha introducido un nombre, se pondrá Alumno " + i);
                nombre = "Alumno " + i;
            }
            if (nombre.matches("[0-9]+")) {
                System.out.println("No se ha introducido un nombre, se pondrá Alumno " + i);
                nombre = "Alumno " + i;
            }

            Double nota = null;
            System.out.print("Nota: ");
            //Control de espacios y si presiona enter la cadena se queda como ""
            String notaStr = sc.nextLine().trim();
            //Si la cadena no esta vacía la convierte a Double, de lo contrario hará que ese alumno no tenga nota
            if (!notaStr.isEmpty()) {
                try {
                    nota = Double.parseDouble(notaStr);
                } catch (NumberFormatException e) {
                    System.out.println("Nota no válida. Se considerará sin nota.");
                }
            }

            alumnos.add(new Alumno(nombre, nota));
        }

        //Calcular media
        double suma = 0;
        int contador = 0;
        for (Alumno a : alumnos) {
            if (a.getNota() != null) {
                suma += a.getNota();
                contador++;
            }
        }

        double media = suma / contador;

        //Mostrar resultados
        System.out.println("La media de alumnos es: " + media);
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }
}
