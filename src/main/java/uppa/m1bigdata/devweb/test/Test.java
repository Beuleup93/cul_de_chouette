/***package uppa.m1bigdata.devweb.test;

import uppa.m1bigdata.devweb.dao.DAOException;

public class Test {

	 public static void main(String[] args) throws DAOException {

	      JoueurDaoImpl joueurdao=new JoueurDaoImpl();
	      Joueur joueur=new Joueur("Zeynab", "zey", "zey", 28, "F", "Paris");
	      joueurdao.create(joueur);
	      joueur=joueurdao.find("zey");
	      System.out.println(joueur.getNomJoueur());
	      //joueurdao.delete(joueur);
	      //joueur.setSexe("H");
	      //joueurdao.update(joueur);
	      List<Joueur> listejoueur = joueurdao.getAll();
	      for (Joueur j:listejoueur) {
	          System.out.println("liste des joueurs = "+j.getNomJoueur());

	    }

}
 }*/