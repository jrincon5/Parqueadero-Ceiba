package co.com.ceiba.julian.parqueadero.Parqueadero.modelo;

import static org.mockito.Matchers.intThat;

import java.util.ArrayList;
import java.util.Calendar;

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

    public boolean ingresarCarro(String placa, int cc, String propietario){
        if(celdasCarro.size()<=20){
            if(placa.startsWith("A")){
                if(Calendar.DAY_OF_WEEK!=0 && Calendar.DAY_OF_WEEK!=1){
                    System.out.print("No esta autorizado a ingresar");
                    return false;
                }
            }
            Fecha f = new Fecha(Calendar.getInstance());
            Carro c = new Carro(placa,cc,propietario);
            Celda celda = new Celda(c,f);
            celdasCarro.add(celda);
            System.out.print("Ingreso un carro:");
            return true;
        }else{
            System.out.print("Parqueadero lleno");
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

    public String generarCobro(int HEntrada, int DEntrada){
        int totalPagar=0;
        if (Calendar.HOUR_OF_DAY-HEntrada<9){
            totalPagar=8000;
        }else {
            totalPagar = (Calendar.DAY_OF_WEEK - HEntrada) * 1000;
        }

        return "Total a pagar: "+totalPagar;
    }
    
    /*public int calcularHorasTotales(int HEntrada, int DEntrada, int HSalida, int DSalida) {
    	boolean diaNoIgual=true;
    	boolean horaNoIgual=true;
    	int totalHoras=0;
    	
    	for(int i=DEntrada; ((i<7) && (diaNoIgual)); i++) {
    		
    		for(int j=HEntrada; (j<24) && (horaNoIgual); j++) {
    			totalHoras++;
    			
    			if(j==HSalida) horaNoIgual==false;
    			
    		}
    	}
    	
    	return 0;
    }*/


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
