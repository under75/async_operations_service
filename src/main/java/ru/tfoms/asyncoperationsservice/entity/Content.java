package ru.tfoms.asyncoperationsservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MPI_GET_VIEW_DATA_ATTACH_RES", schema = "OMCOWNER")
@IdClass(CompositeKey.class)
public class Content {
	@Id
	@Column(name = "RID")
	private Long rid;

	@Id
	@Column(name = "NR")
	private Integer nr;
	
	@Column(name = "DT")
	private LocalDate dt;
	
	@Column(name = "PERS_ENP")
	private String personEnp;
	
	@Column(name = "SMO_ID")
	private String smoId;
	
	@Column(name = "SMO_NAME")
	private String smoName;
	
	@Column(name = "SMO_OKATO_ID")
	private String smoOkatoId;
	
	@Column(name = "PERS_GENDER")
	private Integer personGender;
	
	@Column(name = "PERS_AGE")
	private String personAge;
	
	@Column(name = "MO_CODE")
	private String moCode;
	
	@Column(name = "MO_ID")
	private String moId;
	
	@Column(name = "MO_NAME")
	private String moName;
	
	@Column(name = "MO_OKATO_ID")
	private String moOkato;
	
	@Column(name = "FMO_ID")
	private String fmoId;
	
	@Column(name = "ATT_TYPE") 
	private Integer attachType;
	
	@Column(name = "ATT_D_TYPE") 
	private Integer attachDepartType;
	
	@Column(name = "ATT_METHOD") 
	private Integer attachMethod;
	
	@Column(name = "ATT_EFF_DT") 
	private LocalDate attachEffDate;
	
	@Column(name = "ATT_EXP_DT") 
	private LocalDate attachExpDate;
	
	@Column(name = "DOC_ID")
	private String doctorId;
	
	@Column(name = "DOC_SNILS")
	private String doctorSnils;
	
	@Column(name = "DOC_EFF_DT") 
	private LocalDate doctorEffDate;
	
	@Column(name = "ATT_STATUS")
	private String attachStatus;

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

	public String getSmoId() {
		return smoId;
	}

	public void setSmoId(String smoId) {
		this.smoId = smoId;
	}

	public String getSmoName() {
		return smoName;
	}

	public void setSmoName(String smoName) {
		this.smoName = smoName;
	}

	public String getSmoOkatoId() {
		return smoOkatoId;
	}

	public void setSmoOkatoId(String smoOkatoId) {
		this.smoOkatoId = smoOkatoId;
	}

	public Integer getPersonGender() {
		return personGender;
	}

	public void setPersonGender(Integer personGender) {
		this.personGender = personGender;
	}

	public String getPersonAge() {
		return personAge;
	}

	public void setPersonAge(String personAge) {
		this.personAge = personAge;
	}

	public String getMoCode() {
		return moCode;
	}

	public void setMoCode(String moCode) {
		this.moCode = moCode;
	}

	public String getMoId() {
		return moId;
	}

	public void setMoId(String moId) {
		this.moId = moId;
	}

	public String getMoName() {
		return moName;
	}

	public void setMoName(String moName) {
		this.moName = moName;
	}

	public String getMoOkato() {
		return moOkato;
	}

	public void setMoOkato(String moOkato) {
		this.moOkato = moOkato;
	}

	public String getFmoId() {
		return fmoId;
	}

	public void setFmoId(String fmoId) {
		this.fmoId = fmoId;
	}

	public Integer getAttachType() {
		return attachType;
	}

	public void setAttachType(Integer attachType) {
		this.attachType = attachType;
	}

	public Integer getAttachDepartType() {
		return attachDepartType;
	}

	public void setAttachDepartType(Integer attachDepartType) {
		this.attachDepartType = attachDepartType;
	}

	public Integer getAttachMethod() {
		return attachMethod;
	}

	public void setAttachMethod(Integer attachMethod) {
		this.attachMethod = attachMethod;
	}

	public LocalDate getAttachEffDate() {
		return attachEffDate;
	}

	public void setAttachEffDate(LocalDate attachEffDate) {
		this.attachEffDate = attachEffDate;
	}

	public LocalDate getAttachExpDate() {
		return attachExpDate;
	}

	public void setAttachExpDate(LocalDate attachExpDate) {
		this.attachExpDate = attachExpDate;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorSnils() {
		return doctorSnils;
	}

	public void setDoctorSnils(String doctorSnils) {
		this.doctorSnils = doctorSnils;
	}

	public LocalDate getDoctorEffDate() {
		return doctorEffDate;
	}

	public void setDoctorEffDate(LocalDate doctorEffDate) {
		this.doctorEffDate = doctorEffDate;
	}

	public String getAttachStatus() {
		return attachStatus;
	}

	public void setAttachStatus(String attachStatus) {
		this.attachStatus = attachStatus;
	}
	
}
