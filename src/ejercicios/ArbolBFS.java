package ejercicios;

import java.util.ArrayList;

import utils.GrafoListas;
import utils.Nodo;
import utils.Nodos;
import utils.Queue;

public class ArbolBFS {

	public static void main(String[] args) {
		GrafoListas grafo = new GrafoListas();
		
		
		Nodo n0 = new Nodo(0);
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		Nodo n6 = new Nodo(6);
		Nodo n7 = new Nodo(7);
		Nodo n8 = new Nodo(8);
		grafo.add(n0);
		grafo.add(n1);
		grafo.add(n2);
		grafo.add(n3);
		grafo.add(n4);
		grafo.add(n5);
		grafo.add(n6);
		grafo.add(n7);
		grafo.add(n8);
		
		n0.add(n1);
		

		n1.add(n7);
		n1.add(n2);
		n1.add(n5);
		n1.add(n0);
		
		n2.add(n1);
		n2.add(n3);
		n2.add(n4);
		n2.add(n7);
		
		n3.add(n2);
		
		n4.add(n2);
		n4.add(n7);
		n4.add(n5);
		 
		n5.add(n6);
		n5.add(n1);
		n5.add(n4);
		
		n6.add(n5);
		
		n7.add(n1);
		n7.add(n2);
		n7.add(n4);

		boolean[] marcados = new boolean[9];
		int k = arbolBFS(n6);
		System.out.println("Cantidad de caminos mínimos: " + k);
	}

	
	
	public static int arbolBFS(Nodo v) {
		Nodos nivel[] = new Nodos[9];
		for (int i = 0; i < nivel.length; i++) {
			nivel[i] = new Nodos();
		}
		boolean visto[] = new boolean[9];
		visto[v.id] = true;
		nivel[0].add(v);
		int i = 0;
		q.enqueue(v);
		cantCaminos[v.id] = 1;
		while (!q.isEmpty()) {
			Nodo u = q.dequeue();
			for (Nodo w : u.getAdyacentes()) {
				if (nivel[w.id] < 1) {
					nivel[w.id] = nivel[u.id] + 1;
				}
				if (!marcados[w.id]) {
					marcados[w.id] = true;
					q.enqueue(w);
				}
				if (nivel[u.id] < nivel[w.id]) {//me fijo solo en los de nivel de arriba
					//sumo todos los caminos para llegar a cada uno de los de arriba
					cantCaminos[w.id] += cantCaminos[u.id];
				}
			}
		}
		return cantCaminos[destino.id];
	}	
}
