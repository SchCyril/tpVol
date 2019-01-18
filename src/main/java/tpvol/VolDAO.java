package tpvol;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tpvol.DatabaseHelper;
import tpvol.Vol;

public class VolDAO {
	public void create(Vol entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);

	}

	public void update(Vol entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void delete(Vol entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(em.find(Vol.class, entity.getId()));
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void planeSearch() {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("from User u where u.id =:id", Vol.class);
		query.setParameter("id", "????");
		Vol vol = query.getSingleResult();

	}
	
	public static List<Vol> planeByCity(Vol villeArrive, Vol villeDepart) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("from Vol v where v.villeDepart =:villeDepart and v.villeArrive=:villeArrive" , Vol.class);
		List<Vol> vols = query.getResultList();

		return vols;
	}

}
