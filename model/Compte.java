package model;

public class Compte {
    private final String numero;
    private  double sold;
    private final int id_proprietaire;

    public Compte(String numero, double sold, int id_proprietaire){
        this.numero = numero;
        this.sold = sold;
        this.id_proprietaire = id_proprietaire;
    }
    public String getNumero(){
        return numero;
    }
    public double getSold(){
        return sold;
    }
    public int getId_proprietaire(){
        return id_proprietaire;
    }
    public void setSold(double sold){
        this.sold = sold;
    }
}

