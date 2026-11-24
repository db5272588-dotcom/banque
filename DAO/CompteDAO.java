//package DAO;
//
//import config.Connexion;
//import model.Compte;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class CompteDAO {
//    // partie Ajouter
//
//     public void ajouter(Compte c){
//         String sql = "INSERT INTO Compte" +"(numero , sold , id_proprietaire)" + " values (? , ? , ?)";
//
//         try (java.sql.Connection cn = Connexion.ouvrir();
//              PreparedStatement ps = cn.prepareStatement(sql)){
//                    ps.setString(1,c.getNumero());
//                    ps.setDouble(2,c.getSold());
//                    ps.setInt(3,c.getId_proprietaire());
//                        ps.executeUpdate();
//           System.out.println("Compte ajouté avec sucsés");
//
//         }catch (SQLException ex){
//             ex.printStackTrace();
//
//         }
//     }
//    // partie Lister
//    public ArrayList<Compte>getComptes (){
//         ArrayList<Compte> comptes = new ArrayList<>();
//        String sql = "SELECT * FROM Compte";
//        try (java.sql.Connection cn = Connexion.ouvrir();
//       PreparedStatement ps =cn.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()){
//
//            while (rs.next()){
//                Compte c = new Compte(
//                        rs.getString("numero"),
//                        rs.getDouble(" sold"),
//                        rs.getInt("id_preprietaire")
//                );
//                comptes.add(c);
//            }
//        }catch (SQLException ex){
//            ex.getMessage();
//        }
//            return comptes;
//    }
//
//    // Recherche
//
//    public Compte chercheParNumero(String numero){
//         String sql = "SELECT * FROM compte WHERE numero = ?";
//
//         try(java.sql.Connection cn = Connexion.ouvrir();
//         PreparedStatement ps = cn.prepareStatement(sql)) {
//             ps.setString(1,numero);
//
//             try (ResultSet rs = ps.executeQuery()) {
//               if (rs.next()){
//
//                   return new Compte(
//                           rs.getString("numero"),
//                           rs.getDouble("solde"),
//                           rs.getInt("id_proprietaire")
//                   );
//               }
//             }
//             }catch (SQLException ex){
//                 ex.getMessage();
//         }
//         return  null;
//    }
//    // Partie Modifier
//
//    public void Modifier(String numero , double nouveauSolde){
//         String sql="UPDATE compte SET solde = ? WHERE numero =?";
//         try (java.sql.Connection cn = Connexion.ouvrir();
//            PreparedStatement ps =cn.prepareStatement(sql)) {
//             ps.setDouble(1,nouveauSolde);
//             ps.setString(2,numero);
//             ps.executeUpdate();
//             System.out.println("Solde modifié avec sucsés.");
//         }catch (SQLException ex){
//             ex.getMessage();
//         }
//    }
//
//    // Partie Supprimer
//
//    public void Supprimer(String numero){
//         String sql = "DELET FROM compte WHERE numero = ?";
//         try (java.sql.Connection cn = Connexion.ouvrir();
//         PreparedStatement ps = cn.prepareStatement(sql)){
//             ps.setString(1,numero);
//             ps.executeUpdate();
//             System.out.println("Compte supprimé avec sucsés");
//
//         }catch (SQLException ex){
//             ex.printStackTrace();
//         }
//
//    }
//}



