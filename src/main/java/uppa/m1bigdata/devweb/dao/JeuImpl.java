package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.*;

import javax.persistence.EntityManager;
import java.util.HashSet;
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
    public void jouer(Joueur joueur) {

        int point=0;
        int roll1 = 0;
        int roll2 = 0;
        int roll3 = 0;
        try {
            de1 = deDaoImpl.find(1);
            de2 = deDaoImpl.find(2);
            de3 = deDaoImpl.find(3);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        roll1 = roll1+de1.roll(1,6);
        roll2 = roll2+de2.roll(1,6);
        roll3 = roll3+de3.roll(1,6);

        if(roll1+roll2==roll3) {

            this.combinaison=new Combinaison("velute","combinsaison sans interaction",de1 ,de2 ,de3);
            point=roll3^2;
            this.jouer=new Jouer(point, combinaison, joueur, partie);

        }else if (roll1==roll2) {
            this.combinaison=new Combinaison("chouette","combinsaison sans interaction",de1, de2 ,de3);
            point=roll1^2;
            this.jouer=new Jouer(point, combinaison, joueur, partie);

        }else if (roll1==roll2 && roll1==roll3 && roll2==roll3) {
            this.combinaison=new Combinaison("cul de chouette","combinsaison sans interaction",de1 ,de2 ,de3);
            if(roll3==1) {
                point=50;
                this.jouer=new Jouer(point, combinaison, joueur, partie);

            }else if (roll3==2) {
                point=60;
                this.jouer=new Jouer(point, combinaison, joueur, partie);

            }else if (roll3==3) {
                point=70;
                this.jouer=new Jouer(point, combinaison, joueur, partie);

            }else if (roll3==4) {
                point=80;
                this.jouer=new Jouer(point, combinaison, joueur, partie);

            }else if (roll3==5) {
                point=90;
                this.jouer=new Jouer(point, combinaison, joueur, partie);

            } else {
                point=100;
                jouer=new Jouer(point, combinaison, joueur, partie);
            }
        }else if (roll1+1==roll2&&roll2+1==roll3) {
            combinaison=new Combinaison("suite","combinsaison avec interaction",de1 ,de2 ,de3);
        }else if (roll1==roll2&&roll1+roll2==roll3) {
            combinaison=new Combinaison("chouette velute","combinsaison avec interaction",de1 ,de2 ,de3);
        }

        try {
            combinaisonDaoImpl.create(combinaison);
            if(jouer != null)
                jouerDaoImpl.create(jouer);

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Combinaison saveComb(Combinaison combinaison) {
        em.getTransaction().begin();
        Combinaison comb = em.merge(combinaison);
        em.getTransaction().commit();
        return comb;
    }

    @Override
    public Partie savePartie(Partie partie) {
        em.getTransaction().begin();
        Partie par = em.merge(partie);
        em.getTransaction().commit();
        return par;
    }

    @Override
    public Jouer saveJouer(Jouer jouer) {
        em.getTransaction().begin();
        Jouer j = em.merge(jouer);
        em.getTransaction().commit();
        return j;
    }
}
