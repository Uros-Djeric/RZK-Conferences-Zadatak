package rzk.beans.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import model.Conference;

/**
 * Message-Driven Bean implementation class for: ConferenceMDBFrance
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/topic/confInfo"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "java:/jms/topic/confInfo")
public class ConferenceMDBFrance implements MessageListener {

    /**
     * Default constructor. 
     */
    public ConferenceMDBFrance() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	ObjectMessage om = (ObjectMessage) message;

		try {
			Conference conf = (Conference) om.getObject();

			if (conf.getCountryCode().equals("FRA"))
				System.out.println("\nBonjour la France");

		} catch (JMSException e) {

			e.printStackTrace();
		}
        
    }

}
