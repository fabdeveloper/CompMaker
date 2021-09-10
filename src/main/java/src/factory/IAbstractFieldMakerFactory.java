package src.factory;

import src.fieldmakers.CommandButtonMaker;
import src.fieldmakers.DataTableFieldMaker;
import src.fieldmakers.IFieldMaker;
import src.fieldmakers.InputTextAreaFieldMaker;
import src.fieldmakers.InputTextFieldMaker;
import src.fieldmakers.SelectOneListBoxFieldMaker;
import src.fieldmakers.SelectOneMenuFieldMaker;

public interface IAbstractFieldMakerFactory {
	
	public InputTextFieldMaker getInputTextFieldMaker() throws CloneNotSupportedException;
	public CommandButtonMaker getCommandButtonMaker() throws CloneNotSupportedException;
	public InputTextAreaFieldMaker getInputTextAreaFieldMaker()  throws CloneNotSupportedException;
	public SelectOneMenuFieldMaker getSelectOneMenuFieldMaker() throws CloneNotSupportedException;
	public SelectOneListBoxFieldMaker getSelectOneListBoxFieldMaker() throws CloneNotSupportedException;
	public DataTableFieldMaker getDataTableFieldMaker() throws CloneNotSupportedException;





}
