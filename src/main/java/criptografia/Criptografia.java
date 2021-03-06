/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Samuel
 */
public class Criptografia {

    public static void main(String[] args) {

        String palabra;
        int opcion;
        boolean repetir = true;
        String invertida = "";
        Scanner teclado = new Scanner(System.in);
        do {
            //Menú de opciones
            System.out.println("¿Que desea hacer?\n"
                    + "1.- Cifrar\n"
                    + "2.- Descifrar\n"
                    + "3.- Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    palabra = "";
                    invertida = "";
                    //La elección 1 en la que el usuario introduce una palabra y 
                    //se encripta
                    System.out.println("Tu elección: 1");
                    System.out.println("Introduzca la palabra a cifrar");
                    palabra = teclado.next();
                    //Imagen especular
                    //Recorre el array d3e palabra poniendo las palabras en el sentido contrario al que irían normalmente.
                    for (int indice = palabra.length() - 1; indice >= 0; indice--) {
                        // Y vamos concatenando cada carácter a la nueva cadena
                        invertida += palabra.charAt(indice);
                    }
                    System.out.println("Imagen especular: " + invertida);

                    //Sustitución de vocales, y para ello utilizo el método replace para reemplazar el primer char puesto con el segundo puesto
                    //que en este caso sería el número.
                    invertida = invertida.replace('u', '1').replace('o', '2')
                            .replace('i', '3').replace('e', '4').replace('a', '5');
                    System.out.println("Sustitución de vocales: " + invertida);
                    //Cadena cifrada, creo dos char, o dos letras con el método random y las concateno a la palabra, por
                    //último, realizo lo mísmo que el paso anterior y cambio las posibles vacales por números.
                    Random aleatorio = new Random();
                    char letraDelantera = (char) (aleatorio.nextInt(26) + 'a');
                    char letraTrasera = (char) (aleatorio.nextInt(26) + 'a');
                    invertida = letraDelantera + invertida + letraTrasera;
                    invertida = invertida.replace('u', '1').replace('o', '2')
                            .replace('i', '3').replace('e', '4').replace('a', '5');
                    System.out.println("Cadena cifrada: " + invertida);
                    invertida = "";
                    palabra = "";
                    break;
                case 2:
                    invertida = "";
                    palabra = "";
                    //Esta es la opción 2, donde el usuario introduce una palabra ya encriptada y el
                    //programa lo desencripta
                    System.out.println("Tu elección: 2");
                    System.out.println("Introduzca una palabra");
                    palabra = teclado.next();
                    //Cadena cifrada
                    //Creo una arraylist de char.
                    List<Character> encriptada = new ArrayList<>();
                    //Recorro el array de palabra con un for each recorre con el cuál
                    //voy metiendo cada valor del array (String) palabra en encriptada
                    for (char recorrer : palabra.toCharArray()) {
                        encriptada.add(recorrer);
                    }
                    //Elimina el valor que esté en la posición 0 (es decir el primero)
                    encriptada.remove(0);
                    //Elimina el último valor del array encriptada
                    int ultimo = encriptada.size() - 1;
                    encriptada.remove(ultimo);
                    //Creo un string para meter el arraylist de encriptada
                    String palabraEncriptada = new String();
                    for (char letra : encriptada) {
                        palabraEncriptada += letra;
                    }

                    System.out.println("Cadena cifrada: " + palabraEncriptada);
                    //Sustitución de vocales. Sustituyo en este caso los números de la izquierda
                    //por la vocal de la derecha
                    palabraEncriptada = palabraEncriptada.replace('1', 'u').replace('2', 'o')
                            .replace('3', 'i').replace('4', 'e').replace('5', 'a');
                    System.out.println("Sustitución de vocales: " + palabraEncriptada);
                    //Cadena descifrada, recorro el array de palabraEncriptada al revés para 
                    //colocar las letras al revés.
                    for (int indice = palabraEncriptada.length() - 1; indice >= 0; indice--) {
                        // Y vamos concatenando cada carácter a la nueva cadena
                        invertida += palabraEncriptada.charAt(indice);
                    }
                    System.out.println("Cadena descifrada: " + invertida);
                    palabra = "";
                    break;
                case 3:
                    System.out.println("Tu elección: 3");
                    System.out.println("Ha decidido salir");
                    repetir = false;
                    break;
            }
        } while (repetir);
    }
}
