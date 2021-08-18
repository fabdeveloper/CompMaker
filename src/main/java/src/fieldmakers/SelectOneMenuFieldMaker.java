package src.fieldmakers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SelectOneMenuFieldMaker extends AbstractSelectableListFieldMaker implements Serializable {
	
	private String nombreVarEventListener;


	@Override
	public String makeImplementation() {
		String sImpl = "" +
				"<p:outputText value=\"#{cc.attrs." + getNombreVarLabel() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\"></p:outputText>" + "\n" +
				"<ui:selectOneMenu styleClass=\"#{cc.attrs.selectOneMenuClass}\"  value=\"#{cc.attrs." + getNombreVarField() + "}\" disabled=\"#{cc.attrs." + getNombreVarDisabled() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\">" + "\n" +
				"<c:selectItems value=\"#{cc.attrs." + getNombreVarList() + "}\" ></c:selectItems>" + "\n" +
				"<ui:ajax event=\"itemSelect\" process=\"@this\" update=\"@this\" listener=\"#{cc.attrs." + getNombreVarEventListener() + "}\" />" + "\n" +
				"</ui:selectOneMenu>" + "\n";
		
		return  sImpl;
	}
	
	@Override
	public String makeAttributes() {
		String sAttr = super.makeAttributes();

		sAttr += "<composite:attribute name=\"" + getNombreVarEventListener() + "\" method-signature=\"java.lang.String " + getNombreVarEventListener() + "()\"></composite:attribute>" + "\n";

		return sAttr;
	}
	
	@Override
	public String generateComments() {		
		String sResult = super.generateComments();		
		
		sResult += "" +
					getNombreVarEventListener() + "=\"\"" + "\n";		
		
		return sResult;
	}
	
	@Override
	public void generateVarNames() {
		super.generateVarNames();		
		
		nombreVarEventListener = getName() + "EventListener";
	}
	
	
	@Override
	public SelectOneMenuFieldMaker clone()throws CloneNotSupportedException{  
		SelectOneMenuFieldMaker nuevo = new SelectOneMenuFieldMaker();
		
		return (SelectOneMenuFieldMaker)setAll(nuevo);  
	} 
	
	
	
	public String getNombreVarEventListener() {
		return nombreVarEventListener;
	}

	public void setNombreVarEventListener(String nombreVarEventListener) {
		this.nombreVarEventListener = nombreVarEventListener;
	}
	
	

}
