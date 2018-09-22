package ejercicios;

import utils.GrafoListas;
import utils.Nodo;

public class EncontrarCicloDFS {

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

		buscarCiclo(grafo);
	}
	
	public static boolean buscarCiclo(GrafoListas g){
		boolean[] marcados = new boolean[9];
		Nodo padres[] = new Nodo[9];
		for (Nodo n : g.getNodos()) { //aquí se vé el orden n (nodos)
			if (!marcados[n.id]) {
				boolean tiene = DFS(n, marcados, padres);
				if (tiene)
					return true;
			}
		}
		return false;
	}

	private static boolean DFS(Nodo n, boolean[] marcados, Nodo[] padres) {
		marcados[n.id] = true;
		System.out.println("Voy por: " + n + ".");
		for (Nodo w : n.getAdyacentes()) { // auquí se ve el orden m (aristas)
			System.out.println("	" + n + " -> " + w + ".");
			if (!marcados[w.id]) {
				marcados[w.id] = true;
				padres[w.id] = n;
				boolean tiene = DFS(w,marcados,padres);
				if (tiene)
					return true;
			}else {
				System.out.println("Ya marcado: " + w);
				if (padres[n.id] != null && padres[n.id].id != w.id) {
					System.out.println("" + w + " no es el padre => Ciclo encontrado!");
					System.out.print(n+ "-");
					System.out.print(w+ "-");
					imprimirPadres(n, w, padres);
					return true;
				}
			}
		}
		return false;
	}
	
	private static void imprimirPadres(Nodo n, Nodo ultimo, Nodo[] padres) {
		if (padres[n.id] != ultimo) {
			imprimirPadres(padres[n.id], ultimo,  padres);
			System.out.print("-" + padres[n.id]);
		}
	}

}