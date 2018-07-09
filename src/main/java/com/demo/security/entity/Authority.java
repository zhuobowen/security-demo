package com.demo.security.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.demo.security.base.BaseEntity;

@Entity
@Table(name = "SS_AUTHORITY")
@Inheritance(strategy = InheritanceType.JOINED)
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Authority extends BaseEntity {

	private static final long serialVersionUID = 582898287092482427L;
	
	 /**
     * 名称
     */
    private String name;
    /**
     * 显示名称
     */
    private String displayName;
    /**
     * 描述
     */
    private String description;
    
    /**
     * 是否启用
     */
    private Boolean enable;
    
    /**
     * 权限对应的url
     */
    private Set<Url> urls = new HashSet<Url>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	@ManyToMany(mappedBy = "authoritys",targetEntity = Url.class,fetch = FetchType.LAZY)
	public Set<Url> getUrls() {
		return urls;
	}

	public void setUrls(Set<Url> urls) {
		this.urls = urls;
	} 
	
	public Authority poToVo(){
		Authority vo = new Authority();
		vo.setId(this.id);
		vo.setDescription(this.description);
		vo.setDisplayName(this.displayName);
		vo.setEnable(this.enable);
		vo.setName(this.name);
		return vo;
	}
	
}
