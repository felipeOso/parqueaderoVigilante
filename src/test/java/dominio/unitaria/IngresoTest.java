package dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.dominio.Vehiculo;


import testdatabuilder.IngresoTestDataBuilder;

public class IngresoTest {

	public static final LocalDateTime HORA_INGRESO = LocalDateTime.now();
	public static final String TIPO_VEHICULO = "Moto";
	public static final String PLACA ="abc123";
	
	
	@Test
	public void crearIngreso() {
		
		//Arrange
		Vehiculo vehiculo = new Vehiculo(PLACA,TIPO_VEHICULO);
		IngresoTestDataBuilder ingresoTestDataBuilder = new IngresoTestDataBuilder(vehiculo);
		
		//Act
		Ingreso ingreso = ingresoTestDataBuilder.build();
		
		// Arrange
		
		assertEquals(PLACA, ingreso.getVehiculo().getPlaca());
		assertEquals(TIPO_VEHICULO, ingreso.getVehiculo().getTipoVehiculo());

	}
}
