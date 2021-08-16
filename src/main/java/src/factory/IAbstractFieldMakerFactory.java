package src.factory;

import src.fieldmakers.CommandButtonMaker;
import src.fieldmakers.IFieldMaker;
import src.fieldmakers.InputTextAreaFieldMaker;

public interface IAbstractFieldMakerFactory {
	
	public IFieldMaker getInputTextFieldMaker() throws CloneNotSupportedException;
	public CommandButtonMaker getCommandButtonMaker() throws CloneNotSupportedException;
	public InputTextAreaFieldMaker getInputTextAreaFieldMaker()  throws CloneNotSupportedException;



}
