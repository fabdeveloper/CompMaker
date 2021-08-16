package src.builder;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import src.factory.IAbstractFieldMakerFactory;
import src.fieldmakers.IFieldMaker;
import src.util.FieldTypes;
import src.util.PublisherBean;

@SessionScoped
public class FieldMakerBuilder implements IFieldMakerBuilder, Serializable {
	
	@Inject
	private IAbstractFieldMakerFactory factory;
	
	@Inject
	private PublisherBean publisher;
	
	private String name;
	private FieldTypes type;
	
	
	@Override
	public void reset() {
		setName(null);
		setType(null);		
	}
	
	@Override
	public IFieldMaker build() {
		getPublisher().publish("FieldMakerBuilder.build() - type= " + getType().toString() + ", name= " + getName());
		IFieldMaker obj = null;
		
		try {
			switch(type) {
			case inputText:
				obj = factory.getInputTextFieldMaker();	
				break;
			case textArea:
				obj = factory.getInputTextAreaFieldMaker();
				break;
			case commandButton:
				obj = factory.getCommandButtonMaker();
				break;
				default:;
			}
			if(obj != null) {
				obj.setName(getName());
				obj.setType(getType());
			}
			
		}catch(CloneNotSupportedException e) {
			
		}
		return obj;		
	}


	public IAbstractFieldMakerFactory getFactory() {
		return factory;
	}


	public void setFactory(IAbstractFieldMakerFactory factory) {
		this.factory = factory;
	}


	@Override
	public String getName() {
		return name;
	}


	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public FieldTypes getType() {
		return type;
	}

	@Override
	public void setType(FieldTypes type) {
		this.type = type;
	}

	public PublisherBean getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherBean publisher) {
		this.publisher = publisher;
	}



	
	
	

}
