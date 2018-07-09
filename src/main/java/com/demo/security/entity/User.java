package com.demo.security.entity;

import com.demo.security.base.BaseEntity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ss_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity{
	
	private static final long serialVersionUID = -670524097773471483L;
	
	private String loginName;
	
	private String name;
	
	private String password;
	
	private Date createTime;
	
	private String email;

	private String mobile;

	private Boolean isValid;
	
	private Boolean isOnline;
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Boolean getIsValid() {
		return isValid;
	}
	
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	public Boolean getIsOnline() {
		return isOnline;
	}
	
	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}
}
