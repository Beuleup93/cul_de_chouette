package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.Joueur;

public interface IConnexion {
    public Joueur login(String pseudo, String pwd) ;
    public Joueur find(String pseudo);
}
