package tema1.ej3;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Rehacer pero que haya un proceso hijo que te calcule la suma de dos numeros
        int n1;
        int n2;
        int resultado;
        String in;

        while (true){
            System.out.println("Introduce el primer numero: ");
            try{
                in = sc.nextLine();
                n1 = Integer.parseInt(in);
                while(true){
                    System.out.println("Introduce el segundo numero: ");
                    in = sc.nextLine();
                    try{
                        n2 = Integer.parseInt(in);
                        break;

                    } catch (NumberFormatException e){
                        System.err.println("ERROR: Introduce un numero entero" + e.getMessage());
                    }
                }
                break;
            } catch (NumberFormatException e){
                System.err.println("ERROR: Introduce un numero entero" + e.getMessage());
            }
        }
        resultado = n1 + n2;
        System.out.println("Resultado: " + resultado);
    }
}
