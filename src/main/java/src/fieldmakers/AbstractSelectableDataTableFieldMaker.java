package src.fieldmakers;

public abstract class AbstractSelectableDataTableFieldMaker extends AbstractSelectableListFieldMaker {


	private String nombreVarListaColumnas;
	private String nombreVarScrollable;
	private String nombreVarSelectionMode;
	private String nombreProcRowSelectListener;
	
	
	
	@Override
	public String generateComments() {		
		String sResult = super.generateComments();		
		
		sResult += "" +
					getNombreVarListaColumnas() + "=\"\"" + "\n" +
					getNombreVarScrollable() + "=\"\"" + "\n" +	
					getNombreVarSelectionMode() + "=\"\"" + "\n" +		
					getNombreProcRowSelectListener() + "=\"\"" + "\n";		

		return sResult;
	}
	
	
	@Override
	public String makeAttributes() {
		String sAttr = super.makeAttributes();

		sAttr += "<composite:attribute name=\"" + getNombreVarListaColumnas() + "\"  type=\"java.util.List\"></composite:attribute>" + "\n" +
		"<composite:attribute name=\"" + getNombreVarScrollable() + "\"  type=\"java.lang.Boolean\" default=\"true\"></composite:attribute>" + "\n" +	
		"<composite:attribute name=\"" + getNombreVarSelectionMode() + "\" default=\"single\"></composite:attribute>" + "\n" +
		"<composite:attribute name=\"" + getNombreProcRowSelectListener() + "\"  method-signature=\"java.lang.String rowSelectListener()\"></composite:attribute>" + "\n";

		return sAttr;
	}
	
	@Override
	public void generateVarNames() {
		super.generateVarNames();		
		
		nombreVarListaColumnas = getName() + "ListaColumnas";
		nombreVarScrollable = getName() + "_bScrollable";
		nombreVarSelectionMode = getName() + "SelectionMode";
		nombreProcRowSelectListener = getName() + "ProcRowSelectListener";
		
	}

	public String getNombreVarListaColumnas() {
		return nombreVarListaColumnas;
	}

	public void setNombreVarListaColumnas(String nombreVarListaColumnas) {
		this.nombreVarListaColumnas = nombreVarListaColumnas;
	}

	public String getNombreVarScrollable() {
		return nombreVarScrollable;
	}

	public void setNombreVarScrollable(String nombreVarScrollable) {
		this.nombreVarScrollable = nombreVarScrollable;
	}

	public String getNombreVarSelectionMode() {
		return nombreVarSelectionMode;
	}

	public void setNombreVarSelectionMode(String nombreVarSelectionMode) {
		this.nombreVarSelectionMode = nombreVarSelectionMode;
	}

	public String getNombreProcRowSelectListener() {
		return nombreProcRowSelectListener;
	}

	public void setNombreProcRowSelectListener(String nombreProcRowSelectListener) {
		this.nombreProcRowSelectListener = nombreProcRowSelectListener;
	}
	
	
	
	
	

}
