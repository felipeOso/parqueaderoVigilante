package dominio.unitaria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ceiba.vigilante.dominio.Ingreso;
import com.ceiba.vigilante.dominio.Vehiculo;
import com.ceiba.vigilante.service.VigilanteServiceImpl;

import testdatabuilder.IngresoTestDataBuilder;
import testdatabuilder.VehiculoTestDataBuilder;

public class VigilanteTest {

	private VigilanteServiceImpl vigilanteService;
	
	@Test
	public void ValidarPlacaTest() {
		// Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		IngresoTestDataBuilder ingresoTestDataBuilder = new IngresoTestDataBuilder(vehiculo);
		Ingreso ingreso = ingresoTestDataBuilder.build();
		// Act
		boolean validar =vigilanteService.validarPlaca(ingreso);
		
		// Assert
		assertFalse(validar);

		
	}
}
