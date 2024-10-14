package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class EX1 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc=new Scanner(new File("F:\\IS Anul 3\\Semestrul 1\\PJ\\lab3\\src\\ex1\\in.txt"));
        List<Parabola> puncte=new ArrayList<Parabola>();

        while(sc.hasNextInt()) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            puncte.add(new Parabola(a,b,c));
        }

        System.out.println("Lista contine punctele:");
        for(Parabola p:puncte) {
            System.out.println(p+" | "+p.Varf());

        }




//        puncte.remove(0);
//        System.out.println("Dupa stergerea primului element "+"lista contine punctele:");
//        for (int i=0;i<puncte.size();i++)
//            System.out.println(puncte.get(i));

    }
}
