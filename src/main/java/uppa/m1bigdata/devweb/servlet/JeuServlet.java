package uppa.m1bigdata.devweb.servlet;

import uppa.m1bigdata.devweb.dao.*;
import uppa.m1bigdata.devweb.pojo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class JeuServlet extends HttpServlet {
    private IJeu jeu;
    private De de1,de2, de3;
    private int roll1,roll2,roll3;
    private DAO<De> deDaoImpl;
    private DAO<Combinaison> combDaoImpl;
    private DAO<Partie> partieDaoImpl;
    private DAO<Jouer> jouerDaoImpl;
    private Combinaison combinaison;
    private Partie partie; // à recuperer depuis la sessoion
    private Joueur joueur; // représente le joueurs connecté qui a lancé le jeu
    private List<Joueur> joueurs; // représente les adversaires
    private Jouer jouer;
    private int point; // nombre de point cumulé du joueur ayant joué

    public JeuServlet() {
        this.jeu = new JeuImpl();
        deDaoImpl = new DesDaoImpl();
        combDaoImpl = new CombinaisonDaoImpl();
        partieDaoImpl = new PartieDaoImpl();
        jouerDaoImpl = new JouerDaoImpl();
    }

    public int roll(int borneInf, int borneSup){
        Random random = new Random();
        return borneInf+random.nextInt(borneSup-borneInf);
    }

    public int genererId(){
        /** cette fonction genere un identifiant non présent dans la table Jouer*/
        int id = 0;
        boolean doing = true;
        do{
            id = roll(1,10000);
            try {
                if(jouerDaoImpl.find(id)==null){
                    doing = false;
                }
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }while(doing);
        return id;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String addPartie = req.getParameter("partie");

        if (action.equals("demarrerPartie")){
            HttpSession session = req.getSession();
            Set<Joueur> tmp = (Set<Joueur>) session.getAttribute("archiveListeJoueur");
            Set<Joueur>  joueurs = new HashSet<>();
            /**Generation d'un nombre pour l'Id Jouer, à stocker en session*/
            int nbId = genererId();
            session.setAttribute("idJouerNewPartie",nbId);
            session.setAttribute("idJouerCurrentPartie",0);
            for (Joueur j: tmp){
                j.setAge(0);
                joueurs.add(j);
            }
            req.setAttribute("joueurs", joueurs);
            req.getRequestDispatcher("/WEB-INF/jsp/espaceJeu.jsp").forward(req,resp);

        }
        else if(action.equals("lancer")){
            HttpSession session = req.getSession();
            Set<Joueur> joueurs = (Set<Joueur>) session.getAttribute("archiveListeJoueur");
            Set<Joueur> joueursScores = new HashSet<>();

            for (Joueur j:joueurs) {
                joueur = j;
                /** resultats des dés */
                roll1 = roll(1,6);
                roll2 = roll(1,6);
                roll3 = roll(1,6);
                System.out.println("roll1: "+roll1+" roll2: "+roll2+" roll3: "+roll3);
                /**Teste sur les combinaison de resultats*/
                if(roll1+roll2==roll3) {
                    req.setAttribute("message","Combinaison sans interaction: VELUTE");
                    point=roll3*roll3;
                    if(jeu.findComb("Velute")!=null){
                        combinaison = jeu.findComb("Velute");
                    }else{
                        this.combinaison=new Combinaison("velute","combinsaison sans interaction",roll1,roll2,roll3);
                    }

                } else if (roll1==roll2) {
                    req.setAttribute("message","Combinaison sans interaction: CHOUETTE");
                    point=roll1*roll1;
                    if(jeu.findComb("Chouette")!=null){
                        combinaison = jeu.findComb("Chouette");
                    }else{
                        this.combinaison=new Combinaison("Chouette","combinsaison sans interaction",roll1,roll2,roll3);
                    }

                }else if (roll1==roll2 && roll1==roll3 && roll2==roll3) {
                    if(jeu.findComb("cul de chouette")!=null){
                        combinaison = jeu.findComb("cul de chouette");
                    }else{
                        this.combinaison=new Combinaison("cul de chouette","combinsaison sans interaction",roll1,roll2,roll3);
                    }
                    if(roll3==1) {
                        point=50;

                    }else if (roll3==2) {
                        point=60;

                    }else if (roll3==3) {
                        point=70;

                    }else if (roll3==4) {
                        point=80;

                    }else if (roll3==5) {
                        point=90;

                    } else {
                        point=100;
                    }
                }else if (roll1+1==roll2&&roll2+1==roll3) {
                    req.setAttribute("message","Grelotte ca picote");
                    point = 0;
                    if(jeu.findComb("suite")!=null){
                        combinaison = jeu.findComb("suite");
                    }else{
                        combinaison=new Combinaison("suite","combinsaison avec interaction",roll1,roll2,roll3);
                    }

                }else if (roll1==roll2&&roll1+roll2==roll3) {
                    req.setAttribute("message","Pas mou le cailloux");
                    point = 0;
                    if(jeu.findComb("chouette velute")!=null){
                        combinaison = jeu.findComb("chouette velute");
                    }else{
                        combinaison=new Combinaison("chouette velute","combinsaison avec interaction",roll1,roll2,roll3);
                    }

                }else{
                    req.setAttribute("message","Mauvais Tir: Pas de points gagné");
                    point = 0;
                    if(jeu.findComb("Mauvais Tir")!=null){
                        combinaison = jeu.findComb("Mauvais Tir");
                    }else{
                        combinaison=new Combinaison("Mauvais Tir","Pas de combinaison",roll1,roll2,roll3);
                    }
                }

                /** recupére session depuis la session*/

                //joueur = (Joueur) session.getAttribute("archiveJoueur");
                int idJouerNewPartie = (int) session.getAttribute("idJouerNewPartie");
                int idJouerCurrentPartie = (int) session.getAttribute("idJouerCurrentPartie");
                String desc = (String) session.getAttribute("description");
                if(desc!=null){
                    if(jeu.find(desc) != null){
                        partie = jeu.find(desc);
                    }
                    else{
                        partie = new Partie(new Date(),desc);
                    }
                }

                System.out.println("Partie: "+partie.getDescription());
                System.out.println("Combinaison: "+combinaison.getNomCombinaison()+" ,IDComb: "+combinaison.getIdCombinaison());
                System.out.println("Joueur: "+joueur.getNomJoueur());

                /**Sauvegarde dans la base de données*/
                partie = jeu.savePartie(partie);
                /**Verfions si le IdCombinaison existe ou pas si non on le crée*/
                if(combinaison.getIdCombinaison()==0){
                    combinaison = jeu.saveComb(combinaison);
                }

                jouer = new Jouer(point);
                if(idJouerCurrentPartie == 0) {
                    System.out.println("New Partie");
                    jeu.insertWithQuery(new Jouer(idJouerNewPartie, point, combinaison, joueur, partie));
                    session.setAttribute("idJouerCurrentPartie",idJouerNewPartie);
                }else{
                    try {
                        System.out.println("Current Partie");
                        Jouer precedement = jouerDaoImpl.find(idJouerCurrentPartie);
                        point = point+precedement.getPoint();
                        idJouerCurrentPartie = genererId();
                        jeu.insertWithQuery(new Jouer(idJouerCurrentPartie, point, combinaison, joueur, partie));
                        session.setAttribute("idJouerCurrentPartie",idJouerCurrentPartie);
                    } catch (DAOException e) {
                        e.printStackTrace();
                    }
                }

                j.setAge(point+roll(1,50));
                joueursScores.add(joueur);
            }

            joueurs = joueursScores;
            String notif = "";
            for(Joueur j: joueurs){
                if(j.getAge() == 343){
                    notif = "Game Over";
                }
            }
            req.setAttribute("joueurs", joueurs);
            req.setAttribute("notif", notif);
            req.getRequestDispatcher("/WEB-INF/jsp/espaceJeu.jsp").forward(req,resp);
        }

    }
}
