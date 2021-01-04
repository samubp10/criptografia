/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;
import java.util.Scanner;
/**
 *
 * @author Samuel
 */
public class Criptografia {
    public static void main(String[] args) {
        
        String palabra;
        int opcion;
        boolean repetir = true;
        Scanner teclado = new Scanner(System.in);
        do{
        System.out.println("¿Que desea hacer?\n"
                + "1.- Cifrar\n"
                + "2.- Descifrar\n"
                + "3.- Salir");
        opcion = teclado.nextInt();
        
        switch (opcion) {
                case 1:
                    System.out.println("Tu elección: 1");
                    System.out.println("Introduzca la palabra a cifrar");
                    palabra = teclado.next();
                    
                    break;
                case 2:
                    System.out.println("Tu elección: 2");
                    System.out.println("Introduzca una palabra");
                    palabra = teclado.next();
                    break;
                case 3:
                    System.out.println("Tu elección: 2");
                    System.out.println("Ha decidido salir");
                    repetir=false;
                    break;
            }
        }while(repetir);
    }
}
