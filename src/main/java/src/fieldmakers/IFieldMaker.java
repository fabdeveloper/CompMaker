package src.fieldmakers;

import src.util.FieldTypes;

public interface IFieldMaker  extends Cloneable{ 
	
	public String getName();
	public void setName(String name);
	public FieldTypes getType();
	public void setType(FieldTypes type);
	
	public void makeIt();
	public String makeAttributes();
	public String makeImplementation();
	
	public String getAttributes();
	public void setAttributes(String attributes);
	public String getImplementation();
	public void setImplementation(String implementation);
	public String getComments();
	public void setComments(String comments);
	
	public IFieldMaker setAll(IFieldMaker clon);
	public void generateVarNames();
	public String generateComments();
	


}
