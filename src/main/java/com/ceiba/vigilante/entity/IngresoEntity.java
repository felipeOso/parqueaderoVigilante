package com.ceiba.vigilante.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "ingreso")
@NamedQueries({
@NamedQuery(name = "Ingreso.findByPlaca", query = "SELECT ingreso FROM Ingreso ingreso WHERE ingreso.vehiculo.placa = :id"),
@NamedQuery( name ="Ingreso.findAll", query = "SELECT i FROM Ingreso i"),
@NamedQuery( name= "Ingreso.parking", query = "SELECT i FROM Ingreso i WHERE ingreso.vehiculo.horaSalida = null")})
@XmlRootElement
public class IngresoEntity implements Serializable {

	private static final long serialVersionUID = 9107334415907063147L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_vehiculo",referencedColumnName="id")
	private VehiculoEntity vehiculo;

	@Column(name = "total_pagar")
	private double totalPagar;

	@Column(name = "horaIngreso", nullable = false)
	private LocalDateTime horaIngreso;

	@Column(name = "hora_salida")
	private LocalDateTime horaSalida;
	
	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
}
