package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.Joueur;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConnexionImpl implements IConnexion{

    private EntityManager em;


    public ConnexionImpl() {
        em = CulDeChouetteEntityManager.getInstance().getEntityManager();
    }

    @Override
    public Joueur login(String pseudo, String pwd){
        String sql = "SELECT j FROM Joueur j WHERE j.pseudo = :pseudo  and j.pwd=:pwd";
        TypedQuery<Joueur> query = em.createQuery(sql,Joueur.class);
        query.setParameter("pseudo", pseudo);
        query.setParameter("pwd", pwd);
        try {
            Joueur joueur=query.getSingleResult();
            return joueur;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Joueur find(String pseudo) {
        String sql = "SELECT j FROM Joueur j WHERE j.pseudo = :pseudo ";
        Query query = em.createQuery(sql);
        query.setParameter("pseudo", pseudo);
        List<Joueur> joueur=query.getResultList();
        if(joueur.size()!=0){
            return joueur.get(0);
        }else{
            return null;
        }
    }


}
