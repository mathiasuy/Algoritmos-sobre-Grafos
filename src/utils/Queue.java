package utils;

import java.util.ArrayList;

public class Queue {

	ArrayList<Nodo> nodos = new ArrayList<>();
	
	public Queue() {}
	
	public void enqueue(Nodo s) {
		this.nodos.add(s);
	}
	
	public Nodo dequeue() {
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

}
