package src.factory;

import src.fieldmakers.CommandButtonMaker;
import src.fieldmakers.IFieldMaker;

public interface IAbstractFieldMakerFactory {
	
	public IFieldMaker getInputTextFieldMaker() throws CloneNotSupportedException;
	public CommandButtonMaker getCommandButtonMaker() throws CloneNotSupportedException;


}
