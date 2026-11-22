//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import DAO.ProprietaireDAO;
import model.proprietaire;

void main(){
    ProprietaireDAO pDAO = new ProprietaireDAO();
    ArrayList<proprietaire> proprietaires = pDAO.getProprietairs();
    for (proprietaire p : proprietaires){
        System.out.println(p);
    }
}
