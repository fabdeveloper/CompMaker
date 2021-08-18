package src.fieldmakers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class InputTextFieldMaker extends AbstractFieldMaker implements Serializable {

//	@Override
//	public String makeAttributes() {
//		
//		String sAttributes = "";
//
//		sAttributes += "<composite:attribute name=\"" + getNombreVarLabel()  + "\" default=\"" + getsDefaultLabel() +  "\"></composite:attribute>" + "\n";
//		sAttributes += "<composite:attribute name=\"" + getNombreVarField() + "\"></composite:attribute>" + "\n";
//		sAttributes += "<composite:attribute name=\"" + getNombreVarRendered() + "\" type=\"java.lang.Boolean\" default=\"true\"></composite:attribute>" + "\n";
//		sAttributes += "<composite:attribute name=\"" + getNombreVarDisabled() + "\" type=\"java.lang.Boolean\" default=\"false\"></composite:attribute>" + "\n";		
//		
//		return sAttributes;
//	}

	@Override
	public String makeImplementation() {
		
		String sImpl = "" + 
		"<p:outputText value=\"#{cc.attrs." + getNombreVarLabel() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\"></p:outputText>" + "\n" +
		"<p:inputText class=\"#{cc.attrs.inputTextClass}\" value=\"#{cc.attrs." + getNombreVarField() + "}\" " + 
				"disabled=\"#{cc.attrs." + getNombreVarDisabled() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\"></p:inputText>" + "\n";
		
		return sImpl;
	}
	
	@Override
	public InputTextFieldMaker clone()throws CloneNotSupportedException{  
		InputTextFieldMaker nuevo = new InputTextFieldMaker();
		
		return (InputTextFieldMaker)setAll(nuevo);  
		} 

}
