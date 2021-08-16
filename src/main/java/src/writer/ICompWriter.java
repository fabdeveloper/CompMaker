package src.writer;

import java.util.List;

import src.fieldmakers.IFieldMaker;

public interface ICompWriter {

	String writeAttributes();

	String writeImplementation();

	String writeComments();

	String writeHeader();

	String writeFooter();

	String writeOpenBody();

	String writeCloseBody();
	
	String writeOpenForm();
	
	String writeCloseForm();

	String writeOpenInterface();

	String writeCloseInterface();

	String writeOpenImplementation();

	String writeCloseImplementation();
	
	String writeOpenComments();
	
	String writeCloseComments();
	
	String writeDocument();

	void setFieldMakersList(List<IFieldMaker> fieldMakersList);
	
	

}