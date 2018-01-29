package co.com.ceiba.julian.parqueadero.Parqueadero.modelo;

import java.util.Date;

public interface IParqueadero {
	static final int HORACARRO=1000;
    static final int HORAMOTO=500;
    static final int DIACARRO=8000;
    static final int DIAMOTO=4000;
    static final int MOTOALTOCILINDRAJE=2000;
	
	//Metodo que calcula la diferencia entre dos fechas y la devuelve en horas	
    public static long calcularHorasTotales(Fecha entrada, Fecha salida) {
    	Date d1=entrada.getTime();
    	Date d2=salida.getTime();
    	long dif=(d2.getTime()-d1.getTime()) / (1000 * 60 * 60);
    	if((d2.getTime()-d1.getTime()) % (1000 * 60 * 60)!=0) dif++;
    	//System.out.println("Horas: "+(d2.getTime()-d1.getTime()) / (1000 * 60 * 60));
    	//System.out.println("Modulo: "+(d2.getTime()-d1.getTime()) % (1000 * 60 * 60));
    	return dif;
    }
    
  //Metodo que calcula el total a pagar de los carros
    public static int generarCobroCarro(Fecha fechaEntrada, Fecha fechaSalida){
        int horasTotales=(int)calcularHorasTotales(fechaEntrada, fechaSalida);
        int diasAPagar = horasTotales / 24;
        int horasAPagar=0;
        if((horasTotales % 24)>=9 && (horasTotales % 24)<=23) {
        	diasAPagar++;
        }else {
        	horasAPagar = horasTotales % 24;
        }        
        int totalAPagar=(diasAPagar*DIACARRO)+(horasAPagar*HORACARRO);
        return totalAPagar;
    }
}
