package uppa.m1bigdata.devweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import uppa.m1bigdata.devweb.pojo.Partie;

public class PartieDaoImpl implements DAO<Partie>{

	private EntityManager em;
	
	
	public PartieDaoImpl() {
		em = CulDeChouetteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public Partie find(int id) throws DAOException {
		Partie partie=em.find(Partie.class, id);
		return partie;
	}

	@Override
	public void create(Partie data) throws DAOException {
		em.getTransaction().begin();
		em.persist(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void update(Partie data) throws DAOException {
		em.getTransaction().begin();
		em.merge(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Partie data) throws DAOException {
		em.getTransaction().begin();
		em.remove(data);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partie> getAll() throws DAOException {
		List<Partie> parties=em.createQuery("select p from Partie p").getResultList();
		return parties;
	}

}
