package com.gekkobt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TYPE_OCCURRENCE")
public class TypeOccurrenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_TYPE", precision = 0)
	private Long id;

	@Column(name = "OCCURRENCE_TYPE")
	private String occurenceType;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "OCCURRENCE_TYPE")
	private List<OccurrenceEntity> typeoccurrence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOccurenceType() {
		return occurenceType;
	}

	public void setOccurenceType(String occurenceType) {
		this.occurenceType = occurenceType;
	}

	public List<OccurrenceEntity> getTypeoccurrence() {
		return typeoccurrence;
	}

	public void setTypeoccurrence(List<OccurrenceEntity> typeoccurrence) {
		this.typeoccurrence = typeoccurrence;
	}

}
