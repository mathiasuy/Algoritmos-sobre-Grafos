package utils;

import java.util.ArrayList;

public class Pila {

	ArrayList<Nodo> nodos = new ArrayList<>();
	
	public Pila() {}
	
	public void apilar(Nodo n) {
		this.nodos.add(0,n);
	}
	
	public Nodo desapilar() {
		Nodo r = null;
		if (this.nodos.size() > 0) {
			r = this.nodos.get(0);
			this.nodos.remove(0);
		}
		return r;
	}
	
	public boolean isEmpty() {
			return this.nodos.isEmpty();
	}

	public void print() {
		this.nodos.forEach((c)->{
			System.out.println("(" + c.id + ")-");
		});
	}

	public Nodo top() {
		Nodo r = null;
		if (this.nodos.size() > 0) {
			r = this.nodos.get(0);
		}
		return r;
	}
}
