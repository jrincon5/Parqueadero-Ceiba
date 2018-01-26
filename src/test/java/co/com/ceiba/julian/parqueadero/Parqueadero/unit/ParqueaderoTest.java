package co.com.ceiba.julian.parqueadero.Parqueadero.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.julian.parqueadero.Parqueadero.modelo.Carro;
import co.com.ceiba.julian.parqueadero.Parqueadero.modelo.Celda;
import co.com.ceiba.julian.parqueadero.Parqueadero.modelo.Parqueadero;

public class ParqueaderoTest {
	 private Parqueadero park;
	 private Carro car;
	 
	@Before
	public void arrange() {
		park = new Parqueadero();
		car = new Carro("BSW04D",1000, "Julian Rincon");
	}
	
	@Test
	public void ingresarCarroTest() {
        assertTrue(park.ingresarCarro("BSW04D",1000, "Julian Rincon"));
    }
	
	@Test
	public void ingresarCarroConReglaMaravillosaTest() {
        assertFalse(park.ingresarCarro("ASW04D",1000, "Julian Rincon"));
    }
	
	@Test
    public void ingresarCarrosMaximosTest() {
        for(int i = 0; i< 30 ; i++) {
            park.ingresarCarro("WSW04D", 1000, "Julian Rincon");
        }
        assertFalse(park.ingresarCarro("WSW04D",1000, "Julian Rincon"));
    }
	
	@Test
	public void sacarCarroTest() {
		assertFalse(park.sacarCarro("WSW04D"));
	}

}
