package DAO;


import config.Connexion;
import model.Compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class CompteDAO {


        public void ajouter(Compte c) {

            String sql = "INSERT INTO compte (numero, solde, proprietaire_id) VALUES (?, ?, ?)";

            try (Connection con = Connexion.ouvrir();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, c.getNumero());
                ps.setDouble(2, c.getSolde());
                ps.setInt(3, c.getProprietaireId());

                ps.executeUpdate();

                System.out.println("Compte ajouté avec succès !");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        public List<Compte> listerTous() {

            List<Compte> comptes = new ArrayList<>();

            String sql = "SELECT * FROM compte";

            try (Connection con = Connexion.ouvrir();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Compte c = new Compte(
                            rs.getString("numero"),
                            rs.getDouble("solde"),
                            rs.getInt("proprietaire_id")
                    );

                    comptes.add(c);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return comptes;
        }


        // READ : Chercher un compte par son numéro
        public Compte chercherParNumero(String numero) {

            String sql = "SELECT * FROM compte WHERE numero = ?";

            try (Connection con = Connexion.ouvrir();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, numero);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {

                        return new Compte(
                                rs.getString("numero"),
                                rs.getDouble("solde"),
                                rs.getInt("proprietaire_id")
                        );
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }


        // UPDATE : Modifier le solde d'un compte
        public void modifierSolde(String numero, double nouveauSolde) {

            String sql = "UPDATE compte SET solde = ? WHERE numero = ?";

            try (Connection con = Connexion.ouvrir();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setDouble(1, nouveauSolde);
                ps.setString(2, numero);

                ps.executeUpdate();

                System.out.println("Solde modifié avec succès !");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        // DELETE : Supprimer un compte
        public void supprimer(String numero) {

            String sql = "DELETE FROM compte WHERE numero = ?";

            try (Connection con = Connexion.ouvrir();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, numero);

                ps.executeUpdate();

                System.out.println("Compte supprimé avec succès !");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        // BONUS : Lister les comptes d'un propriétaire
        public List<Compte> listerParProprietaire(int proprietaireId) {

            List<Compte> comptes = new ArrayList<>();

            String sql = "SELECT * FROM compte WHERE proprietaire_id = ?";

            try (Connection con = Connexion.ouvrir();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, proprietaireId);

                try (ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {

                        Compte c = new Compte(
                                rs.getString("numero"),
                                rs.getDouble("solde"),
                                rs.getInt("proprietaire_id")
                        );

                        comptes.add(c);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return comptes;
        }
    }



