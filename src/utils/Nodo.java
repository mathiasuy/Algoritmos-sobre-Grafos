package utils;

import java.util.ArrayList;

public class Nodo {
	public int id;
	private ArrayList<Nodo> adyacentes = new ArrayList<>();
	private int iterador = 0;
	
	public ArrayList<Nodo> getAdyacentes(){
		return this.adyacentes;
	}
	
	public Nodo(int id) {
		this.id = id;
	}
	
	public void add(Nodo n) {
		this.adyacentes.add(n);
	}
	
	public Nodo next() {
		Nodo n = null;
		if (!adyacentes.isEmpty()) {
			if (iterador >= this.adyacentes.size()) {
				iterador = 0;
				return null;
			}
			n = adyacentes.get(iterador);
			iterador++;
		}
		return n;
	}
	
	public boolean end() {
		return iterador >= adyacentes.size() || adyacentes.isEmpty();
	}
	
	@Override
	public String toString() {
		return "(" + this.id + ")";
	}

	public void start() {
		iterador = 0;
	}
}