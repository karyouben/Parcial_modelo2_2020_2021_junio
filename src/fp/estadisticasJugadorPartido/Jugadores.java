package fp.estadisticasJugadorPartido;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jugadores {
	private List<Jugador> jugadores;
	
	public Jugadores() {
		jugadores=new ArrayList<>();
	}
	
	public Jugadores(Stream<Jugador> jugadores) {
		this.jugadores=jugadores.collect(Collectors.toList());
	}
	
	public Jugadores(List<Jugador> jugadores) {
		this.jugadores=new ArrayList<Jugador>(jugadores);
	}
	
	public Jugadores(Collection<Jugador> jugadores) {
		this.jugadores=new ArrayList<Jugador>(jugadores);
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(jugadores);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugadores other = (Jugadores) obj;
		return Objects.equals(jugadores, other.jugadores);
	}

	@Override
	public String toString() {
		return "Jugadores [jugadores=" + jugadores + "]";
	}
	
	//ejercicio 1
	
	public Boolean hayAlgunJugadorHayaMetidoPorcentajeDeTirosDe1PuntoMayorQueR(LocalDate fecha,Double r) {
		return jugadores.stream()
				.filter(j->j.fecha().equals(fecha) && j.tiros1()>0)
				.anyMatch(j->j.puntos1()*100./j.tiros1()>r);
		
	}
	
	//ejercicio 2
	
	public Double mediaPuntosConseguidosJugadoresPorNombre(Character s) {
		return jugadores.stream()
				.filter(j->j.nombre().charAt(0)==s)
				.mapToInt(Jugador::puntosTotales)
				.average()
				.getAsDouble();
	}
	
	//ejercicio 3
	
	public Map<String,SortedSet<Duration>> duracionesPorPais(){
		return jugadores.stream()
				.collect(Collectors.groupingBy(Jugador::pais,Collectors.collectingAndThen(Collectors.toCollection(TreeSet::new), lista->listaOrdenadaDuracion(lista))));
	}

	private SortedSet<Duration> listaOrdenadaDuracion(Set<Jugador> lista) {
		return lista.stream()
				.sorted(Comparator.comparing(Jugador::tiempo).reversed())
				.map(Jugador::tiempo)
				.collect(Collectors.toCollection(TreeSet::new));
	}
	
	public Map<String,SortedSet<Duration>> duracionesPorPais2(){
		Map<String,SortedSet<Duration>> res=new HashMap<>();
		for(Jugador j:jugadores) {
			String clave=j.pais();
			if(!res.containsKey(clave)) {
				SortedSet<Duration> conjunto=new TreeSet<>();
				conjunto.add(j.tiempo());
				res.put(clave, conjunto);
			}else {
				res.get(clave).add(j.tiempo());
			}
		}return res;
	}
	
	//ejercicio 4
	
	public List<String> listaDeLosNJugadoresMenosPuntosTirosLibres(Integer anyo,Integer n){
		return jugadores.stream()
				.filter(j->j.fecha().getYear()==anyo)
				.sorted(Comparator.comparing(Jugador::puntos1))
				.map(Jugador::nombre)
				.distinct()
				.limit(n)
				.collect(Collectors.toList());
	}
	
	public List<String> listaDeLosNJugadoresMenosPuntosTirosLibres2(Integer anyo,Integer n){
		Map<String,Integer> m= jugadores.stream().filter(j->j.fecha().getYear()==anyo)
				.collect(Collectors.groupingBy(Jugador::nombre,Collectors.summingInt(Jugador::puntos1)));
		Comparator<Map.Entry<String, Integer>> c=Comparator.comparing(Map.Entry::getValue);
		return m.entrySet().stream()
				.sorted(c)
				.map(j->j.getKey())
				.limit(n)
				.collect(Collectors.toList());
	}
	
	//ejercicio 5
	
	public Map<String,List<String>> listaNombresPorPaisOrdenadosPorTiempo(){
		return jugadores.stream()
				.collect(Collectors.groupingBy(Jugador::pais,Collectors.collectingAndThen(Collectors.toList(), lista->listaNombreOrdenados(lista))));
	}
	
	private List<String> listaNombreOrdenados(List<Jugador>lista){
		return lista.stream()
				.sorted(Comparator.comparing(Jugador::tiempo).reversed())
				.map(Jugador::nombre)
				.collect(Collectors.toList());
				
	}
	
	//ejercicio 6
	
	public Integer numeroDeJugadoresConMasDeNPuntos(Integer n) {
		Map<String,Integer> m =puntosTotalesPorJugador(n);
		return m.entrySet().stream()
				.filter(j->j.getValue()>n)
				.map(j->j.getKey())
				.collect(Collectors.collectingAndThen(Collectors.counting(), j->j.intValue()));
	}
	
	private Map<String,Integer> puntosTotalesPorJugador(Integer n){
		return jugadores.stream()
				.collect(Collectors.groupingBy(Jugador::nombre,Collectors.summingInt(Jugador::puntosTotales)));
		
	}
	


}
