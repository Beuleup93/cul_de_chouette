package uppa.m1bigdata.devweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import uppa.m1bigdata.devweb.pojo.De;

public class DesDaoImpl  implements DAO<De> {

	private EntityManager em;
	
	
	public DesDaoImpl() {
		em = CulDeChouetteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public De find(int id) throws DAOException {
		De de=em.find(De.class, id);
		return de;
	}

	@Override
	public void create(De data) throws DAOException {
		em.getTransaction().begin();
		em.persist(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void update(De data) throws DAOException {
		em.getTransaction().begin();
		em.merge(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(De data) throws DAOException {
		em.getTransaction().begin();
		em.remove(data);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<De> getAll() throws DAOException {
		List<De> des=em.createQuery("select d from Joueur d").getResultList();
		return des;
	}



}
