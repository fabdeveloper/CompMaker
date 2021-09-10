package src.builder;

import src.fieldmakers.IFieldMaker;
import src.util.FieldTypes;

public interface IFieldMakerBuilder {

	public void reset();

	public IFieldMaker build();

	public void setName(String name);
	public String getName();


	public void setType(FieldTypes type);
	public FieldTypes getType();


}