package com.navigrad.m2m.server.gps.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gpsdata")
public class GPSData extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "x")
	private Double x;

	@Column(name = "y")
	private Double y;

	@Column(name = "z")
	private Double z;

	@Column(name = "time")
	private Date time;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "transports_id")
	private Transport transport;

	public Long getId() {
		return id;
	}

	public Date getTime() {
		return time;
	}

	public Transport getTransport() {
		return transport;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getZ() {
		return z;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return super.toString() + "[time=" + time + ", x=" + x + ", y=" + y
				+ ", z=" + z + "]";
	}

}
