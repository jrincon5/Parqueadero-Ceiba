package co.com.ceiba.julian.parqueadero.Parqueadero.modelo;


public class Celda {
    private Carro carro;
    private Fecha fecha;

    public Celda(Carro carro, Fecha fecha) {
        this.carro = carro;
        this.fecha = fecha;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
