package tema1.ra1;

import java.util.Scanner;

public class Ej2Hijo {
    public static void main(String[] args) {
        //Necesita Scanner para saber que le pasa el padre
        double numero = Double.valueOf(args[0]);
        double doble = numero * 2;
        System.out.println(doble);
    }
}
