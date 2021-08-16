package src.factory;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

import src.fieldmakers.CommandButtonMaker;
import src.fieldmakers.InputTextFieldMaker;

@SessionScoped
public class FieldMakerFactory implements IAbstractFieldMakerFactory, Serializable{
	
	@Inject 
	private InputTextFieldMaker inputTextFieldMaker;
	@Inject
	private CommandButtonMaker commandButtonMaker;

	@Override
	public CommandButtonMaker getCommandButtonMaker() throws CloneNotSupportedException {
		return commandButtonMaker.clone();
	}

	public void setCommandButtonMaker(CommandButtonMaker commandButtonMaker) {
		this.commandButtonMaker = commandButtonMaker;
	}

	@Override
	public InputTextFieldMaker getInputTextFieldMaker() throws CloneNotSupportedException {
		return inputTextFieldMaker.clone();
	}

	public void setInputTextFieldMaker(InputTextFieldMaker inputTextFieldMaker) {
		this.inputTextFieldMaker = inputTextFieldMaker;
	}
	
	
	
	

}
