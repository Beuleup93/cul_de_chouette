package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.Joueur;

import java.util.List;

public interface IJoueur {

    public Joueur find(int id);

    public  void create(Joueur data) ;

    public  void update(Joueur data);

    public  void delete(Joueur data);

    public List<Joueur> getAll();
}
