package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.*;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class JeuImpl implements IJeu{

    private DAO<Jouer> jouerDaoImpl;
    private DAO<Combinaison> combinaisonDaoImpl;
    private DAO<Partie> partieDaoImpl;
    private Partie partie;
    private Combinaison combinaison;
    private Jouer jouer;

    public JeuImpl() {
        this.jouerDaoImpl = new JouerDaoImpl();
        this.combinaisonDaoImpl = new CombinaisonDaoImpl();
        this.partieDaoImpl = new PartieDaoImpl();
        this.partie = new Partie("Partie1");;
        this.jouer = null;
        this.combinaison = null;
    }

    @Override
    public void jouer(Joueur joueur) {

        int point=0;
        De de1=new De("de1");
        De de2=new De("de2");
        De de3=new De("de3");
        int roll1=de1.roll(1,6);
        int roll2=de2.roll(1,6);
        int roll3=de3.roll(1,6);

        if(roll1+roll2==roll3) {
            combinaison=new Combinaison("velute","combinsaison sans interaction",de1 ,de2 ,de3);
            point=roll3^2;
            jouer=new Jouer(point, combinaison, joueur, partie);

        }else if (roll1==roll2) {
            combinaison=new Combinaison("chouette","combinsaison sans interaction",de1, de2 ,de3);
            point=roll1^2;
            jouer=new Jouer(point, combinaison, joueur, partie);

        }else if (roll1==roll2 && roll1==roll3 && roll2==roll3) {
            combinaison=new Combinaison("cul de chouette","combinsaison sans interaction",de1 ,de2 ,de3);
            if(roll3==1) {
                point=50;
                jouer=new Jouer(point, combinaison, joueur, partie);

            }else if (roll3==2) {
                point=60;
                jouer=new Jouer(point, combinaison, joueur, partie);

            }else if (roll3==3) {
                point=70;
                jouer=new Jouer(point, combinaison, joueur, partie);

            }else if (roll3==4) {
                point=80;
                jouer=new Jouer(point, combinaison, joueur, partie);

            }else if (roll3==5) {
                point=90;
                jouer=new Jouer(point, combinaison, joueur, partie);

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
            partieDaoImpl.create(partie);
            combinaisonDaoImpl.create(combinaison);
            if(jouer != null)
                jouerDaoImpl.create(jouer);

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
