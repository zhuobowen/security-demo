package com.demo.security.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.demo.security.base.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Table(name="SS_ROLE")
@Entity
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Role extends BaseEntity {
	private static final long serialVersionUID = -7554276381643699933L;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 上级岗位角色
	 */
	private Role parent;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 角色拥有的权限
	 */

	private List<Authority> authoritys = new ArrayList<Authority>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parentid", nullable = true)
	public Role getParent() {
		return parent;
	}

	public void setParent(Role parent) {
		this.parent = parent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@ManyToMany
	@JoinTable(name = "SS_ROLE_AUTHORITY", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID") })
	@Fetch(FetchMode.SUBSELECT)
	//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Authority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(List<Authority> authoritys) {
		this.authoritys = authoritys;
	}
}
