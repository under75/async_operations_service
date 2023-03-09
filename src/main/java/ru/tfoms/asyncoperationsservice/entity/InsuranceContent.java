package ru.tfoms.asyncoperationsservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MPI_GET_VIEW_DATA_INSUR_RES", schema = "OMCOWNER")
@IdClass(CompositeKey.class)
public class InsuranceContent {
	@Id
	@Column(name = "RID")
	private Long rid;
	@Id
	@Column(name = "NR")
	private Integer nr;
	
	@Column(name = "DT")
	private LocalDate dt;
	
	@Column(name = "ENP")
	private String personEnp;
	
	@Column(name = "POL_TYPE")
	private String polType;
	
	@Column(name = "POL_NUM")
	private String polNum;
	
	@Column(name = "GENDER")
	private Integer gender;
	
	@Column(name = "BIRTH_YEAR")
	private Integer birthYear;
	
	@Column(name = "AGE")
	private String age;
	
	@Column(name = "AGE_TYPE")
	private String ageType;
	
	@Column(name = "SMO")
	private String smo;
	
	@Column(name = "SMO_OGRN")
	private String smoOgrn;
	
	@Column(name = "OKATO")
	private String okato;
	
	@Column(name = "DUDL_SER")
	private String dudlSer;
	
	@Column(name = "DUDL_NUM")
	private String dudlNum;
	
	@Column(name = "DUDL_EFF_DT")
	private LocalDate dudlEffDt;
	
	@Column(name = "DUDL_EXP_DT")
	private LocalDate dudlExpDt;
	
	@Column(name = "DUDL_TYPE")
	private String dudlType;
	
	@Column(name = "CITIZEN")
	private String sitizen;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	public String getPersonEnp() {
		return personEnp;
	}

	public void setPersonEnp(String personEnp) {
		this.personEnp = personEnp;
	}

	public String getPolType() {
		return polType;
	}

	public void setPolType(String polType) {
		this.polType = polType;
	}

	public String getPolNum() {
		return polNum;
	}

	public void setPolNum(String polNum) {
		this.polNum = polNum;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAgeType() {
		return ageType;
	}

	public void setAgeType(String ageType) {
		this.ageType = ageType;
	}

	public String getSmo() {
		return smo;
	}

	public void setSmo(String smo) {
		this.smo = smo;
	}

	public String getSmoOgrn() {
		return smoOgrn;
	}

	public void setSmoOgrn(String smoOgrn) {
		this.smoOgrn = smoOgrn;
	}

	public String getOkato() {
		return okato;
	}

	public void setOkato(String okato) {
		this.okato = okato;
	}

	public String getDudlSer() {
		return dudlSer;
	}

	public void setDudlSer(String dudlSer) {
		this.dudlSer = dudlSer;
	}

	public String getDudlNum() {
		return dudlNum;
	}

	public void setDudlNum(String dudlNum) {
		this.dudlNum = dudlNum;
	}

	public LocalDate getDudlEffDt() {
		return dudlEffDt;
	}

	public void setDudlEffDt(LocalDate dudlEffDt) {
		this.dudlEffDt = dudlEffDt;
	}

	public LocalDate getDudlExpDt() {
		return dudlExpDt;
	}

	public void setDudlExpDt(LocalDate dudlExpDt) {
		this.dudlExpDt = dudlExpDt;
	}

	public String getDudlType() {
		return dudlType;
	}

	public void setDudlType(String dudlType) {
		this.dudlType = dudlType;
	}

	public String getSitizen() {
		return sitizen;
	}

	public void setSitizen(String sitizen) {
		this.sitizen = sitizen;
	}
	
}
