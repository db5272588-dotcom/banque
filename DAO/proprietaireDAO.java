package DAO;

import config.Connexion;
import model.proprietaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class proprietaireDAO {

    // 1. AFFICHER TOUS LES PROPRIETAIRES
    public ArrayList<proprietaire> getProprietairs() {

        ArrayList<proprietaire> proprietairs = new ArrayList<>();

        String sql = "SELECT id, nom, prenom, adresse FROM proprietaire";

        try (Connection cn = Connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");

                proprietaire p = new proprietaire(id, nom, prenom, adresse);

                proprietairs.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }

        return proprietairs;
    }


    // 2. RECHERCHER UN PROPRIETAIRE PAR ID
    public proprietaire rechercheproprietair(int id) {

        String sql = "SELECT id, nom, prenom, adresse FROM proprietaire WHERE id = ?";

        try (Connection cn = Connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    int idp = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String adresse = rs.getString("adresse");

                    return new proprietaire(idp, nom, prenom, adresse);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }

        return null;
    }


    // 3. AJOUTER UN PROPRIETAIRE
    public void ajouter(proprietaire p) {

        String sql = "INSERT INTO proprietaire (nom, prenom, adresse) VALUES (?, ?, ?)";

        try (Connection cn = Connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getAdresse());

            ps.executeUpdate();

            System.out.println("Proprietaire ajouté avec succès !");

        } catch (SQLException ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }
    }


    // 4. MODIFIER UN PROPRIETAIRE
    public void modifier(proprietaire p) {

        String sql = "UPDATE proprietaire SET nom = ?, prenom = ?, adresse = ? WHERE id = ?";

        try (Connection cn = Connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getAdresse());
            ps.setInt(4, p.getId());

            ps.executeUpdate();

            System.out.println("Proprietaire modifié avec succès !");

        } catch (SQLException ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }
    }


    // 5. SUPPRIMER UN PROPRIETAIRE
    public void supprimer(proprietaire p) {

        String sql = "DELETE FROM proprietaire WHERE id = ?";

        try (Connection cn = Connexion.ouvrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, p.getId());

            ps.executeUpdate();

            System.out.println("Proprietaire supprimé avec succès !");

        } catch (SQLException ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }
    }
}