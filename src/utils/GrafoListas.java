package utils;

import java.util.ArrayList;

public class GrafoListas {
	
	private ArrayList<Nodo> nodos = new ArrayList<>();
	
	private int iterador = 0;
	
	public ArrayList<Nodo> getNodos(){
		return this.nodos;
	}
	
	public GrafoListas() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(Nodo n) {
		this.nodos.add(n);
	}
	
	public Nodo next() {
		if (iterador >= this.nodos.size()) {
			iterador = 0;
			return null;
		}
		Nodo n = nodos.get(iterador);
		iterador++;
		return n;
	}
	
	public boolean end() {
		return iterador < nodos.size();
	}

	public void start() {
		iterador = 0;
	}
	
}