//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import DAO.CompteDAO;
import DAO.proprietaireDAO;
import model.Compte;
import model.proprietaire;

void main(){


   //proprietaireDAO pDAO = new proprietaireDAO();

   // proprietaire p = pDAO.rechercheproprietair(2);
    //if (p !=null){
      //  pDAO.supprimer(p);
  //  }


    //p.setAdresse("Dakar");
       // pDAO.modifier(p);


      //proprietaire p = new proprietaire(1 ,"Faye", "khady", "Touba");
   // pDAO.ajouter(p);

   //proprietaire p = pDAO.rechercheproprietair(8);

           //if (p !=null){
         //  System.out.println(p);
       // }

       // ArrayList<proprietaire> properties = pDAO.getProprietairs();
       // for (proprietaire p : properties){
       //     System.out.println(p);
      //  }

    // pour le compte

    CompteDAO cDAO = new CompteDAO();


    //Compte c = new Compte("C001",2000,1);
    //cDAO.ajouter(c);

    //ArrayList<Compte> comptes = cDAO.getComptes();
    //for (Compte c : comptes){
      //  System.out.println(c);
   // }

    //Compte recherche = cDAO.chercheParNumero("C001");
   // if (recherche != null) {
      //  System.out.println("Compte trouvé : " +
      //          recherche.getNumero());
   // }

   //cDAO.Modifier("C002",20000);

    //cDAO.Supprimer("c002");
}