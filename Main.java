//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import DAO.ProprietaireDAO;
import model.proprietaire;

void main(){
    ProprietaireDAO pDAO = new ProprietaireDAO();

    proprietaire p = pDAO.rechercheproprietair(2);
    if (p !=null)pDAO.supprimer(p);

    //proprietaire p = pDAO.rechercheproprietair(1);
    //    p.setAdresse("Dakar");
    //    pDAO.Modifier(p);


    //proprietaire p = new proprietaire("Ba","Diary","Mboro");
    //    pDAO.ajouter(p);

   // proprietaire p = pDAO.rechercheproprietairs(1);
    //    if (p != null) {
    //        System.out.println(p);
    //
    //    }
    //ArrayList<proprietaire> proprietaires = pDAO.getProprietairs();
    //    for (proprietaire p : proprietaires){
    //        System.out.println(p);
    //    }
}
