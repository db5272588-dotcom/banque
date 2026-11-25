package DAO;

  import config.Connexion;
  import model.Compte;

  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.util.ArrayList;

  public class CompteDAO {
   // partie Ajouter

    public void ajouter(Compte c){
        String sql = "INSERT INTO compte (numero, solde, id_proprietaire) VALUES (?, ?, ?)";

         try (java.sql.Connection cn = Connexion.ouvrir();
              PreparedStatement ps = cn.prepareStatement(sql)){
             ps.setString(1,c.getNumero());
             ps.setDouble(2,c.getSolde());
             ps.setInt(3,c.getId_proprietaire());
             ps.executeUpdate();
          System.out.println("Compte ajouté avec sucsés");

         }catch (SQLException ex){
             System.out.println("Erreur : " + ex.getMessage());

      }

         }
    // partie Lister
    public ArrayList<Compte>getComptes(){
         ArrayList<Compte> comptes = new ArrayList<>();
        String sql = "SELECT numero, solde, id_proprietaire FROM compte";
        try (java.sql.Connection cn = Connexion.ouvrir();
       PreparedStatement ps =cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                Compte c = new Compte(
                        rs.getString("numero"),
                        rs.getDouble("solde"),
                        rs.getInt("id_proprietaire")
                );
                comptes.add(c);
            }
        }catch (SQLException ex){
            System.out.println("Erreur : " + ex.getMessage());
        }
            return comptes;
    }

    // Recherche

    public Compte chercheParNumero(String numero){
         String sql = "SELECT * FROM compte WHERE numero = ?";

         try(java.sql.Connection cn = Connexion.ouvrir();
         PreparedStatement ps = cn.prepareStatement(sql)) {
             ps.setString(1,numero);
             try (ResultSet rs = ps.executeQuery()) {
               if (rs.next()){

                   return new Compte(
                           rs.getString("numero"),
                           rs.getDouble("solde"),
                           rs.getInt("id_proprietaire")
                   );
               }
             }
            }catch (SQLException ex){
             System.out.println("Erreur : " + ex.getMessage());
         }
        return  null;
    }

    // Partie Modifier

    public void Modifier(String numero , double nouveauSolde){
         String sql="UPDATE compte SET solde = ? WHERE numero =?";
         try (java.sql.Connection cn = Connexion.ouvrir();
            PreparedStatement ps =cn.prepareStatement(sql)) {
             ps.setDouble(1,nouveauSolde);
             ps.setString(2,numero);
             ps.executeUpdate();
             System.out.println("Solde modifié avec sucsés.");
         }catch (SQLException ex){
             System.out.println("Erreur : " + ex.getMessage());
         }
    }

    // Partie Supprimer

    public void Supprimer(String numero){
         String sql = "DELETE FROM compte WHERE numero = ?";
         try (java.sql.Connection cn = Connexion.ouvrir();
         PreparedStatement ps = cn.prepareStatement(sql)){
             ps.setString(1,numero);
             ps.executeUpdate();
             System.out.println("Compte supprimé avec sucsés");

         }catch (SQLException ex){
             System.out.println("Erreur : " + ex.getMessage());
         }

    }
}



