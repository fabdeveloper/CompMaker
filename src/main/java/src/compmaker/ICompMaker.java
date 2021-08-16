package src.compmaker;

import java.util.List;

import src.fieldmakers.IFieldMaker;
import src.util.FieldTypes;

public interface ICompMaker {

	void reset();
	
	public void makeAll();

	void createField();

	void addFieldMaker(IFieldMaker fm);

	void removeFieldMaker(IFieldMaker fm);

	List<IFieldMaker> getFieldMakersList();

	String getFieldName();

	void setFieldName(String fieldName);

	FieldTypes getFieldType();

	void setFieldType(FieldTypes fieldType);

	List<FieldTypes> getFieldTypesList();
	
//	public IFieldMaker getFieldSelected();
	
	public IFieldMaker getFieldMakerByName(String sname);


	String getDocument();

}