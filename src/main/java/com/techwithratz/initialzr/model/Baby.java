package com.techwithratz.initialzr.model;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("All details about the Baby Entity")
public class Baby {

	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@ApiModelProperty(notes = "Name should have atleast 2 characters", required = true)
	private String name;
	
	@Past
	@ApiModelProperty(notes = "Birth date cannot be in the future" )
	private Date birthDate;
	
	private String motherName;
	
	private String fatherName;
	
	private String gender;
	
	private double weight;
	
	public Baby() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Baby(Integer id, @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@Past Date birthDate, String motherName, String fatherName, String gender, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.gender = gender;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Baby [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", motherName=" + motherName
				+ ", fatherName=" + fatherName + ", gender=" + gender + ", weight=" + weight + "]";
	}	
	
	

}

