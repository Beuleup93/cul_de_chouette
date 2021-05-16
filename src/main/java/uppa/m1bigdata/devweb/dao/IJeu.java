package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.Combinaison;
import uppa.m1bigdata.devweb.pojo.Jouer;
import uppa.m1bigdata.devweb.pojo.Joueur;
import uppa.m1bigdata.devweb.pojo.Partie;

public interface IJeu {
    public void jouer(Joueur joueurs);

    public Jouer saveJouer(Jouer joueur);

    public Combinaison saveComb(Combinaison combinaison);

    public Partie savePartie(Partie partie);
}