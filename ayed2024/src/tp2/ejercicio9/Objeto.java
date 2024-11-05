package tp2.ejercicio9;

public class Objeto {
	private int sum;
	private int diff;
	
	public Objeto(Integer dato, int suma, int dataPadre) {
		this.sum=dato+suma;
		this.diff=dato-dataPadre;
	}
	 @Override
	    public String toString() {
	        return "Sum=" + sum + " Dif=" + diff; 
	    }
	//getters y setters
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getDiff() {
		return diff;
	}
	public void setDiff(int diff) {
		this.diff = diff;
	}
	
	
}
