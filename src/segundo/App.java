package segundo;

import java.util.*;

public class App implements Runnable{

    private Scanner scanner;

    public App(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Digite o valor:");
        float valor = scanner.nextFloat();

        Map<String,Integer> separado = separarNotas(valor);
        printResult(separado);
    }

    private void printResult(Map<String, Integer> separado) {
        System.out.println("NOTAS:");
        System.out.println(separado.get("n100")+"\tNOTAS\tde\tR$\t100.00");
        System.out.println(separado.get("n50")+"\tNOTAS\tde\tR$\t50.00");
        System.out.println(separado.get("n20")+"\tNOTAS\tde\tR$\t20.00");
        System.out.println(separado.get("n10")+"\tNOTAS\tde\tR$\t10.00");
        System.out.println(separado.get("n5")+"\tNOTAS\tde\tR$\t5.00");
        System.out.println(separado.get("n2")+"\tNOTAS\tde\tR$\t2.00");
        System.out.println("\nMOEDAS:");
        System.out.println(separado.get("m100")+"\tMOEDAS\tde\tR$\t1.00");
        System.out.println(separado.get("m50")+"\tMOEDAS\tde\tR$\t0.50");
        System.out.println(separado.get("m25")+"\tMOEDAS\tde\tR$\t0.25");
        System.out.println(separado.get("m10")+"\tMOEDAS\tde\tR$\t0.10");
        System.out.println(separado.get("m5")+"\tMOEDAS\tde\tR$\t0.05");
        System.out.println(separado.get("m1")+"\tMOEDAS\tde\tR$\t0.01");
    }

    public Map<String, Integer> separarNotas(float inicial){
        Map<String,Integer> resultMap = new HashMap<>();
        int n100 = (int)Math.floor(inicial) / 100;
        float mod100 = inicial % 100;
        resultMap.put("n100",n100);
        int n50 = (int)Math.floor(mod100) / 50 ;
        float mod50 = mod100 % 50;
        resultMap.put("n50",n50);
        int n20 = (int)Math.floor(mod50) / 20 ;
        float mod20 = mod50 % 20;
        resultMap.put("n20",n20);
        int n10 = (int)Math.floor(mod20) / 10 ;
        float mod10 = mod20 % 10;
        resultMap.put("n10",n10);
        int n5 = (int)Math.floor(mod10) / 5 ;
        float mod5 = mod10 % 5;
        resultMap.put("n5",n5);
        int n2 = (int)Math.floor(mod5) / 2 ;
        float mod2 = mod5 % 2;
        resultMap.put("n2",n2);

        int m100 = (int)mod2*100 / 100;
        float modm100 = mod2*100 % 100;
        resultMap.put("m100",m100);
        int m50 = (int)Math.floor(modm100) / 50 ;
        float modm50 = modm100 % 50;
        resultMap.put("m50",m50);
        int m25 = (int)Math.floor(modm50) / 25 ;
        float modm25 = modm50 % 25;
        resultMap.put("m25",m25);
        int m10 = (int)Math.floor(modm25) / 10 ;
        float modm10 = modm25 % 10;
        resultMap.put("m10",m10);
        int m5 = (int)Math.floor(modm10) / 5 ;
        float modm5 = modm10 % 5;
        resultMap.put("m5",m5);
        int m1 = (int)Math.ceil(modm5);
        resultMap.put("m1",m1);

        return resultMap;

        }



}
