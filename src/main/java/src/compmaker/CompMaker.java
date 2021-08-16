package src.compmaker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import src.builder.IFieldMakerBuilder;
import src.fieldmakers.IFieldMaker;
import src.fieldmakers.StyleConfiguratorMaker;
import src.util.FieldTypes;
import src.util.PublisherBean;
import src.writer.ICompWriter;

@SessionScoped
public class CompMaker implements Serializable, ICompMaker {
	
	@Inject
	private PublisherBean publisher;
	
	@Inject
	private IFieldMakerBuilder builder;	
	@Inject
	private StyleConfiguratorMaker decoratorStyleClassConfigurator;
	@Inject 
	private ICompWriter writer;
	
	private List<IFieldMaker> fieldMakersList;
//	private IFieldMaker fieldSelected;
	
	private String fieldName = "NO_INICIADO";
	private FieldTypes fieldType = FieldTypes.inputText;
	private List<FieldTypes> fieldTypesList = null;
	
	private String document;	
	

	@PostConstruct
	public void init() {
		addFieldMaker(getDecoratorStyleClassConfigurator());
	}

	
	
	@Override
	public void reset() {
		setFieldName(null);
		setFieldType(FieldTypes.inputText);		
	}	
	
	
	@Override
	public void createField() {
		publisher.publish("CompMaker.createField()");
		addFieldMaker(createFieldMaker());
		publisher.publish(getDocument());
	}
	
	public IFieldMaker createFieldMaker() {
		
		IFieldMakerBuilder fmbuilder = getBuilder();
		fmbuilder.setName(getFieldName());
		fmbuilder.setType(getFieldType());
		return fmbuilder.build();
	}

	
	@Override
	public void addFieldMaker(IFieldMaker fm) {
		publisher.publish("CompMaker.addFieldMaker()");
		if(fm.getName() == null || fieldNameNotExist(fm.getName().toString())) {
			getFieldMakersList().add(fm);
		}
	}
	
	private Boolean fieldNameNotExist(String sname) {
		Boolean bResult = true;
		for(IFieldMaker maker : getFieldMakersList()) {
			if(maker.getName() != null && maker.getName().toString().matches(sname)) {
				bResult = false;
			}
		}		
		return bResult;		
	}
	
	@Override
	public void removeFieldMaker(IFieldMaker fm) {
		getFieldMakersList().remove(fm);
		publisher.publish(getDocument());

	}


	public IFieldMakerBuilder getBuilder() {
		return builder;
	}


	public void setBuilder(IFieldMakerBuilder builder) {
		this.builder = builder;
	}


	@Override
	public List<IFieldMaker> getFieldMakersList() {
		if(fieldMakersList == null) {
			fieldMakersList = new ArrayList<IFieldMaker>();
		}
		return fieldMakersList;
	}


	public void setFieldMakersList(List<IFieldMaker> fieldMakersList) {
		this.fieldMakersList = fieldMakersList;
	}


	@Override
	public String getFieldName() {
		return fieldName;
	}


	@Override
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	@Override
	public FieldTypes getFieldType() {
//		if(fieldType == null) {
//			fieldType = FieldTypes.inputText;
//		}
		return fieldType;
	}


	@Override
	public void setFieldType(FieldTypes fieldType) {
		this.fieldType = fieldType;
	}


	@Override
	public List<FieldTypes> getFieldTypesList() {
		if(fieldTypesList == null) {
			fieldTypesList = Arrays.asList(FieldTypes.values());
		}
		return fieldTypesList;
	}


	public void setFieldTypesList(List<FieldTypes> fieldTypesList) {
		this.fieldTypesList = fieldTypesList;
	}


	public ICompWriter getWriter() {
		return writer;
	}


	public void setWriter(ICompWriter writer) {
		this.writer = writer;
	}


	@Override
	public String getDocument() {
		getDecoratorStyleClassConfigurator().setListNamesTypesCreated(getListNamesTiposCreados());
		
		makeAll();
		ICompWriter compwriter = getWriter();
		
		compwriter.setFieldMakersList(getFieldMakersList());
		setDocument(compwriter.writeDocument());
		
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	@Override
	public void makeAll() {
		for(IFieldMaker maker : getFieldMakersList()) {
			maker.makeIt();
		}		
	}


	@Override
	public IFieldMaker getFieldMakerByName(String sname) {
		IFieldMaker result = null;
		
		for(IFieldMaker maker : getFieldMakersList()) {
			if(maker.getName() != null && maker.getName().matches(sname)) {
				result = maker;
			}
		}		
		return result;
	}
	
	private List<String> getListNamesTiposCreados() {
		List<String> listaTipos = new ArrayList<String>();		
//		getFieldMakersList().stream().map(m -> m.getType().toString()).distinct().forEach(s -> listaTipos.add(s));
				
		for(IFieldMaker maker : getFieldMakersList() ) {
			if(maker.getType() != null) {
				String nombre = maker.getType().toString();
				if(!listaTipos.contains(nombre)) {
					listaTipos.add(nombre);
				}
			}
		}
		return listaTipos;
	}


	public PublisherBean getPublisher() {
		return publisher;
	}


	public void setPublisher(PublisherBean publisher) {
		this.publisher = publisher;
	}


	public StyleConfiguratorMaker getDecoratorStyleClassConfigurator() {
		return decoratorStyleClassConfigurator;
	}


	public void setDecoratorStyleClassConfigurator(StyleConfiguratorMaker decoratorStyleClassConfigurator) {
		this.decoratorStyleClassConfigurator = decoratorStyleClassConfigurator;
	}
	
	
	
	
	
	
	
	
	

}
