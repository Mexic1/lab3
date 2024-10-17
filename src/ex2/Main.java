package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Produs> produse = new ArrayList<>();

        try (Scanner sc = new Scanner(new File("F:\\IS Anul 3\\Semestrul 1\\PJ\\lab3\\src\\ex2\\in.txt"))) {
            System.out.println("Produsele sunt:");

            while (sc.hasNextLine()) {
                String linie = sc.nextLine();
                String[] items = linie.split("\\s*,\\s*");

                if (items.length == 4) {
                    String nume = items[0];
                    double pret = Double.parseDouble(items[1]);
                    int cantitate = Integer.parseInt(items[2]);
                    LocalDate dataExpirare = LocalDate.parse(items[3]);

                    Produs p = new Produs(nume, pret, cantitate, dataExpirare);
                    produse.add(p);
                    System.out.println(p);
                } else {
                    System.out.println("Linie invalidă: " + linie);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("A apărut o eroare: " + e.getMessage());
            return;
        }
        System.out.println("\n");

        while(true){
            System.out.println("Meniu:");
            System.out.println("1. Afisare produse");
            System.out.println("2. Afisare produse expirate");
            System.out.println("3. Vanzare produse");
            System.out.println("4. Pret minim");
            System.out.println("5. Cantitate<x");
            System.out.println("6. Iesire");

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduceti optiunea:");
            int optiune = sc.nextInt();
            System.out.println("\n");

            switch (optiune) {
                case 1:  System.out.println(new Main().afisareProduse(produse));
                         System.out.println("\n");
                         break;

                case 2: produseExpirate(produse).forEach(System.out::println);
                        System.out.println("\n");
                        break;

                case 3: System.out.println("Introduceti numele produsului:");
                        String nume = sc.next();
                        System.out.println("Introduceti cantitatea:");
                        int cantitate = sc.nextInt();
                        vanzareProduse(produse, nume, cantitate);
                        System.out.println("\n");
                        System.out.println("Vanzari totale: " + Produs.vanzari);
                    break;

                case 4:pretMinim(produse);
                    break;

                case 5:
                    System.out.println("Introduceti cantitatea:");
                    int x = sc.nextInt();
                    cantitateX(produse, x);
                    break;

                case 6:
                    return;
                default: System.out.println("Optiune invalida");
            }
        }


    }

    public String afisareProduse(List<Produs> produse){
        StringBuilder sb = new StringBuilder();
        for (Produs p : produse) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

    public static List<Produs> produseExpirate(List<Produs> produse){
        List<Produs> expirate = new ArrayList<>();
        LocalDate acum = LocalDate.now();
        for (Produs p : produse) {
            if (p.getDataExpirare().isBefore(acum)) {
                expirate.add(p);
            }
        }
        return expirate;
    }

    public static void vanzareProduse(List<Produs> produse, String nume, int cantitate){
        for (Produs p : produse) {
            if (p.getNume().equals(nume)) {
                if (p.getCantitate() >= cantitate) {
                    p.setCantitate(p.getCantitate() - cantitate);
                    Produs.vanzari += cantitate*p.getPret();
                    System.out.println("Vanzare realizată cu succes");
                    return;
                } else {
                    System.out.println("Cantitate insuficientă");
                    return;
                }
            }
            if(p.getCantitate()==0){produse.remove(p);}
        }
        System.out.println("Produsul nu a fost găsit");
    }

    public  static void pretMinim(List<Produs> produse){
        double min = Double.MAX_VALUE;
        for (Produs p : produse)
        {
            if (p.getPret() < min)
            {
                min = p.getPret();
            }
        }
        for(Produs p:produse) {
            if (p.getPret() == min) {
                System.out.println(p);
            }
        }
    }

    public static void cantitateX(List<Produs> produse, int x) {

        try {
            PrintWriter writer = new PrintWriter("F:\\IS Anul 3\\Semestrul 1\\PJ\\lab3\\src\\ex2\\out.txt");

            for (Produs p : produse) {
                if (p.getCantitate() < x) {
                    writer.println(p);
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("A apărut o eroare: " + e.getMessage());
            return;
        }
    }

}
