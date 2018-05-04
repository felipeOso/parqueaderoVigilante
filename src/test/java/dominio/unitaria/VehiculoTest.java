package dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ceiba.vigilante.dominio.Vehiculo;


import testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	private static final String PLACA ="abc123";
	private static final String TIPO_VEHICULO="Moto";
	
	@Test
	public void CrearVehiculoTest() {
		
	//SEGUIMOS EL PATRON AAA Arrange/Act/Assert una prueba para mirar jenkins
		
		
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().
				conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO);
		
		//Act
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		
		//Assert
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(TIPO_VEHICULO, vehiculo.getTipoVehiculo());
	}
}
