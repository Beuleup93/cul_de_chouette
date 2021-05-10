package uppa.m1bigdata.devweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CulDeChouetteEntityManager {

	private static CulDeChouetteEntityManager instance;
	private static final String PERSISTENCE_UNIT_NAME="default";
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private CulDeChouetteEntityManager() {
		System.out.println("racine init");
		emf= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em=emf.createEntityManager();
		System.out.println("racine finish");
	}

	public static synchronized CulDeChouetteEntityManager getInstance() {
		if (instance==null) {
			instance=new CulDeChouetteEntityManager();
		}
		return instance;
	}


	public EntityManager getEntityManager() {
		return em;
	}
	
}
