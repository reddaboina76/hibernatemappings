package com.mappings.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "empid")
	private Integer empId;

	@Column(name = "empname")
	private String empName;

	@Column(name = "salary")
	private String sal;

	@Column(name = "company")
	private String company;

	@Column(name = "designation")
	private String designation;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pp_id")
	private Ppassport ppassport;

	public Ppassport getPpassport() {
		return ppassport;
	}

	public void setPpassport(Ppassport ppassport) {
		this.ppassport = ppassport;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

}
