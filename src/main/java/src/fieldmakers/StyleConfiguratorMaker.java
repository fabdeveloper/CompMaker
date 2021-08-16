package src.fieldmakers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class StyleConfiguratorMaker extends AbstractFieldMaker implements Serializable{
	
	private List<String> listNamesTypesCreated;
	private List<String> listStyleClassNames;



	@Override
	public String makeAttributes() {
		String sattr = "";
		
		for(String stype : getListStyleClassNames()) {
			sattr += "<composite:attribute name=\"" + stype + "\" default=\"" + stype + "\"></composite:attribute>" + "\n";
		}		
		return sattr;
	}

	@Override
	public String makeImplementation() {
		return "";
	}
	
	@Override
	public String generateComments() {
		String scom = "";
		
		for(String stype : getListStyleClassNames()) {
			scom += stype + "=\"\"" + "\n";
		}	
		
		return scom;		
	}

	public List<String> getListNamesTypesCreated() {
		return listNamesTypesCreated;
	}

	public void setListNamesTypesCreated(List<String> listNamesTypesCreated) {
		this.listNamesTypesCreated = listNamesTypesCreated;
	}
	
	private List<String> getListStyleClassNames() {
		listStyleClassNames = new ArrayList<String>();
		
		for(String stype : getListNamesTypesCreated()) {
			listStyleClassNames.add(stype + "Class");
		}
		return listStyleClassNames;
	}


	
	

}
