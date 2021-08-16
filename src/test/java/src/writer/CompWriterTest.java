package src.writer;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CompWriterTest {
	
	private ICompWriter writer;
	
	
	@Before
	public void init() {
		
		writer = new CompWriter();		
	}
	
	
	
//	@Test
	public void writeHeaderTest() {
		String sControlHeader = "" +				
				"<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>" + "\n" +
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + "\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\"" + "\n" + 
					"xmlns:composite=\"http://java.sun.com/jsf/composite\"" + "\n" +
					"xmlns:c=\"http://java.sun.com/jsf/core\"" + "\n" +
					"xmlns:ui=\"http://primefaces.org/ui\"" + "\n" +
					"xmlns:p=\"http://java.sun.com/jsf/html\">" + "\n" + "\n";
		
		String sWritedHeader = writer.writeHeader();		
		
		assertTrue("Error escribiendo header : " + sWritedHeader, sWritedHeader.matches(sControlHeader));		
	}
	
	@Test
	public void writeOpenBodyTest() {
		String controlOpenBody = "" +				
								"<p:body>" + "\n";
		
		String writedOpenBody = writer.writeOpenBody();
		
		assertTrue("Error escribiendo openBody : " + writedOpenBody, writedOpenBody.matches(controlOpenBody));	
	}

}
