package tp5.ejercicio4;

import java.rmi.Remote;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {
	public List<String> paseoEnBici(Graph<String> lugares, String destino,  int maxTiempo, List<String> lugaresRestringidos) {
		List<String> camino = new LinkedList<>();
		if (lugares.isEmpty()) {
			Vertex ver1 = lugares.search("Ayuntamiento");
			Vertex ver2 = lugares.search(destino);
			if (ver1 != null && ver2 != null) {
				boolean [] marca = new boolean [lugares.getSize()];
				paseoEnBici(lugares,camino,lugaresRestringidos,ver1,ver2,maxTiempo,marca);
			}
		}
		return null;
	}
	
	private boolean paseoEnBici(Graph<String> lugares,List<String> camAct,List<String> camRes, Vertex destino, Vertex<String> inicio,  int maxTiempo,boolean [] marca){
		boolean ok = false;
		marca[inicio.getPosition()]=true;
		camAct.add(inicio.getData());
		if (inicio.equals(destino)) {
			return true;
		}
		else {
			Iterator<Edge<String>> it = lugares.getEdges(inicio).iterator();
			while (it.hasNext() && !ok) {
				Vertex aux = it.next().getTarget();
				int peso = it.next().getWeight();
				if ( !marca[aux.getPosition()]) {
					if (!camRes.contains(aux.getData()) && (maxTiempo - peso >= 0)){
						ok = paseoEnBici(lugares, camAct, camRes, destino, aux, maxTiempo-peso, marca);
					}
				}
			}
		}
		if (!ok) {
			camAct.remove(camAct.size()-1);
		}
		marca[inicio.getPosition()] = false;
		return ok;
	}
		 
		 
}
