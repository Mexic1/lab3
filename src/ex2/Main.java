package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Users\\cmora\\Desktop\\Faculta\\Anul3\\Sem1\\PJ\\lab3\\src\\ex2\\in.txt  "));
        List<String> items = null;
        List<Produs> produse=new ArrayList<>();

        String nume = "";
        Double pret=0.0;
        Integer cantitate=0;
        LocalDate dataExpirare=LocalDate.now();

        System.out.println("Produsele sunt:");

        int i=0;
            while (sc.hasNext()) {
                items = List.of(sc.nextLine().split("\\s*,\\s*"));
                for (String item : items) {
                    if(i==0){
                         nume = item;
                    }
                    if(i==1){
                         pret = Double.parseDouble(item);
                    }
                    if(i==2){
                         cantitate = Integer.parseInt(item);
                    }
                    if(i==3){
                         dataExpirare = LocalDate.parse(item);
                    }
                    i++;
                    if(i==4){
                        Produs p = new Produs(nume,pret,cantitate,dataExpirare);
                        produse.add(p);
                        System.out.println(p);
                        i=0;
                    }
                }
            }

        System.out.println("\n");
        System.out.println("Produsele expirate sunt:");

        for(Produs p:produse) {
            if(p.getDataExpirare().isBefore(LocalDate.now())){
                System.out.println(p);
            }
        }

        System.out.println("\n");




    }
}
