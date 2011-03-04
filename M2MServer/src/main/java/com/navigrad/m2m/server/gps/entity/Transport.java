package com.navigrad.m2m.server.gps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transports")
public class Transport extends AbstractEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "imei")
	private String imei;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "users_id")
	private User user;

	@OneToMany(mappedBy = "transport")
	private List<GPSData> gpsDatas;

	public List<GPSData> getGpsDatas() {
		return gpsDatas;
	}

	public Long getId() {
		return id;
	}

	public String getImei() {
		return imei;
	}

	public String getName() {
		return name;
	}

	public User getUser() {
		return user;
	}

	public void setGpsDatas(List<GPSData> gpsDatas) {
		this.gpsDatas = gpsDatas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return super.toString() + "[imei=" + imei + ", name=" + name + "]";
	}

}
