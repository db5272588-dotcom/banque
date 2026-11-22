package DAO;

import config.Connexion;
import model.proprietaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProprietaireDAO {
    public ArrayList<proprietaire> getProprietairs(){
        ArrayList<proprietaire> proprietairs=new ArrayList<>();
        String sql= "select id,nom,prenom,adresse from Proprietair";

        try (Connection cn = Connexion .ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                proprietaire p = new proprietaire(id,nom,prenom,adresse);
                proprietairs.add(p);
            }

        }catch (SQLException ex){
            System .out.println(" Erreur:"+ex.getMessage());
        }
        return proprietairs;
    }

    public proprietaire rechercheproprietairs( int id){
        String sql= "select ,nom,prenom,adresse from Proprietair where id = ?";

        try (Connection cn = Connexion .ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql);){
            ps.setInt( 1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                proprietaire p = new proprietaire(id,nom,prenom,adresse);
               return p;
            }

        }catch (SQLException ex){
            System .out.println(" Erreur:"+ex.getMessage());
        }
        return null;
    }

    public void  ajouter (proprietaire p ){
        String sql = "INSERT INTO proprietaire(nom, prenom, adresse) VALUES(? , ? , ?)";
        try( Connection cn = Connexion.ouvrir();
        PreparedStatement ps = cn.prepareStatement(sql)) {
         ps.setString(1,p.getNom());
            ps.setString(1,p.getPrenom());
            ps.setString(1,p.getAdresse());

        } catch (SQLException ex){
            System.out.println("Erreur :"+ex.getMessage());
        }
    }
}
