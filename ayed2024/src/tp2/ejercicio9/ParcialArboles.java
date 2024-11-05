package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
	public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Objeto> ab = null;
		if (!arbol.isEmpty()) {
			sumAndDif(arbol, ab = new BinaryTree<>(),0,0);
		}
		return ab;
	}
	public void sumAndDif(BinaryTree<Integer> arbol,
			BinaryTree<Objeto> ab,int suma, int dataPadre) {
		ab.setData(new Objeto(arbol.getData(),suma, dataPadre));
		
		if (arbol.hasLeftChild()) {
			ab.addLeftChild(new BinaryTree<Objeto>());
			sumAndDif(arbol.getLeftChild(),
					ab.getLeftChild(), arbol.getData()+dataPadre,arbol.getData());
		}
		if (arbol.hasRightChild()) {
			ab.addRightChild(new BinaryTree<Objeto>());
			sumAndDif(arbol.getRightChild(),
					ab.getRightChild(), arbol.getData()+dataPadre, arbol.getData());
		}
	}
    public static void main(String[] args) {
        System.out.println("Test Ejercicio9");
        ParcialArboles parcialArb = new ParcialArboles();
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(20);
        ab.addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(10));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.addRightChild(new BinaryTree<Integer>(30));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(50));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(-9));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild(). getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
        
        ab.entreNiveles(0, 4);
        System.out.println();
        System.out.println("Nuevo arbol:");
        parcialArb.sumAndDif(ab).entreNiveles(0, 4);
    }
}

