package ru.tfoms.asyncoperationsservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MPI_GET_VIEW_DATA_INSUR_START", schema = "OMCOWNER")
public class InsuranceStart {
	@Id
	@Column(name = "rid")
	private Long rid;

	@Column(name = "dt_ins")
	private LocalDateTime dtIns;

	@Column(name = "dt")
	private LocalDate dt;

	@Column(name = "usr")
	private String usr;

	@Column(name = "dt_req")
	private LocalDateTime dtreq;

	@Column(name = "err")
	private Boolean hasError;

	@Column(name = "optoken")
	private String opToken;
	
	@Column(name = "terr")
	private String terr;
	
	@Column(name = "smo")
	private String smo;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public LocalDateTime getDtIns() {
		return dtIns;
	}

	public void setDtIns(LocalDateTime dtIns) {
		this.dtIns = dtIns;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public LocalDateTime getDtreq() {
		return dtreq;
	}

	public void setDtreq(LocalDateTime dtreq) {
		this.dtreq = dtreq;
	}

	public Boolean getHasError() {
		return hasError;
	}

	public void setHasError(Boolean hasError) {
		this.hasError = hasError;
	}

	public String getOpToken() {
		return opToken;
	}

	public void setOpToken(String opToken) {
		this.opToken = opToken;
	}

	public String getTerr() {
		return terr;
	}

	public void setTerr(String terr) {
		this.terr = terr;
	}

	public String getSmo() {
		return smo;
	}

	public void setSmo(String smo) {
		this.smo = smo;
	}
}
