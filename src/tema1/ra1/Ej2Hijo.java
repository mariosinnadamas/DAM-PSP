package tema1.ra1;

import java.util.Scanner;

public class Ej2Hijo {
    public static void main(String[] args) {
        //Necesita Scanner para saber que le pasa el padre
        Scanner sc = new Scanner(System.in);
        double numero = sc.nextDouble();
        double doble = numero * 2;
        System.out.println(doble);
    }
}
