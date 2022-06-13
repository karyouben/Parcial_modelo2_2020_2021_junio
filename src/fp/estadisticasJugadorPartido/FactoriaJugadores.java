package fp.estadisticasJugadorPartido;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaJugadores {
	
	
	public static List<Jugador> leeJugadores(String fichero){
		Checkers.checkNoNull(fichero);
		List<String> lineas=Ficheros.leeFichero("Error al leer el fichero", fichero);
		lineas.remove(0);
		
		List<Jugador> res=new ArrayList<Jugador>();
		for(String linea:lineas) {
			Jugador j=parseaJugador(linea);
			res.add(j);
		}return res;
	}

	
	private static Jugador parseaJugador(String linea) {
		Checkers.checkNoNull(linea);
		String[] trozos=linea.split(",");
		Checkers.check("Formato no valido", trozos.length==11);
		LocalDate fecha=LocalDate.parse(trozos[0].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nombre=trozos[1].trim();
		Puesto puesto=Puesto.valueOf(trozos[2].trim().toUpperCase());
		String pais=trozos[3].trim();
		Duration tiempo=Duration.parse(trozos[4].trim());
		Integer tiros1=Integer.parseInt(trozos[5].trim());
		Integer tiros2=Integer.parseInt(trozos[6].trim());
		Integer tiros3=Integer.parseInt(trozos[7].trim());
		Integer puntos1=Integer.parseInt(trozos[8].trim());
		Integer puntos2=Integer.parseInt(trozos[9].trim());
		Integer puntos3=Integer.parseInt(trozos[10].trim());
		return new Jugador(fecha, nombre, puesto, pais, tiempo, tiros1, tiros2, tiros3, puntos1, puntos2, puntos3);
	}

}
