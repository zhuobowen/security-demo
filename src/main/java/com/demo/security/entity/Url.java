package com.demo.security.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.demo.security.base.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "SS_URL")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Url extends BaseEntity {

	private static final long serialVersionUID = 12634810981401137L;
	
	/**
     * 名称
     */
    private String name;
    /**
     * url值
     */
    private String value;
    /**
     * 对应的权限
     */
    private List<Authority> authoritys = new ArrayList<Authority>();
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@ManyToMany( fetch=FetchType.EAGER)
    @JoinTable(name = "SS_URL_AUTHORITY", joinColumns = { @JoinColumn(name = "URL_ID") }, inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID") })
    @Fetch(FetchMode.SUBSELECT)
	//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Authority> getAuthoritys() {
		return authoritys;
	}
	
	public void setAuthoritys(List<Authority> authoritys) {
		this.authoritys = authoritys;
	}
    
}
