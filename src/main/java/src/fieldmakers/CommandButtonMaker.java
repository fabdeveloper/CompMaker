package src.fieldmakers;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CommandButtonMaker extends AbstractFieldMaker {

	@Override
	public String makeAttributes() {
		String sattr = "" +
	
		 "<composite:attribute name=\"" + getNombreVarLabel()  + "\" default=\"" + getNombreVarLabel() +  "\"></composite:attribute>" + "\n" +
		 "<composite:attribute name=\"" + getNombreVarField() + "\" method-signature=\"java.lang.String " + getNombreVarField() + "()\"></composite:attribute>" + "\n" +
		 "<composite:attribute name=\"" + getNombreVarRendered() + "\" type=\"java.lang.Boolean\" default=\"true\"></composite:attribute>" + "\n" +
		 "<composite:attribute name=\"" + getNombreVarDisabled() + "\" type=\"java.lang.Boolean\" default=\"false\"></composite:attribute>" + "\n";			
		
		return sattr;
	}

	@Override
	public String makeImplementation() {
		String simpl = "" +

		"<p:commandButton class=\"#{cc.attrs.commandButtonClass}\" value=\"#{cc.attrs." + getNombreVarLabel() + "}\" action=\"#{cc.attrs." + getNombreVarField() + "}\"" + 
						" disabled=\"#{cc.attrs." + getNombreVarDisabled() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\"></p:commandButton>" + "\n";
		
		return simpl;
	}
	
	@Override
	public CommandButtonMaker clone()throws CloneNotSupportedException{  
		CommandButtonMaker nuevo = new CommandButtonMaker();
		
		// copiar variables propias
		// ...
		
		return (CommandButtonMaker)setAll(nuevo);  
	} 
	
//	@Override
//	public void generateVarNames() {
//		super.generateVarNames();
//		
//		// generar variables propias
//		// ...
//		
//	}
	
//	@Override
//	public String generateComments() {
//		String com = super.generateComments();
//		
//		// generar comentarios propios
//		// ...
//		
//		
//		return com;
//	}



}
