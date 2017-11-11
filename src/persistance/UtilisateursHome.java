package persistance;

// Generated 7 avr. 2013 21:24:27 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Utilisateurs.
 * @see persistance.Utilisateurs
 * @author Hibernate Tools
 */
public class UtilisateursHome {

	private static final Log log = LogFactory.getLog(UtilisateursHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Utilisateurs transientInstance) {
		log.debug("persisting Utilisateurs instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Utilisateurs instance) {
		log.debug("attaching dirty Utilisateurs instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Utilisateurs instance) {
		log.debug("attaching clean Utilisateurs instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Utilisateurs persistentInstance) {
		log.debug("deleting Utilisateurs instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Utilisateurs merge(Utilisateurs detachedInstance) {
		log.debug("merging Utilisateurs instance");
		try {
			Utilisateurs result = (Utilisateurs) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Utilisateurs findById(java.lang.String id) {
		log.debug("getting Utilisateurs instance with id: " + id);
		try {
			Utilisateurs instance = (Utilisateurs) sessionFactory
					.getCurrentSession().get("persistance.Utilisateurs", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Utilisateurs> findByExample(Utilisateurs instance) {
		log.debug("finding Utilisateurs instance by example");
		try {
			List<Utilisateurs> results = (List<Utilisateurs>) sessionFactory
					.getCurrentSession()
					.createCriteria("persistance.Utilisateurs")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
