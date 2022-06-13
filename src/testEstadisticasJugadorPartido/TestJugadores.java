package testEstadisticasJugadorPartido;

import java.util.List;

import fp.estadisticasJugadorPartido.FactoriaJugadores;
import fp.estadisticasJugadorPartido.Jugador;
import fp.estadisticasJugadorPartido.Jugadores;

public class TestJugadores {

	public static void main(String[] args) {
		List<Jugador> jugadores=FactoriaJugadores.leeJugadores("data/Jugador.csv");
		Jugadores j=new Jugadores(jugadores);
		System.out.println("\nTest");
		System.out.println("======================");

	}

}
