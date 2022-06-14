package testEstadisticasJugadorPartido;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import fp.estadisticasJugadorPartido.FactoriaJugadores;
import fp.estadisticasJugadorPartido.Jugador;
import fp.estadisticasJugadorPartido.Jugadores;

public class TestJugadores {

	public static void main(String[] args) {
		List<Jugador> jugadores=FactoriaJugadores.leeJugadores("data/Jugador.csv");
		Jugadores j=new Jugadores(jugadores);
		System.out.println("\nTestHayAlgunJugadorHayaMetidoPorcentajeDeTirosDe1PuntoMayorQueR");
		System.out.println("=================================================================");
		testHayAlgunJugadorHayaMetidoPorcentajeDeTirosDe1PuntoMayorQueR(j,LocalDate.of(2006, 9, 16),3.2);
		System.out.println("\nTestMediaPuntosConseguidosJugadoresPorNombre");
		System.out.println("==============================================");
		testMediaPuntosConseguidosJugadoresPorNombre(j,'s');
		System.out.println("\nTestDuracionesPorPais");
		System.out.println("=======================");
		testDuracionesPorPais(j);
		System.out.println("\nTestDuracionesPorPais2");
		System.out.println("=======================");
		testDuracionesPorPais2(j);
		System.out.println("\nTestListaDeLosNJugadoresMenosPuntosTirosLibres");
		System.out.println("================================================");
		testListaDeLosNJugadoresMenosPuntosTirosLibres(j,2006,3);
		System.out.println("\nTestListaNombresPorPaisOrdenadosPorTiempo");
		System.out.println("================================================");
		testListaNombresPorPaisOrdenadosPorTiempo(j);
		System.out.println("\nTestNumeroDeJugadoresConMasDeNPuntos");
		System.out.println("================================================");
		testNumeroDeJugadoresConMasDeNPuntos(j,30);
		

	}



	private static void testHayAlgunJugadorHayaMetidoPorcentajeDeTirosDe1PuntoMayorQueR(Jugadores j, LocalDate fecha, Double r) {
		try {
			String msg=String.format("¿Hay algun jugador en la fecha %d Que haya metido un porcentaje de tiros mayor que " +r+ " ?"
					,fecha,r,j.hayAlgunJugadorHayaMetidoPorcentajeDeTirosDe1PuntoMayorQueR(fecha, r) );
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Excepcion capturada inesesperada " +e.getMessage());
		}
	}
	
	private static void testMediaPuntosConseguidosJugadoresPorNombre(Jugadores j, Character s) {
		try {
			String msg=String.format("La media de puntos conseguidos por jugadores que empiezan por la letra %d es: %s"
					,s,j.mediaPuntosConseguidosJugadoresPorNombre(s) );
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Excepcion capturada inesesperada " +e.getMessage());
		}
	}
	
	private static void testDuracionesPorPais(Jugadores j) {
		try {
			String msg=String.format("El conjunto de duraciones de partidos por pais es: ");
			System.out.println(msg);
			Map<String,SortedSet<Duration>> p=j.duracionesPorPais();
			p.entrySet().stream().forEach(System.out::println);
		}catch(Exception e) {
			System.err.println("Excepcion capturada inesesperada " +e.getMessage());
		}
	}
	
	private static void testDuracionesPorPais2(Jugadores j) {
		try {
			String msg=String.format("El conjunto de duraciones de partidos por pais es: ");
			System.out.println(msg);
			Map<String,SortedSet<Duration>> p=j.duracionesPorPais();
			p.entrySet().stream().forEach(System.out::println);
		}catch(Exception e) {
			System.err.println("Excepcion capturada inesesperada " +e.getMessage());
		}
	}
	
	private static void testListaDeLosNJugadoresMenosPuntosTirosLibres(Jugadores j,Integer anyo, Integer n) {
		try {
			String msg=String.format("La Lista de los %d jugadores del año "+anyo+" con menor puntos por tiros libres son: %s "
					,anyo,n,j.listaDeLosNJugadoresMenosPuntosTirosLibres(anyo, n) );
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Excepcion capturada inesesperada " +e.getMessage());
		}
	}
	
	private static void testListaNombresPorPaisOrdenadosPorTiempo(Jugadores j) {
		try {
			String msg=String.format("La lista de los nombres ordenados por tiempo en cada pais es: ");
			System.out.println(msg);
			Map<String,List<String>> p=j.listaNombresPorPaisOrdenadosPorTiempo();
			p.entrySet().stream().forEach(System.out::println);
		}catch(Exception e) {
			System.err.println("Excepcion capturada inesesperada " +e.getMessage());
		}
	}
	private static void testNumeroDeJugadoresConMasDeNPuntos(Jugadores j, Integer n) {
		try {
			String msg=String.format("El numero de jugadores con mas de %d puntos es: %s"
					,n,j.numeroDeJugadoresConMasDeNPuntos(n) );
			System.out.println(msg);
		}catch(Exception e) {
			System.err.println("Excepcion capturada inesesperada " +e.getMessage());
		}
	}
	

}
