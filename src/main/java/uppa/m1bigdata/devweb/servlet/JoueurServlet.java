package uppa.m1bigdata.devweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uppa.m1bigdata.devweb.dao.DAO;
import uppa.m1bigdata.devweb.dao.DAOException;
import uppa.m1bigdata.devweb.dao.JoueurDaoImpl;
import uppa.m1bigdata.devweb.pojo.Joueur;


/**
 * Servlet implementation class JoueurServlet
 */
@WebServlet(name = "JoueurServlet", urlPatterns = {"/"})
public class JoueurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAO<Joueur> joueurDaoImpl;

	public JoueurServlet() {
		System.out.println("_______OKKKKKK1_____");
		joueurDaoImpl = new JoueurDaoImpl();
		System.out.println("_______OKKKKKK1 finish_____");
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException, DAOException {
					System.out.println("_______OKKKKKK2_____");
			        response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();
			        String action = request.getParameter("action");
			        if (action.equals("afficher")){
			        	      System.out.println("_______OKKKKKK Afficher_____"+action);
			                  request.setAttribute("joueurs", joueurDaoImpl.getAll());            
			                  // forwarde la requête à la page JSP           
			                  request.getRequestDispatcher("/WEB-INF/jsp/listeJoueur.jsp")
			                          .forward(request,response);
			            }
			        else{
			        try {

			            // entête du document + affichage du rectangle courant
						System.out.println("_______Else_____"+action);
			            out.println("<html>");
			            out.println("<head>");
			            out.println("<title>Test de Servlet : joueur</title>");
			            out.println("</head>");
			            out.println("<body>");
			            out.println("<h1>Servlet Joueur</h1>");
			            String nomJoueur = request.getParameter("nomJoueur");
			            String pseudo = request.getParameter("pseudo");
			            String pwd = request.getParameter("pwd");
			            int age=0;
			            if(request.getParameter("age")!="")
			                age = Integer.parseInt(request.getParameter("age"));
			            String sexe = request.getParameter("sexe");
			            String ville = request.getParameter("ville");

			            // création d'un rectangle
			            if (action.equals("creer")) {
			                Joueur joueur=new Joueur(nomJoueur, pseudo, pwd, age, sexe, ville);
			                joueurDaoImpl.create(joueur);
			                out.println("<p>Le joueur : "+joueur.getNomJoueur() + " a �t� bien cr��</p>");
			            }

			            // décalage de rectangle
			            if (action.equals("modifier")) {
			               Joueur joueur=joueurDaoImpl.find(Integer.parseInt(pseudo));
			               if (pwd!="")
			                   joueur.setPwd(pwd);
			               if(request.getParameter("age")!=""){
			                   age = Integer.parseInt(request.getParameter("age"));
			                   joueur.setAge(age);
			               }
			               if(sexe!="")
			                   joueur.setSexe(sexe);
			               joueurDaoImpl.update(joueur);
			               out.println("<p>Le joueur  : "+joueur.getNomJoueur() + " a �t� modifi� </p>");
			                 out.println("</html>");
			            }

			            // calcul de surface du rectangle courant
			            if (action.equals("supprimer")) {
			                
			                   Joueur joueur=joueurDaoImpl.find(Integer.parseInt(pseudo));
			                   joueurDaoImpl.delete(joueur);
			                   out.println("<p>Le joueur : "+joueur.getNomJoueur()+" a �t� supprim�</p>");
			                   out.println("</html>");

			            }
			            
			            
			            

			            }

			            // décalage de rectangle

			        catch (Exception e)
			        {
			             out.println("<p><b>Erreur !!</b><br />");
			             out.println(e.toString()+"</p>");
			        }
			      
			        // fin du document : lien pour retour en arrière
			        out.println("<p><a href=\""+request.getContextPath()+"\">Retour</a></p>");
			        out.println("</body>");
			        out.println("</html>");
			        out.close();
			        }
			    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("doGet");
			processRequest(request, response);
		} catch (DAOException ex) {
			Logger.getLogger(JoueurServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("_______doPost________");
			processRequest(request, response);
		} catch (DAOException ex) {
			Logger.getLogger(JoueurServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
