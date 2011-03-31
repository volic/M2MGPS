package com.navigrad.m2m.server.gps.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tracks")
public class Track extends AbstractEntity {

//	@Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;

	@ManyToOne
	@JoinColumn(name = "transports_id")
	private Transport transport;

	@OneToMany(mappedBy = "track")
	private List<GPSData> gpsDatas;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public List<GPSData> getGpsDatas() {
		return gpsDatas;
	}

	public void setGpsDatas(List<GPSData> gpsDatas) {
		this.gpsDatas = gpsDatas;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

}
