package testEstadisticasJugadorPartido;

import java.util.List;

import fp.estadisticasJugadorPartido.FactoriaJugadores;
import fp.estadisticasJugadorPartido.Jugador;

public class TestFactoriaJugadores {

	public static void main(String[] args) {
		testLeeFichero("data/Jugadores.csv");

	}

	private static void testLeeFichero(String fichero) {
		System.out.println("\nTestLeeFichero ==========");
		List<Jugador> jugadores=FactoriaJugadores.leeJugadores(fichero);
		System.out.println(" Jugador: ");
		for(Jugador j:jugadores) {
			System.out.println(j);
		}
		
		
	}

}
