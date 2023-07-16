package quarto;

import java.util.Scanner;

public class App implements Runnable{

    private Scanner scanner;

    public App(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Digite a quantidade de casos de teste");
        int ammount = scanner.nextInt();
        if (ammount == 0) {
            return;
        }

        String[] casos = new String[ammount];
        //BEGIN: bugfix -> scanner skip
        scanner.nextLine();
        //END: bugfix -> scanner skip

        for (int i = 0; i < ammount; i++){
            System.out.println("Digite o elemento N: " + String.valueOf(i+1));
            casos[i] = scanner.nextLine();
        }

        for (int j = 0; j < casos.length; j++){
            char[] textArr = casos[j].toCharArray();
            int len = textArr.length;
            char[] newArr = new char[textArr.length];

            for (int i = 0; i < len/2 ; i++){
                newArr[i] = textArr[(len/2 - 1) - i];
            }

            for (int i = len/2; i < len ; i++){
                newArr[i] = textArr[(len - i) + (len/2 - 1)];
            }

            casos[j] = String.valueOf(newArr);
        }

        for (String s : casos){
            System.out.println(s);
        }


    }

}
