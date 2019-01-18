package tpvol;

import javax.persistence.EntityManager;
import tpvol.DatabaseHelper;
import tpvol.Vol;

public class ReservationDAO {
	public void create(Reservation entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);

	}

	public void update(Reservation entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void delete(Reservation entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(em.find(Vol.class, entity.getId()));
		DatabaseHelper.commitTxAndClose(em);
	}
	
	


}
