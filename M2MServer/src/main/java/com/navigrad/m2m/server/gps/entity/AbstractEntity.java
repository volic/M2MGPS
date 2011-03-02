package com.navigrad.m2m.server.gps.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable, Cloneable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "del")
	private Boolean deleted;

	public Boolean isDeleted() {
		return deleted;
	}

	public Long getId() {
		return id;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getClass().getName() + " id = " + id;
	}

}
