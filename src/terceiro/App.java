package terceiro;

import java.util.ArrayList;
import java.util.Collections;
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
        if (size == 0) {
            return;
        }

        System.out.println("Digite o valor alvo");
        int target = scanner.nextInt();

        int[] values = new int[size];

        for (int i = 0; i < size; i++){
            System.out.println("Digite o valor para o elemento N:" + String.valueOf(i+1));
            values[i] = scanner.nextInt();
        }

        System.out.println("\n Resultado - quantidade de pares:");
        System.out.println(resultar(values,target));



    }


    public int resultar(int[] values, int target){
        int res = 0;
        for (int i = 0; i < values.length; i++){
            for (int j = 0; j < values.length; j++){
                if (j != i){
                    if (values [i] - values [j] == target){
                        res = res + 1;
                    }
                }
            }
        }
        return res;
    }

}
