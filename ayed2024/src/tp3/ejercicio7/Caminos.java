package tp3.ejercicio7;

import java.util.ArrayList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> ag;
	
	public Caminos(GeneralTree<Integer> a) {
		this.ag = a;
	}
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> l = new ArrayList<Integer>();
		if (!this.ag.isEmpty()) {
			List<Integer> lAct = new ArrayList<Integer>();
			hojaMasLejana(this.ag,l, lAct);
		}
		return l;
	}
	public void hojaMasLejana(GeneralTree<Integer> a,List<Integer> l, List<Integer> lAct) {
		lAct.add(a.getData());
		for (GeneralTree<Integer> child: a.getChildren()) {
			hojaMasLejana(child,l,lAct);
		}
		if (l.size() < lAct.size()) {
			l.removeAll(l);
			l.addAll(lAct);
		}
		lAct.remove(lAct.size()-1);
	}
	public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new ArrayList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new ArrayList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(10));
        subChildren2.add(subA);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new ArrayList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
        
        List<GeneralTree<Integer>> subChildren4 = new ArrayList<GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(16));
        subChildren4.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new ArrayList<GeneralTree<Integer>>();
        subChildren5.add(subB);
        subChildren5.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
        
        List<GeneralTree<Integer>> arbol = new ArrayList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
        
        Caminos cam = new Caminos(a);
        
        System.out.println("Camino a hoja mas lejana: " + cam.caminoAHojaMasLejana());
 }
}
