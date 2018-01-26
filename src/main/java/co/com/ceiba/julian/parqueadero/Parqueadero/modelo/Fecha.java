package co.com.ceiba.julian.parqueadero.Parqueadero.modelo;

import java.util.Calendar;

public class Fecha {
    private int dia;
    private int hora;

    public Fecha(Calendar fecha) {
        this.dia = fecha.get(Calendar.DAY_OF_WEEK);
        this.hora = fecha.get(Calendar.HOUR_OF_DAY);
    }

    public String getDiaActual(Calendar fecha){
        switch (fecha.get(Calendar.DAY_OF_WEEK)) {
            case 1: return "Domingo";
            case 2: return "Lunes";
            case 3: return "Martes";
            case 4: return "Miercoles";
            case 5: return "Jueves";
            case 6: return "Viernes";
            case 7: return "Sabado";
            default: return"";
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
}
