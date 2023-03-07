package ru.tfoms.asyncoperationsservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MPI_GET_VIEW_DATA_INSUR_POLL", schema = "OMCOWNER")
public class InsurancePoll {
	@Id
	@Column(name = "rid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
	@SequenceGenerator(name = "id_sequence", sequenceName = "OMCOWNER.MPI_SEQ", allocationSize = 1)
	private Long rid;
	
	@Column(name = "rid_start")
	private Long parentRid;
	
	@Column(name = "dt_ins")
	private LocalDateTime dtIns;
	
	@Column(name = "optoken")
	private String opToken;
	
	@Column(name = "dt_req")
	private LocalDateTime dtreq;
	
	@Column(name = "err")
	private Boolean hasError;
	
	@Column(name = "proc_status")
	private String status;
	
	@Column(name = "extrid")
	private String extrid;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getParentRid() {
		return parentRid;
	}

	public void setParentRid(Long parentRid) {
		this.parentRid = parentRid;
	}

	public LocalDateTime getDtIns() {
		return dtIns;
	}

	public void setDtIns(LocalDateTime dtIns) {
		this.dtIns = dtIns;
	}

	public String getOpToken() {
		return opToken;
	}

	public void setOpToken(String opToken) {
		this.opToken = opToken;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExtrid() {
		return extrid;
	}

	public void setExtrid(String extrid) {
		this.extrid = extrid;
	}
}
