package uppa.m1bigdata.devweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import uppa.m1bigdata.devweb.pojo.Combinaison;

public class CombinaisonDaoImpl implements DAO<Combinaison>{

	private EntityManager em;
	
	public CombinaisonDaoImpl() {
		em = CulDeChouetteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public Combinaison find(int id) throws DAOException {
		Combinaison combinaison=em.find(Combinaison.class, id);
		return combinaison;
	}

	@Override
	public void create(Combinaison combinaison) throws DAOException {
		em.getTransaction().begin();
		em.persist(combinaison);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Combinaison combinaison) throws DAOException {
		em.getTransaction().begin();
		em.merge(combinaison);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Combinaison combinaison) throws DAOException {
		em.getTransaction().begin();
		em.remove(combinaison);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Combinaison> getAll() throws DAOException {
		List<Combinaison> combinaisons=em.createQuery("select c from Combinaison c").getResultList();
		return combinaisons;
	}

}
