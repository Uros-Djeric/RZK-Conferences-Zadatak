package rzk.beans.session;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Conference;

/**
 * Session Bean implementation class ConfInfoSB
 */
@Stateless
@LocalBean
public class ConfInfoSB implements ConfInfoSBRemote {

	@Resource(mappedName = "java:/jms/queue/conference")
	private Destination destinationQueue;

	@Inject
	JMSContext ctx;

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ConfInfoSB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addConference(Conference conference) {
		ObjectMessage om = ctx.createObjectMessage();
		try {
			om.setObject(conference);
			JMSProducer prod = ctx.createProducer();
			prod.send(destinationQueue, om);
			return true;
		} catch (JMSException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Conference> getPredavacsConference(String ime, String prezime) {

		return em
				.createQuery("Select c FROM Conference c inner join c.conferencePredavacs cp where cp.ime like: ime"
						+ "AND cp.prezime like :prezime", Conference.class)
				.setParameter("ime", prezime)
				.setParameter("prezime", prezime)
				.getResultList();
	}

}
