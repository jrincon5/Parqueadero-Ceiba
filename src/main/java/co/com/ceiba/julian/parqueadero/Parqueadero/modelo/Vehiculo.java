package co.com.ceiba.julian.parqueadero.Parqueadero.modelo;

import javax.persistence.Entity;

@Entity
public class Vehiculo {
	
	private String placa;
    private int cc;
    private String propietario;	
    
    public Vehiculo(String placa, int cc, String propietario) {
        this.placa = placa;
        this.cc = cc;
        this.propietario = propietario;
    }

	public String getPlaca() {
	    return placa;
	}
	
	public void setPlaca(String placa) {
	    this.placa = placa;
	}
	
	public int getCc() {
	    return cc;
	}
	
	public void setCc(int cc) {
	    this.cc = cc;
	}
	
	public String getPropietario() {
	    return propietario;
	}
	
	public void setPropietario(String propietario) {
	    this.propietario = propietario;
	}

}