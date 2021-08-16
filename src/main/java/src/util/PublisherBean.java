package src.util;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Dependent
public class PublisherBean implements Serializable {
	
	public void publish(String msg) {
		publishFaces(msg);
		publishStandard(msg);
	}
	
	
	public void publishFaces(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	public void publishStandard(String msg) {
		System.out.println(msg);
	}

}
