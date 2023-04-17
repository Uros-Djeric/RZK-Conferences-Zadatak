package rzk.webservices;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Conference;

/**
 * Session Bean implementation class FutureConferencesWS
 */
@Stateless
@LocalBean
@WebService
public class FutureConferencesWS implements FutureConferencesWSRemote {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public FutureConferencesWS() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@WebMethod
	public List<Conference> getUpcomingConferences(String field) {

		return em.createQuery("Select c FROM Conference c where c.field =:field AND c.dateFrom > date"
				,Conference.class)
				.setParameter("field", field)
				.setParameter("date", new Date())
				.getResultList();
	}

}
