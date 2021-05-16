package uppa.m1bigdata.devweb.servlet;

import uppa.m1bigdata.devweb.dao.IJeu;
import uppa.m1bigdata.devweb.dao.JeuImpl;
import uppa.m1bigdata.devweb.pojo.Joueur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class JeuServlet extends HttpServlet {
    private IJeu jeu;

    public JeuServlet() {
        this.jeu = new JeuImpl();
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
            Set<Joueur> joueurs = (Set<Joueur>) session.getAttribute("archiveListeJoueur");
            req.setAttribute("joueurs", joueurs);
            req.getRequestDispatcher("/WEB-INF/jsp/espaceJeu.jsp").forward(req,resp);
        }else if(action.equals("lancer")){
            HttpSession session = req.getSession();
            jeu.jouer((Joueur)session.getAttribute("archiveJoueur"));
        }

    }
}
