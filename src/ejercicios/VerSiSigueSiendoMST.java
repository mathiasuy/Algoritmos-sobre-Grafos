package ejercicios;

import utils.GrafoListas;
import utils.Nodo;
import utils.Pila;

public class VerSiSigueSiendoMST {

	public static final int CANT_NODOS = 9; 
	
	public static void main(String[] args) {
		GrafoListas grafo = new GrafoListas();
		int valorArista[][] = new int[CANT_NODOS][CANT_NODOS];
		
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
		
		n1.add(n0);
		//n1.add(n2);
		n1.add(n3);
		
		//n2.add(n1);
		n2.add(n3);
		
		n3.add(n1);
		//n3.add(n2);
		n3.add(n4);
		n3.add(n5);
		
		n4.add(n3);
		
		n5.add(n6);
		n5.add(n3);
		
		n6.add(n5);
		//n6.add(n2);
		n6.add(n8);
		
		n7.add(n8);
		n7.add(n6);
		n8.add(n7);

		DFS(grafo,n0,n8,valorArista	);
	}

	private static boolean DFS(GrafoListas g, Nodo a, Nodo b, int[][] valorArista) {
		boolean marcado[] = new boolean[CANT_NODOS];
		int camino[] = new int [CANT_NODOS];
		Nodo padres[] = new Nodo [CANT_NODOS];
		Pila p = new Pila();
		p.apilar(a);
		camino[a.id] = 0;
		while (!p.isEmpty() && p.top() != a) {
			Nodo v = p.desapilar();
			for (Nodo w : v.getAdyacentes()) {
				if (!marcado[w.id]) {
					p.apilar(w);
					marcado[v.id] = true;
					padres[w.id] = v;
					camino[w.id] = valorArista[v.id][w.id];
				}
			}
		}
		
		Nodo aux = p.top();
		int mayor = camino[aux.id];
		while (aux != a) {
			if (mayor  < camino[aux.id]) {
				mayor = camino[aux.id];
			aux = padres[aux.id];
			}
		} 
		if (valorArista[b.id][a.id] < mayor) {
			//Eliminar arista de costo mayor en T
			//agregar e al árbol T
		}
		//retornar el árbol T
		return false;
	}
	
	private static void imprimirPadres(Nodo n, Nodo ultimo, Nodo[] padres) {
		if (padres[n.id] != ultimo) {
			imprimirPadres(padres[n.id], ultimo,  padres);
			System.out.print("-" + padres[n.id]);
		}
	}

}
