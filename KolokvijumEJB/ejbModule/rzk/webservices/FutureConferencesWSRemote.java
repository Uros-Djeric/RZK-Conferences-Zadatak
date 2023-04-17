package rzk.webservices;

import java.util.List;

import javax.ejb.Remote;

import model.Conference;

@Remote
public interface FutureConferencesWSRemote {
	
	public List<Conference> getUpcomingConferences(String field);

}
