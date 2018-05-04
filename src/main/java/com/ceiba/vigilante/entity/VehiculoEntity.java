package com.ceiba.vigilante.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "vehiculo")
@NamedQueries({
@NamedQuery(name = "Vehiculo.findById", query = "SELECT vehiculo FROM Vehiculo vehiculo WHERE vehiculo.id = :id"),
@NamedQuery(name = "Vehiculo.findAll", query = "SELECT vehiculo FROM Vehiculo vehiculo")})
@XmlRootElement
public class VehiculoEntity implements Serializable {

	
	private static final long serialVersionUID = 5295977952059189391L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private String tipoVehiculo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
}
