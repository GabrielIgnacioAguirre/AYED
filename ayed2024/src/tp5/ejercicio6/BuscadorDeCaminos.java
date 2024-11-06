package tp5.ejercicio6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.*;

public class BuscadorDeCaminos {
	private Graph<String> bosque;
	
	public List < List <String>> recorridosMasSeguro(){
		List<List<String>> lista_caminos = new LinkedList<>();
		List<String> camino = new LinkedList<>();
		if (!bosque.isEmpty()) {
			Vertex<String> inicio = bosque.search("Casa caperucita");
			if (inicio != null) {
				boolean [] marcas = new boolean[bosque.getSize()];
				recorridosMasSeguro(lista_caminos,camino,inicio,marcas);
			}
		}
		return lista_caminos;
	}
	private boolean recorridosMasSeguro(List<List<String>> lc,List<String>c,Vertex<String> v,boolean [] marcas) {
		boolean ok=false;
		marcas[v.getPosition()]=true;
		c.add(v.getData());
		if (v.getData()=="Casa Abuelita"){
			lc.add(c);
			c.removeAll(c);
		}
		else {
			Iterator<Edge<String>> it = bosque.getEdges(v).iterator();
			while (it.hasNext() && !ok) {
				Edge<String> e = it.next();
				Vertex<String> aux = e.getTarget();
				if ( !marcas[aux.getPosition()] && e.getWeight() > 5) {
					ok = recorridosMasSeguro(lc, c, v, marcas);
				}
			}
		}
		if (!ok) {
			c.remove(c.size()-1);
		}
		marcas[v.getPosition()]=false;
		return ok;
	}
	
	private void recorridoMasSeguro(List<List<String>> lc,List<String>c,Vertex<String> v,boolean [] marcas) {
		marcas[v.getPosition()]=true;
		c.add(v.getData());
		if (v.getData()=="Casa Abuelita"){
			lc.add(c);
			c.removeAll(c);
		}
		else {
			for (Edge<String> e: bosque.getEdges(v)) {
				Vertex<String> aux = e.getTarget();
				if ( !marcas[aux.getPosition()] && e.getWeight() > 5) {
					recorridosMasSeguro(lc, c, aux, marcas);
				}
			}
		}
		c.remove(c.size()-1);
		marcas[v.getPosition()]=false;
	}
}
