package rzk.beans.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import countryInfo.CountryInfoService;
import countryInfo.CountryInfoServiceSoapType;
import model.Conference;

/**
 * Message-Driven Bean implementation class for: ConferenceMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/conference"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/conference")
public class ConferenceMDB implements MessageListener {

	@WebServiceRef(CountryInfoService.class)
	CountryInfoServiceSoapType countryInfo;

	@PersistenceContext
	EntityManager em;
	
	@Inject
	JMSContext context;
	
	@Resource(mappedName="java:/jms/topic/confInfo")
	private javax.jms.Destination destinationTopic;
	
	public ConferenceMDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		ObjectMessage om = (ObjectMessage) message;
		try {
			Conference conf = (Conference) om.getObject();
			String code = countryInfo.countryISOCode(conf.getCountry());
			String currency = countryInfo.currencyName(countryInfo.fullCountryInfo(code).getSCurrencyISOCode());
			String dial = countryInfo.countryIntPhoneCode(code);

			conf.setCountryCode(code);
			conf.setCurrency(currency);
			conf.setDialingCode(dial);
			em.persist(conf);
			
			ObjectMessage omSend = context.createObjectMessage();
			omSend.setObject(conf);
			JMSProducer prod = context.createProducer();
			prod.send(destinationTopic, omSend);

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}