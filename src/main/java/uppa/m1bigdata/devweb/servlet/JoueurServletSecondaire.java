package uppa.m1bigdata.devweb.servlet;

import uppa.m1bigdata.devweb.dao.*;
import uppa.m1bigdata.devweb.pojo.Joueur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "JoueurServletSecondaire", urlPatterns = {"/JoueurServletSecondaire"})
public class JoueurServletSecondaire extends HttpServlet {

    private DAO<Joueur> joueurDaoImpl;
    private IConnexion connex;

    public JoueurServletSecondaire() {
        connex = new ConnexionImpl();
        joueurDaoImpl = new JoueurDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** Action */
        String add = request.getParameter("addJoueur");
        String partie = request.getParameter("Add");
        String connexion = request.getParameter("connexion");
        String confirmer = request.getParameter("confirmer");

        try {
                if(add!=null){
                    if(add.equals("Add")){
                        /** Sauvegarder Joueur*/
                        Joueur joueur = new Joueur(request.getParameter("name"),
                                request.getParameter("pseudo"),
                                request.getParameter("pwd"),
                                Integer.parseInt(request.getParameter("age")),
                                request.getParameter("flexRadioDefault"),
                                request.getParameter("ville"));

                        /** Vérifie si le pseudo n'est pas pris*/
                        Joueur j = connex.find(request.getParameter("pseudo"));
                        if(j != null){
                            request.setAttribute("error", "Erreur d'inscription! Ce pseudo existe déja");
                            request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request,response);
                        }else{
                            joueurDaoImpl.create(joueur);
                            request.setAttribute("success", "Inscription réussie");
                            request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request,response);
                        }
                    }
                }else if(partie != null){
                    if(partie.equals("addPartie")){
                        /** stocker la partie dans une session*/
                        String desc = request.getParameter("desc");
                        HttpSession session = request.getSession();
                        session.setAttribute("description",desc);
                        /** Rafraichir la liste */
                        request.setAttribute("joueurs",joueurDaoImpl.getAll());
                        request.getRequestDispatcher("/WEB-INF/jsp/demarrePartie.jsp").forward(request,response);
                    }
                }
                else if(connexion != null){
                    if(connexion.equals("connexion")){

                        /**Authentification*/
                        String password = request.getParameter("password");
                        String pseudonyme = request.getParameter("pseudonyme");

                        /**Action à faire*/
                        Joueur joueur = connex.login(pseudonyme,password);
                        if(joueur != null){

                            /** archive Joueur connecté */
                            HttpSession session = request.getSession();
                            session.setAttribute("archiveJoueur", joueur);
                            /** envoit joueur dans la vue */
                            request.setAttribute("joueur", joueur);
                            request.getRequestDispatcher("/WEB-INF/jsp/espaceJoueur.jsp").forward(request,response);

                        }else{
                            request.setAttribute("error", "Erreur de connexion!! Pseudo: "+pseudonyme+" ou password: "+password+" incorrect");
                            request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request,response);
                        }
                    }
                }else if(confirmer != null){

                    /**Confirmation identité*/
                    String password = request.getParameter("password");
                    String pseudonyme = request.getParameter("pseudonyme");

                    Joueur joueur = connex.login(pseudonyme,password);
                    if(joueur != null){
                        /** Archive joueur */
                        HttpSession session = request.getSession();
                        session.setAttribute("archiveJoueur", joueur);

                        request.setAttribute("joueur", joueur);
                        request.getRequestDispatcher("/WEB-INF/jsp/espaceJoueur.jsp").forward(request,response);
                    }else{
                        System.out.println("Erreur de confirmation compte \nPseudo: "+pseudonyme+" password: "+password);
                        request.setAttribute("error", "Erreur de confirmation compte!! "+pseudonyme+" le password: "+password+" est incorrect");
                        request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request,response);
                    }
                }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
