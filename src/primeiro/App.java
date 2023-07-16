package primeiro;

import java.util.*;

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

        ArrayList<Integer> valores = new ArrayList<>();

        for (int i = 0; i < size; i++){
            System.out.println("Digite o valor para o elemento N:" + String.valueOf(i+1));
            valores.add(scanner.nextInt());
        }

        printResultado(separarParImpar(valores));

    }

    private ArrayList<ArrayList<Integer>>  separarParImpar(ArrayList<Integer> valores){
        ArrayList<Integer> inpares = new ArrayList<>();
        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();
        for (int i : valores){
            if (i % 2 == 0){
                pares.add(i);
            }
            else inpares.add(i);
        }
        Collections.sort(pares);
        Collections.sort(inpares, Collections.reverseOrder());
        resultado.add(pares);
        resultado.add(inpares);
        return resultado;
    }

    private void printResultado(ArrayList<ArrayList<Integer>> myResults){
        System.out.println("\nPares: Asc\n");
        for (int i : myResults.get(0)){
            System.out.println(i);
        }
        System.out.println("\nInpares: Desc\n");
        for (int i : myResults.get(1)){
            System.out.println(i);
        }
    }

}
