package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JeuImpl implements IJeu{

    private DAO<Jouer> jouerDaoImpl;
    private DAO<Combinaison> combinaisonDaoImpl;
    private DAO<Partie> partieDaoImpl;
    private DAO<De> deDaoImpl;
    private Partie partie;
    private Combinaison combinaison;
    private Jouer jouer;
    private De de1;
    private De de2;
    private De de3;

    private EntityManager em;

    public JeuImpl() {
        this.em = CulDeChouetteEntityManager.getInstance().getEntityManager();
        this.jouerDaoImpl = new JouerDaoImpl();
        this.combinaisonDaoImpl = new CombinaisonDaoImpl();
        this.partieDaoImpl = new PartieDaoImpl();
        this.deDaoImpl = new DesDaoImpl();
        this.partie = null;
        this.jouer = null;
        this.combinaison = null;
    }

    @Override
    public Partie find(String desc) {
        String sql = "SELECT p FROM Partie p WHERE p.description = :desc ";
        Query query = em.createQuery(sql);
        query.setParameter("desc", desc);
        List<Partie> parties=query.getResultList();
        if(parties.size()!=0){
            return parties.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Combinaison saveComb(Combinaison combinaison) {
        em.getTransaction().begin();
        em.persist(combinaison);
        em.getTransaction().commit();
        return combinaison;
    }

    @Override
    public Partie savePartie(Partie partie) {
        em.getTransaction().begin();
        em.persist(partie);
        em.getTransaction().commit();
        return partie;
    }

    @Override
    public Jouer saveJouer(Jouer jouer) {
        em.getTransaction().begin();
        em.persist(jouer);
        em.getTransaction().commit();
        return jouer;
    }

    @Override
    public Combinaison findComb(String nom) {
        String sql = "SELECT c FROM Combinaison c WHERE c.nomCombinaison = :nom ";
        Query query = em.createQuery(sql);
        query.setParameter("nom", nom);
        List<Combinaison> combinaisons=query.getResultList();
        if(combinaisons.size()!=0){
            return combinaisons.get(0);
        }else{
            return null;
        }
    }

    @Transactional
    public void insertWithQuery(Jouer jouer) {
        System.out.println("IDJouer: "+jouer.getIdJouer());
        System.out.println("POINT: "+jouer.getPoint());
        System.out.println("IDPartie: "+jouer.getPartie().getIdPartie());
        System.out.println("IDCombin: "+jouer.getCombinaison().getIdCombinaison());
        System.out.println("IDJoueur: "+jouer.getJoueur().getIdJoueur());

        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO JOUER (IDJOUER, POINT, IDPARTIE, IDJOUEUR, IDCOMBINAISON) VALUES (?,?,?,?,?)")
                .setParameter(1, jouer.getIdJouer())
                .setParameter(2, jouer.getPoint())
                .setParameter(3, jouer.getPartie().getIdPartie())
                .setParameter(4, jouer.getJoueur().getIdJoueur())
                .setParameter(5, jouer.getCombinaison().getIdCombinaison())
                .executeUpdate();
        em.getTransaction().commit();
    }

}
