package uppa.m1bigdata.devweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import uppa.m1bigdata.devweb.pojo.Joueur;

public class JoueurDaoImpl implements DAO<Joueur> {
	
	
private EntityManager em;


	public JoueurDaoImpl() {
		em = CulDeChouetteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public Joueur find(int id) throws DAOException {
		Joueur joueur=em.find(Joueur.class, id);
		return joueur;
	}

	@Override
	public void create(Joueur joueur) throws DAOException {
		em.getTransaction().begin();
		em.persist(joueur);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(Joueur joueur) throws DAOException {
		em.getTransaction().begin();
		em.merge(joueur);
		em.getTransaction().commit();
		
	}

	@Override
	public void delete(Joueur joueur) throws DAOException {
		em.getTransaction().begin();
		em.remove(joueur);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Joueur> getAll() throws DAOException {
		List<Joueur> joueurs=em.createQuery("select j from Joueur j").getResultList();
		return joueurs;
	}


}
