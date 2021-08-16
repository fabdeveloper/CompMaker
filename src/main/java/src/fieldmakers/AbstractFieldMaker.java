package src.fieldmakers;

import src.util.FieldTypes;

public abstract class AbstractFieldMaker implements IFieldMaker {
	
	protected String name;
	protected FieldTypes type;
	
	private String attributes = "";
	private String implementation = "";
	private String comments = "";
	
	private String nombreVarLabel = "";
	private String sDefaultLabel = "";
	private String nombreVarField = "";
	private String nombreVarRendered = "";
	private String nombreVarDisabled = "";
	
	
	

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public FieldTypes getType() {
		return type;
	}
	
	@Override
	public void setType(FieldTypes type) {
		this.type = type;
	}

	@Override
	public void makeIt() {
		generateVarNames();
		attributes = makeAttributes();
		implementation = makeImplementation();
		comments = generateComments();
	}


	@Override
	public String getAttributes() {
		return attributes;
	}

	@Override
	public String getImplementation() {
		return implementation;
	}


	@Override
	public void setAttributes(String attributes) {
		this.attributes = attributes;		
	}

	@Override
	public void setImplementation(String implementation) {
		this.implementation = implementation;
	}

	@Override
	public String getComments() {
		return comments;
	}
	
	@Override
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public IFieldMaker setAll(IFieldMaker clon) {

		clon.setName(this.getName());
		clon.setType(this.getType());
		clon.setAttributes(this.getAttributes());
		clon.setImplementation(this.getImplementation());
		clon.setComments(this.getComments());
		
		return clon;
	}


	@Override
	public void generateVarNames() {
		nombreVarLabel = getName() + "Label";
		sDefaultLabel = getName() + ":";
		nombreVarField = getName() + "Field";
		nombreVarRendered = getName() + "Rendered";
		nombreVarDisabled = getName() + "Disabled";		
	}
	
	@Override
	public String generateComments() {
		String sResult = "" +
					getNombreVarLabel() + "=\"\"" + "\n" +
					getNombreVarField() + "=\"\"" + "\n" +
					getNombreVarDisabled() + "=\"\"" + "\n" +
					getNombreVarRendered() + "=\"\"" + "\n";		
		
		return sResult;
	}
	
	public String getNombreVarLabel() {
		return nombreVarLabel;
	}

	public void setNombreVarLabel(String nombreVarLabel) {
		this.nombreVarLabel = nombreVarLabel;
	}

	public String getsDefaultLabel() {
		return sDefaultLabel;
	}

	public void setsDefaultLabel(String sDefaultLabel) {
		this.sDefaultLabel = sDefaultLabel;
	}

	public String getNombreVarField() {
		return nombreVarField;
	}

	public void setNombreVarField(String nombreVarField) {
		this.nombreVarField = nombreVarField;
	}

	public String getNombreVarRendered() {
		return nombreVarRendered;
	}

	public void setNombreVarRendered(String nombreVarRendered) {
		this.nombreVarRendered = nombreVarRendered;
	}

	public String getNombreVarDisabled() {
		return nombreVarDisabled;
	}

	public void setNombreVarDisabled(String nombreVarDisabled) {
		this.nombreVarDisabled = nombreVarDisabled;
	}
	
	
	

}
