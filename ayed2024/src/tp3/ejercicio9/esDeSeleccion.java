package tp3.ejercicio9;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class esDeSeleccion {
	
	public static boolean esDeSeleccionEjemplo (GeneralTree<Integer> arbol) {
	Queue<GeneralTree<Integer>> c = new Queue<GeneralTree<Integer>>();
	GeneralTree<Integer> a;
	c.enqueue(arbol);
	c.enqueue(null);
	boolean condicion = true;
	while (!c.isEmpty() && condicion){
		a = c.dequeue();
		if (a != null){
			if (a.hasChildren()) {
				int min = Integer.MAX_VALUE;
				for (GeneralTree<Integer> child: a.getChildren()) {
					c.enqueue(child);
					min = Math.min(min, child.getData());
				}
				if (min != a.getData()) {
					condicion = false;
				}
			}
		}
		else {
			if (!c.isEmpty()) {
				c.enqueue(null);
			}
		}
	}
	return condicion;
	}
	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(2));
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(31, children3);
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1);
		children.add(a2);
		children.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(1, children);
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccionEjemplo(a));
	}  
}