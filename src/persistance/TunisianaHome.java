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
 * Home object for domain model class Tunisiana.
 * @see persistance.Tunisiana
 * @author Hibernate Tools
 */
public class TunisianaHome {

	private static final Log log = LogFactory.getLog(TunisianaHome.class);

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

	public void persist(Tunisiana transientInstance) {
		log.debug("persisting Tunisiana instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tunisiana instance) {
		log.debug("attaching dirty Tunisiana instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tunisiana instance) {
		log.debug("attaching clean Tunisiana instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tunisiana persistentInstance) {
		log.debug("deleting Tunisiana instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tunisiana merge(Tunisiana detachedInstance) {
		log.debug("merging Tunisiana instance");
		try {
			Tunisiana result = (Tunisiana) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tunisiana findById(java.lang.Integer id) {
		log.debug("getting Tunisiana instance with id: " + id);
		try {
			Tunisiana instance = (Tunisiana) sessionFactory.getCurrentSession()
					.get("persistance.Tunisiana", id);
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

	public List<Tunisiana> findByExample(Tunisiana instance) {
		log.debug("finding Tunisiana instance by example");
		try {
			List<Tunisiana> results = (List<Tunisiana>) sessionFactory
					.getCurrentSession()
					.createCriteria("persistance.Tunisiana")
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
