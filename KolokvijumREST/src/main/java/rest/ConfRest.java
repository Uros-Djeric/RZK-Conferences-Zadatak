package rest;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.Conference;
import rzk.beans.session.ConfInfoSB;
import rzk.beans.session.ConfInfoSBRemote;


@Path("conferences")
public class ConfRest {

	private static Context initialContext;

	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties properties = new Properties();
			properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
			initialContext = new InitialContext(properties);
		}
		return initialContext;
	}

	private static String getLookupName() {
		
		// The app name is the application name of the deployed EJBs. This is typically the ear name without the .ear suffix. 
        final String appName = "ConfInfoEAR";
        // This is the module name of the deployed EJBs on the server. This is typically the jar name of the EJB deployment, without the .jar suffix.
        final String moduleName = "ConfInfoEJB";
        // JBossAS allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
        // our EJB deployment, so this is an empty string
        final String distinctName = "";
        // The EJB name which by default is the simple class name of the bean implementation class
        final String beanName = ConfInfoSB.class.getSimpleName();
        // the remote interface fully qualified class name
        final String interfaceName = ConfInfoSBRemote.class.getName();
        // let's do the lookup
		String name = "ejb:" + appName + "/" + moduleName + "/" +
				distinctName    + "/" + beanName + "!" + interfaceName;
		return name;
	}

	private static ConfInfoSBRemote doLookup() {
		Context context = null;
		ConfInfoSBRemote bean = null;
		try {
			context = getInitialContext();
			String lookupName = getLookupName();
			System.out.println("JNDI ime:   "+lookupName);
			bean = (ConfInfoSBRemote) context.lookup(lookupName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
	ConfInfoSBRemote confInfo = doLookup();

	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Conference> getPredavacsConference(@QueryParam("ime")String ime, @QueryParam("prezime")String prezime){
//		return confInfo.getPredavacsConference(ime, prezime);
//	}
	
	
}
