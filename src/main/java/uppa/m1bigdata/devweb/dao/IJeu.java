package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.Combinaison;
import uppa.m1bigdata.devweb.pojo.Jouer;
import uppa.m1bigdata.devweb.pojo.Joueur;
import uppa.m1bigdata.devweb.pojo.Partie;

public interface IJeu {

    public Partie find(String desc);

    public Jouer saveJouer(Jouer joueur);

    public Combinaison findComb(String nom);

    public Combinaison saveComb(Combinaison combinaison);

    public Partie savePartie(Partie partie);

    public void insertWithQuery(Jouer jouer);

}