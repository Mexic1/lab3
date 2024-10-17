package ex2;

import java.time.LocalDate;

public class Produs {
    private String nume;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirare;
    public static int vanzari=0;

    public Produs(String nume, double pret,int cantitate,LocalDate dataExpirare) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirare=dataExpirare;
    }

    public String getNume() {
        return nume;
    }

    public double getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public LocalDate getDataExpirare() {
        return dataExpirare;
    }

    public int getVanzari() {return vanzari;}

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setCantitate(int cantitate) {this.cantitate = cantitate;}


    @Override
    public String toString() {
        return "Produs{" + "nume='" + nume + '\'' + ", pret=" + pret + ", cantitate=" + cantitate + ", dataExpirare=" + dataExpirare + '}';
    }
}
