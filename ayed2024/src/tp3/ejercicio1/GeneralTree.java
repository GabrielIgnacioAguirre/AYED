package tp3.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
			
		return 0;
	}
	
	public int nivel(T dato){
		return 0;
	  }

	public int ancho(){
		
		return 0;
	}
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,
			Integer n){
		if (!a.isEmpty() && a != null){
			List<Integer> l = new ArrayList<Integer>();
			ImparesMayoresQuePreOrden(a,n,l);
		}
		
		return null;
	}
	private void ImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n,List<Integer> l) {
		if (a.getData() > n && a.getData() % 2 != 0){
			l.add(a.getData());
		}
		for (GeneralTree<Integer> child: a.getChildren()) {
			ImparesMayoresQuePreOrden(child,n,l);
		}
	}
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,
			Integer n){
		List<Integer> l = new ArrayList<Integer>();
		if (!a.isEmpty() && a != null){
			ImparesMayoresQueInOrden(a,n,l);
		}
		
		return null;
	}
	private void ImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n,List<Integer> l) {

		for (GeneralTree<Integer> child: a.getChildren()) {
			ImparesMayoresQueInOrden(child,n,l);
			if (a.getData() > n && a.getData() % 2 != 0){
				l.add(a.getData());
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,
			Integer n){
		List<Integer> l = new ArrayList<Integer>();
		if (!a.isEmpty() && a != null){
			ImparesMayoresQuePostOrden(a,n,l);
		}
		
		return null;
	}
	private void ImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n,List<Integer> l) {

		for (GeneralTree<Integer> child: a.getChildren()) {
			ImparesMayoresQuePostOrden(child,n,l);
			}
		if (a.getData() > n && a.getData() % 2 != 0){
			l.add(a.getData());
		}
	}
}
