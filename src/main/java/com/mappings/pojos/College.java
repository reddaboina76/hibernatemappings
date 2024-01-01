package com.mappings.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="college")
public class College {
	
	@Id
	@GeneratedValue
	@Column(name="CLG_ID")
	private Integer clgId;
	
	@Column(name="CLG_NAME")
	private String clgName;
	
	@Column(name="CLG_LOCATION")
	private String clgLocation;
	
	@Column(name="CLG_ESTABLISHED")
	private String Established;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UNIVERSITY_ID")
	private University uni;
	
	public University getUni() {
		return uni;
	}
	public void setUni(University uni) {
		this.uni = uni;
	}
	public Integer getClgId() {
		return clgId;
	}
	public void setClgId(Integer clgId) {
		this.clgId = clgId;
	}
	public String getClgName() {
		return clgName;
	}
	public void setClgName(String clgName) {
		this.clgName = clgName;
	}
	public String getClgLocation() {
		return clgLocation;
	}
	public void setClgLocation(String clgLocation) {
		this.clgLocation = clgLocation;
	}
	public String getEstablished() {
		return Established;
	}
	public void setEstablished(String established) {
		Established = established;
	}
	
	


}
