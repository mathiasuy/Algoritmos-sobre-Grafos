package utils;

import java.util.ArrayList;

public class Nodos {

	ArrayList<Nodo> nodos = new ArrayList<>();
	
	public Nodos() {}
	
	public void add(Nodo n) {
		this.nodos.add(0,n);
	}
	
	public boolean isEmpty() {
			return this.nodos.isEmpty();
	}

	public void print() {
		this.nodos.forEach((c)->{
			System.out.println("(" + c.id + ")-");
		});
	}
}
