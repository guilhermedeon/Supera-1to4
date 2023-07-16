package primeiro;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

public class App implements Runnable{

    private Scanner scanner;

    public App(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Digite o numero de itens");
        int size = scanner.nextInt();
        if (size == 0){
            return;
        }

        int[] values = new int[size];
        for (int i = 0; i < size; i++){
            System.out.println("Digite o valor para o elemento N:" + String.valueOf(i+1));
            values[i] = scanner.nextInt();
        }

        System.out.println("\n Resultado: \n");

        int [][] resultado = separarValores(values);
        Arrays.sort(resultado[0]);
        Arrays.sort(resultado[1]);
        resultado[1] = sortDesc(resultado[1]);
        printArray(resultado[0],Optional.of("Pares - Asc"));
        printArray(resultado[1],Optional.of("\nInpares - Desc"));
    }

    private int[] sortDesc(int[] ints) {
        int[] result = new int[ints.length];
        for (int i = 0; i < ints.length; i++){
            result[i] = ints[ints.length - i - 1];
        }
        return result;
    }

    private void testeSoma(int[] array){
        int soma = 0;
        for (int i : array){
            soma = soma + i;
        }
        System.out.println("TESTE - SOMA : " + String.valueOf(soma));
    }

    private void printArray(int[] array, Optional<String> header){
        if (header.isPresent()){
            System.out.println(header.get());
        }
        for (int i : array){
            System.out.println(i);
        }
    }

    private int[][] separarValores(int[] array){
        int [] pares;
        int [] inpares;
        int parIndex = 0;
        int inparIndex = 0;

        if (array.length % 2 == 0){
            pares = new int[array.length/2];
            inpares = new int[array.length/2];
        }
        else {
            pares = new int[array.length/2];
            inpares = new int[(array.length/2)+1];
        }

        for (int i : array){
            if (i % 2 == 0){
                pares[parIndex] = i;
                parIndex++;
            }
            else {
                inpares[inparIndex] = i;
                inparIndex++;
            }
        }
        return new int[][]{pares, inpares};
    }
}
