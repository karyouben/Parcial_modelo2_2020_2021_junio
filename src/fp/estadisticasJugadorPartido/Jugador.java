package fp.estadisticasJugadorPartido;

import java.time.Duration;
import java.time.LocalDate;

//al ser un record esta implementado ya el criterio de igualdad, el to string y el constructor por defecto de sus atributos basicos
public record Jugador(LocalDate fecha,String nombre,Puesto puesto,String pais,Duration tiempo,
		Integer tiros1,Integer tiros2,Integer tiros3,Integer puntos1,Integer puntos2,Integer puntos3) implements Comparable<Jugador> {
	

	
	public int compareTo(Jugador o) {
		int res=this.nombre().compareTo(o.nombre());
		if(res==0) {
			res=this.fecha().compareTo(o.fecha());
		}return res;
	}
	
	public Integer tirosTotales() {
		return tiros1()+tiros2()+tiros3();
	}
	
	public Integer puntosTotales() {
		return puntos1()+puntos2()+puntos3();
	}

}
