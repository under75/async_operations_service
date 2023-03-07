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
	
	@Column(name = "PERS_ENP")
	private String personEnp;
}
