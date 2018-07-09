package com.demo.security.base;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 6268705886981023482L;
	
	protected String id;
	
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid") 
    @GeneratedValue(generator="idGenerator")
	public String getId() {
	    return id;
	}
	
	public void setId(String id) {
		this.id = id;
		
	}
}
