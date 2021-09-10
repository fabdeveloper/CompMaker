package src.fieldmakers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class DataTableFieldMaker extends AbstractSelectableDataTableFieldMaker implements Serializable{

	@Override
	public String makeImplementation() {
		String sImpl = "" +

		"<p:outputText value=\"#{cc.attrs." + getNombreVarLabel() + "}\" rendered=\"#{cc.attrs." + getNombreVarRendered() + "}\"></p:outputText>" + "\n" +		
		
		"<ui:dataTable  value=\"#{cc.attrs." + getNombreVarList() + "}\" var=\"registro\" scrollable=\"#{cc.attrs." + getNombreVarScrollable() + "}\" selectionMode=\"#{cc.attrs." + getNombreVarSelectionMode() + "}\" selection=\"#{cc.attrs." + getNombreVarField() + "}\" rowKey=\"#{registro.id}\">" + "\n" +
		"	<ui:columns value=\"#{cc.attrs." + getNombreVarListaColumnas() + "}\" var=\"column\" headerText=\"#{column.header}\">" + "\n" +
		"		<p:outputText value=\"#{registro[column.property]}\" />" + "\n" +					
		"	</ui:columns>" + "\n" +
		"	<ui:ajax event=\"rowSelect\" listener=\"#{cc.attrs." + getNombreProcRowSelectListener() + "}\"/>" + "\n" +
		"</ui:dataTable>" + "\n";		
		
		return sImpl;
	}
	
	
	@Override
	public DataTableFieldMaker clone()throws CloneNotSupportedException{  
		DataTableFieldMaker nuevo = new DataTableFieldMaker();
		
		return (DataTableFieldMaker)setAll(nuevo);  
	} 

}
