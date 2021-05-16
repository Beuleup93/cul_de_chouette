package uppa.m1bigdata.devweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uppa.m1bigdata.devweb.dao.*;
import uppa.m1bigdata.devweb.pojo.Joueur;


/**
 * Servlet implementation class JoueurServlet
 */
@WebServlet(name = "JoueurServlet", urlPatterns = {"/"})
public class JoueurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAO<Joueur> joueurDaoImpl;
	private IConnexion connex;
	private Set<Joueur> joueursChoisis;

	public JoueurServlet() {
		joueurDaoImpl = new JoueurDaoImpl();
		connex = new ConnexionImpl();
		joueursChoisis = new HashSet<>();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/** Action */
		String action = request.getParameter("action");

		try {

			if (action.equals("listeJoueur")){
				HttpSession session = request.getSession();
				session.setAttribute("allJoueur",joueurDaoImpl.getAll());

				request.setAttribute("joueurs", joueurDaoImpl.getAll());
				request.getRequestDispatcher("/WEB-INF/jsp/listeJoueur.jsp").forward(request,response);

			} else if(action.equals("connexion")){
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request,response);

			}else if(action.equals("inscription")){
				request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request,response);

			}else if(action.equals("runPartie")){
				request.setAttribute("joueurs", joueurDaoImpl.getAll());

				/**Préemplir liste des joueurs de la partie avec l'utilisateur connecté*/
				HttpSession session = request.getSession();
				Joueur joueur = (Joueur) session.getAttribute("archiveJoueur");
				joueursChoisis.add(joueur);
				request.setAttribute("listeJoueurs",  joueursChoisis);

				request.getRequestDispatcher("/WEB-INF/jsp/demarrePartie.jsp").forward(request,response);

			}else if(action.equals("choose")){
				String pseudo = request.getParameter("pseudo");
				Joueur joueur = connex.find(pseudo);

				if(joueursChoisis.size() < 6) {
					joueursChoisis.add(joueur);
					HttpSession session = request.getSession();
					session.setAttribute("archiveListeJoueur", joueursChoisis);

					request.setAttribute("listeJoueurs",  joueursChoisis);
					request.setAttribute("joueurs", joueurDaoImpl.getAll());
					request.getRequestDispatcher("/WEB-INF/jsp/demarrePartie.jsp").forward(request,response);
				}else{
					request.setAttribute("limite", "Vous avez ateint la limite des joueurs à ajouter pour une partie");
					request.setAttribute("listeJoueurs",  joueursChoisis);
					request.setAttribute("joueurs", joueurDaoImpl.getAll());
					request.getRequestDispatcher("/WEB-INF/jsp/demarrePartie.jsp").forward(request,response);
				}
			}else if(action.equals("viewJoueur")){
				String idJoueur = request.getParameter("idJoueur");
				Joueur joueur = joueurDaoImpl.find(Integer.parseInt(idJoueur));
				request.setAttribute("joueur",joueur);
				request.getRequestDispatcher("/WEB-INF/jsp/confirmerIdentifiant.jsp").forward(request,response);
			}
			else if(action.equals("modif")){
				request.getRequestDispatcher("/WEB-INF/jsp/espaceJeu.jsp").forward(request,response);
			}else if(action.equals("reset")){

				HttpSession session = request.getSession();
				joueursChoisis = new HashSet<>();
				//Joueur joueur = (Joueur) session.getAttribute("archiveJoueur");
				//joueursChoisis.add(joueur);

				request.setAttribute("joueurs", joueurDaoImpl.getAll());
				request.getRequestDispatcher("/WEB-INF/jsp/demarrePartie.jsp").forward(request,response);
			}else if(action.equals("accueil")){
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
