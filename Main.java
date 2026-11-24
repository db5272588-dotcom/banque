//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import DAO.proprietaireDAO;
import model.proprietaire;

void main(){

   proprietaireDAO pDAO = new proprietaireDAO();

    proprietaire p = pDAO.rechercheproprietair(10);
    if (p !=null){
        pDAO.supprimer(p);
    }


   // p.setAdresse("Dakar");
    //    pDAO.modifier(p);


    //proprietaire p = new proprietaire(1 ,"Faye", "khady", "Touba");
    //pDAO.ajouter(p);
   // proprietaire p = pDAO.rechercheproprietair(8);
    //
    //        if (p !=null){
    //        System.out.println(p);
    //    }

    //    ArrayList<proprietaire> properties = pDAO.getProprietairs();
    //    for (proprietaire p : properties){
    //        System.out.println(p);
    //    }
}
