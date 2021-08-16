package src.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import src.compmaker.ICompMaker;
import src.fieldmakers.IFieldMaker;
import src.util.PublisherBean;

@Named
@SessionScoped
public class DocumentCreatorBB implements Serializable {
	
	@Inject
	private ICompMaker compMaker;
	
	@Inject 
	private PublisherBean publisher;
	
	private List<String> makersNamesList;
	
	private String makerNameSelected;
	
	
	
	
	
	
	public String reset() {		
		getCompMaker().reset();		
		return null;
	}
	
	public String addField() {
		publisher.publish("DocumentCreatorBB.addField()");
		compMaker.createField();	
		setMakersNamesList(null);
		return "";
	}
	
	public String removeField() {
		compMaker.removeFieldMaker(compMaker.getFieldMakerByName(makerNameSelected));	
		setMakersNamesList(null);

		return "";
	}
	
	public String listenerTypes() {
		return null;
	}
	
	public String listenerFields() {
		return null;
	}
	
	public Boolean botonAddDisabled() {
//		return compMaker.getFieldName() == null;
		return false;
	}
	
	public Boolean botonRemoveDisabled() {
//		return compMaker.getFieldSelected() == null;
		return false;
	}

	public ICompMaker getCompMaker() {
		return compMaker;
	}

	public void setCompMaker(ICompMaker compMaker) {
		this.compMaker = compMaker;
	}

	public PublisherBean getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherBean publisher) {
		this.publisher = publisher;
	}

	public List<String> getMakersNamesList() {
		if(makersNamesList == null) {
			makersNamesList = new ArrayList<String>();
			for(IFieldMaker maker : getCompMaker().getFieldMakersList()) {
				if(maker.getName() != null) {
					makersNamesList.add(maker.getName());
				}
			}
		}
		return makersNamesList;
	}

	public void setMakersNamesList(List<String> makersNamesList) {
		this.makersNamesList = makersNamesList;
	}

	public String getMakerNameSelected() {
		return makerNameSelected;
	}

	public void setMakerNameSelected(String makerNameSelected) {
		this.makerNameSelected = makerNameSelected;
	}
	
	
	
	

}
