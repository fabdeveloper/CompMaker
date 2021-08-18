package src.fieldmakers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;


@SessionScoped
public class InputTextAreaFieldMaker extends AbstractFieldMaker implements Serializable {
	
	
	
	
	@Override
	public String makeImplementation() {
		
		String sImpl = "" + 
		"<p:outputText value=\"#{cc.attrs." + getNombreVarLabel() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\"></p:outputText>" + "\n" +
		"<p:inputTextarea class=\"#{cc.attrs.inputTextClass}\" value=\"#{cc.attrs." + getNombreVarField() + "}\" " + 
				"disabled=\"#{cc.attrs." + getNombreVarDisabled() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\"></p:inputTextarea>" + "\n";
		
		return sImpl;
	}
	
	@Override
	public InputTextAreaFieldMaker clone()throws CloneNotSupportedException{  
		InputTextAreaFieldMaker nuevo = new InputTextAreaFieldMaker();
		
		return (InputTextAreaFieldMaker)setAll(nuevo);  
		} 
	
	

}
