package model;

public class Compte {

    private String numero;
    private double solde;
    private int id_proprietaire;

    public Compte(String numero, double solde, int id_proprietaire) {
        this.numero = numero;
        this.solde = solde;
        this.id_proprietaire = id_proprietaire;
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }
    public void setSolde( double solde){
        this.solde=solde;
    }
    public String toString(){
        return numero + " " + solde + " " + id_proprietaire;
    }
}

