package src.factory;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import src.fieldmakers.CommandButtonMaker;
import src.fieldmakers.DataTableFieldMaker;
import src.fieldmakers.InputTextAreaFieldMaker;
import src.fieldmakers.InputTextFieldMaker;
import src.fieldmakers.SelectOneListBoxFieldMaker;
import src.fieldmakers.SelectOneMenuFieldMaker;

@SessionScoped
public class FieldMakerFactory implements IAbstractFieldMakerFactory, Serializable{
	
	@Inject 
	private InputTextFieldMaker inputTextFieldMaker;
	@Inject 
	private InputTextAreaFieldMaker inputTextAreaFieldMaker;
	@Inject
	private SelectOneMenuFieldMaker selectOneMenuFieldMaker;
	@Inject
	private SelectOneListBoxFieldMaker selectOneListBoxFieldMaker;
	@Inject
	private CommandButtonMaker commandButtonMaker;
	@Inject
	private DataTableFieldMaker dataTableFieldMaker;
	




	@Override
	public SelectOneMenuFieldMaker getSelectOneMenuFieldMaker() throws CloneNotSupportedException {
		return selectOneMenuFieldMaker.clone();
	}

	public void setSelectOneMenuFieldMaker(SelectOneMenuFieldMaker selectOneMenuFieldMaker) {
		this.selectOneMenuFieldMaker = selectOneMenuFieldMaker;
	}
	
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

	@Override
	public SelectOneListBoxFieldMaker getSelectOneListBoxFieldMaker() throws CloneNotSupportedException {
		return selectOneListBoxFieldMaker.clone();
	}

	public void setSelectOneListBoxFieldMaker(SelectOneListBoxFieldMaker selectOneListBoxFieldMaker) {
		this.selectOneListBoxFieldMaker = selectOneListBoxFieldMaker;
	}

	@Override
	public DataTableFieldMaker getDataTableFieldMaker() throws CloneNotSupportedException {
		return dataTableFieldMaker.clone();
	}

	public void setDataTableFieldMaker(DataTableFieldMaker dataTableFieldMaker) {
		this.dataTableFieldMaker = dataTableFieldMaker;
	}
	
	
	
	

}
