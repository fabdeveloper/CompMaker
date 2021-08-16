package src.writer;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import src.fieldmakers.IFieldMaker;



@RequestScoped
public class CompWriter implements ICompWriter {
	
	private List<IFieldMaker> fieldMakersList;
	
	
	
	
	
	
	
	
	
	@Override
	public String writeAttributes() {
		String attr = "";
		for(IFieldMaker maker : getFieldMakersList()) {
			attr += maker.getAttributes();
		}
		
		return attr;
	}
	
	@Override
	public String writeImplementation() {
		String impl = "";
		for(IFieldMaker maker : getFieldMakersList()) {
			impl += maker.getImplementation();
		}
		
		return impl;
	}
	
	@Override
	public String writeComments() {
		String comments = "";
		for(IFieldMaker maker : getFieldMakersList()) {
			comments += maker.getComments();
		}
		
		return comments;
	}
	
	@Override
	public String writeHeader() {
		String header = "" +
				"<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>" + "\n" +
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + "\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\"" + "\n" + 
					"xmlns:composite=\"http://java.sun.com/jsf/composite\"" + "\n" +
					"xmlns:c=\"http://java.sun.com/jsf/core\"" + "\n" +
					"xmlns:ui=\"http://primefaces.org/ui\"" + "\n" +
					"xmlns:p=\"http://java.sun.com/jsf/html\">" + "\n" + "\n";
		
		return header;
	}
	
	@Override
	public String writeFooter() {
		String footer = "" +
				"</html>" + "\n";
		
		return footer;		
	}
	
	@Override
	public String writeOpenBody() {
		String openBody = "" +
		
		"<p:body>" + "\n";
		
		return openBody;
	}
	
	@Override
	public String writeCloseBody() {
		String closeBody = "" +
				"</p:body>" + "\n";
		
		return closeBody;	
	}
	
	@Override
	public String writeOpenForm() {
		String sOpenForm = "" +		
						"<p:form >" + "\n";
		
		return sOpenForm;
	}

	@Override
	public String writeCloseForm() {
		String sCloseForm = "" +
							"</p:form>" + "\n";		
		
		return sCloseForm;
	}
	
	@Override
	public String writeOpenInterface() {
		String openInterface = "" +
		
		"	<composite:interface>" + "\n";
		
		return openInterface;
	}
	
	@Override
	public String writeCloseInterface() {
		String closeInterface = "" +
				"	</composite:interface>" + "\n";
		
		return closeInterface;	
	}
	
	@Override
	public String writeOpenImplementation() {
		String openImplementation = "" +		
		"		<composite:implementation>" + "\n";
		
		return openImplementation;
	}
	
	@Override
	public String writeCloseImplementation() {
		String closeImplementation= "" +
				"	</composite:implementation>" + "\n";
		
		return closeImplementation;	
	}

	@Override
	public String writeOpenComments() {
		
		String openComments = "" +
									"<!-- " + "\n";

		return openComments;
	}

	@Override
	public String writeCloseComments() {

		String closeComments = "" +
									" -->" + "\n";
		
		return closeComments;
	}
	
	@Override
	public String writeDocument() {
		String document = "";
		
		document += writeHeader();
		document += writeOpenBody();
		document += writeOpenInterface();
		document += writeAttributes();
		document += writeCloseInterface();
		document += writeOpenImplementation();
		document += writeOpenForm();
		document += writeImplementation();
		document += writeCloseForm();
		document += writeCloseImplementation();
		document += writeCloseBody();
		document += writeFooter();
		document += writeOpenComments();
		document += writeComments();
		document += writeCloseComments();		

		return document;
	}
	
	
	
	
	
	// GETTERS AND SETTERS
	

	public List<IFieldMaker> getFieldMakersList() {
		return fieldMakersList;
	}

	@Override
	public void setFieldMakersList(List<IFieldMaker> fieldMakersList) {
		this.fieldMakersList = fieldMakersList;
	}





	
	
	
	
	

}
