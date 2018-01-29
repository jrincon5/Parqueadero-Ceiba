package co.com.ceiba.julian.parqueadero.Parqueadero.modelo;

import static org.mockito.Matchers.intThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Parqueadero {
    private ArrayList<Celda> celdasCarro = new ArrayList<>();
    private ArrayList<Celda> celdasMoto = new ArrayList<>();
    
    public ArrayList<Celda> getCeldasCarro() {
        return celdasCarro;
    }

    public void setCeldasCarro(ArrayList<Celda> celdasCarro) {
        this.celdasCarro = celdasCarro;
    }

    public ArrayList<Celda> getCeldasMoto() {
        return celdasMoto;
    }

    public void setCeldasMoto(ArrayList<Celda> celdasMoto) {
        this.celdasMoto = celdasMoto;
    }
    
    public Fecha getFechaActual() {
    	Calendar Cal = Calendar.getInstance();
    	int año=Cal.get(Calendar.YEAR);
    	int mes=Cal.get(Calendar.MONTH);
    	int diaMes=Cal.get(Calendar.DAY_OF_MONTH);
    	int horaDia=Cal.get(Calendar.HOUR_OF_DAY);
    	int minuto=Cal.get(Calendar.MINUTE);
    	return new Fecha(año,mes,diaMes,horaDia,minuto);
    }

    public boolean ingresarCarro(String placa, int cc, String propietario){
        if(celdasCarro.size()<=20){
            if(placa.startsWith("A")){
                if(Calendar.DAY_OF_WEEK!=0 && Calendar.DAY_OF_WEEK!=1){
                    //System.out.print("No esta autorizado a ingresar");
                    return false;
                }
            }
            Fecha f = getFechaActual();
            Carro c = new Carro(placa,cc,propietario);
            Celda celda = new Celda(c,f);
            celdasCarro.add(celda);
            //System.out.print("Ingreso un carro:");
            return true;
        }else{
            //System.out.print("Parqueadero lleno");
        }
        return false;
    }

    public boolean sacarCarro(String placa){
        for(int i=0;i<celdasCarro.size();i++){
            if(celdasCarro.get(i).getCarro().getPlaca().equals(placa)){
                //generarCobro(celdasCarro.get(i).getFecha().getHora(),Calendar.HOUR_OF_DAY);
            	celdasCarro.remove(i);
            	return true;
            }
        }
        return false;
    }

    //Metodo que calcula el total a pagar
    public int generarCobro(Fecha fechaEntrada, Fecha fechaSalida){
        int horasTotales=(int)calcularHorasTotales(fechaEntrada, fechaSalida);
        int diasAPagar = horasTotales / 24;
        int horasAPagar=0;
        if((horasTotales % 24)>=9 && (horasTotales % 24)<=23) {
        	diasAPagar++;
        }else {
        	horasAPagar = horasTotales % 24;
        }        
        int totalAPagar=(diasAPagar*8000)+(horasAPagar*1000);
        return totalAPagar;
    }
    
    //Metodo que calcula la diferencia entre dos fechas y la devuelve en horas
    public long calcularHorasTotales(Fecha entrada, Fecha salida) {
    	Date d1=entrada.getTime();
    	Date d2=salida.getTime();
    	long dif=(d2.getTime()-d1.getTime()) / (1000 * 60 * 60);
    	if((d2.getTime()-d1.getTime()) % (1000 * 60 * 60)!=0) dif++;
    	//System.out.println("Horas: "+(d2.getTime()-d1.getTime()) / (1000 * 60 * 60));
    	//System.out.println("Modulo: "+(d2.getTime()-d1.getTime()) % (1000 * 60 * 60));
    	return dif;
    }

    /*public boolean ingresarMoto(String placa, int cc, String propietario){
        if(celdasMoto.size()<=20){
            Moto m = new Moto(placa,cc,propietario);
            celdasMoto.add(m);
            System.out.print("Ingreso una moto");
            return true;
        }else{
            System.out.print("Parqueadero lleno");
        }
        return false;
    }*/
}
