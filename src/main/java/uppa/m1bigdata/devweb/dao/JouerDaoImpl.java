package uppa.m1bigdata.devweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import uppa.m1bigdata.devweb.pojo.Jouer;

public class JouerDaoImpl implements DAO<Jouer>{

	private EntityManager em;
	

	public JouerDaoImpl() {
		em = CulDeChouetteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public Jouer find(int id) throws DAOException {
		Jouer jouer=em.find(Jouer.class, id);
		return jouer;
	}

	@Override
	public void create(Jouer data) throws DAOException {
		em.getTransaction().begin();
		em.persist(data);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Jouer data) throws DAOException {
		em.getTransaction().begin();
		em.merge(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Jouer data) throws DAOException {
		em.getTransaction().begin();
		em.remove(data);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jouer> getAll() throws DAOException {
		List<Jouer> jouers=em.createQuery("select j from Jouer d").getResultList();
		return jouers;
	}
}
