package com.ceiba.vigilante.dominio;

import java.time.LocalDateTime;

public class Ingreso {

	private Vehiculo vehiculo;
	private double totalPagar;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaSalida;

	public Ingreso(Vehiculo vehiculo) {
		super();
		this.vehiculo = vehiculo;
		this.horaIngreso = LocalDateTime.now();
	}
	
	public Ingreso() {}
	
	public Ingreso(Vehiculo vehiculo,LocalDateTime horaIngreso, double totalPagar, LocalDateTime horaSalida) {
	   super();
	   this.vehiculo =vehiculo;
	   this.horaIngreso = horaIngreso;
	   this.totalPagar = totalPagar;
	   this.horaSalida = horaSalida;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
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

	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}

}
