package src.factory;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

import src.fieldmakers.CommandButtonMaker;
import src.fieldmakers.InputTextAreaFieldMaker;
import src.fieldmakers.InputTextFieldMaker;
import src.inter.InputTextAreaFieldMakerQualifier;
import src.inter.InputTextFieldMakerQualifier;

@SessionScoped
public class FieldMakerFactory implements IAbstractFieldMakerFactory, Serializable{
	
	@Inject @InputTextFieldMakerQualifier
	private InputTextFieldMaker inputTextFieldMaker;
	@Inject @InputTextAreaFieldMakerQualifier
	private InputTextAreaFieldMaker inputTextAreaFieldMaker;
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

	@Override
	public InputTextAreaFieldMaker getInputTextAreaFieldMaker() throws CloneNotSupportedException {
		return inputTextAreaFieldMaker.clone();
	}

	public void setInputTextAreaFieldMaker(InputTextAreaFieldMaker inputTextAreaFieldMaker) {
		this.inputTextAreaFieldMaker = inputTextAreaFieldMaker;
	}
	
	
	
	

}
