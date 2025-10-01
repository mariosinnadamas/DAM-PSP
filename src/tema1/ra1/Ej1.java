package tema1.ra1;

/*
    Crea una clase Java que calcule cuántos divisores tiene un número que le
    pasaremos por parámetro. El resultado nos los mostrará posteriormente por pantalla.
 */

public class Ej1 {
    public static void main(String[] args) {
        /*
        Crea una clase Java que calcule cuántos divisores tiene un número que le
        pasaremos por parámetro. El resultado nos los mostrará posteriormente por
        pantalla.
         */

        if (args.length != 1){
            System.err.println("ERROR: Debes introducir un número entero");
            System.exit(1);
        }

        try {
            int numero = Integer.parseInt(args[0]);
            int divisores = contarDivisores(numero);
            System.out.println(divisores + " divisores de " + numero);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Debes introducir un numero entero");
        }
    }
    public static int contarDivisores(int n){
        int contador = 0;
            for (int i = 1; i <= n; i++){
                if (n % i == 0){
                    contador++;
                }
            }
        return contador;
    }
}
