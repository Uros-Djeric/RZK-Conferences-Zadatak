package rzk.beans.session;

import java.util.List;

import javax.ejb.Remote;

import model.Conference;

@Remote
public interface ConfInfoSBRemote {

	public boolean addConference(Conference conference);
	
	public List<Conference>getPredavacsConference(String ime, String prezime);
	
}
