package src.fieldmakers;


public abstract class AbstractSelectableListFieldMaker extends AbstractFieldMaker {
	
	private String nombreVarList;

	

	@Override
	public String makeAttributes() {
		String sAttr = super.makeAttributes();

		sAttr += "<composite:attribute name=\"" + getNombreVarList() + "\" type=\"java.util.List\"></composite:attribute>" + "\n";

		return sAttr;
	}


	
	@Override
	public void generateVarNames() {
		super.generateVarNames();		
		
		nombreVarList = getName() + "List";
	}
	
	@Override
	public String generateComments() {		
		String sResult = super.generateComments();		
		
		sResult += "" +
					getNombreVarList() + "=\"\"" + "\n";		
		return sResult;
	}
	
	
	public String getNombreVarList() {
		return nombreVarList;
	}

	public void setNombreVarList(String nombreVarList) {
		this.nombreVarList = nombreVarList;
	}



}


