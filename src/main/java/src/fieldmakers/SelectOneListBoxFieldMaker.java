package src.fieldmakers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SelectOneListBoxFieldMaker extends AbstractSelectableListFieldMaker implements Serializable {

	@Override
	public String makeImplementation() {
		String sImpl = "" +


		"<p:outputText value=\"#{cc.attrs." + getNombreVarLabel() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\"></p:outputText>" + "\n" +

		"<p:selectOneListbox styleClass=\"cc.attrs.selectOneListBoxClass\" value=\"#{cc.attrs." + getNombreVarField() + "}\" disabled=\"#{cc.attrs." + getNombreVarDisabled() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\">" + "\n" +
		"<c:selectItems value=\"#{cc.attrs." + getNombreVarList() + "}\"></c:selectItems>" + "\n" + 			
	"</p:selectOneListbox >" + "\n";		
		
		return sImpl;
	}
	
	@Override
	public SelectOneListBoxFieldMaker clone()throws CloneNotSupportedException{  
		SelectOneListBoxFieldMaker nuevo = new SelectOneListBoxFieldMaker();
		
		return (SelectOneListBoxFieldMaker)setAll(nuevo);  
	} 

}
