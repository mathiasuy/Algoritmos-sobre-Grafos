package ejercicios;

import utils.GrafoListas;
import utils.Nodo;
import utils.Pila;

public class OrdenTopologico {

	public static final int CANTIDAD_DE_NODOS = 12;
	
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
		Nodo n9 = new Nodo(9);
		Nodo n10 = new Nodo(10);
		Nodo n11 = new Nodo(11);
		grafo.add(n0);
		//grafo.add(n1);
		//grafo.add(n2);
		grafo.add(n3);
		grafo.add(n4);
		grafo.add(n5);
		grafo.add(n6);
		grafo.add(n7);
		grafo.add(n8);
		grafo.add(n9);
		grafo.add(n10);
		grafo.add(n11);

		n0.add(n3);
		n0.add(n10);
		
		n10.add(n6);
		//n10.add(n5);
		n6.add(n8);

		n8.add(n11);
		n8.add(n5);

		n5.add(n7);
		n5.add(n9);
		
		//n8.add(n11);
		n7.add(n11);
		
		
		n9.add(n4);
		//n4.add(n6);
		
		
		grafo.add(n0);
		
		//boolean[] marcados = new boolean[CANTIDAD_DE_NODOS];
		buscarCiclo(grafo);
		//System.out.println("Nodo hub: " + k);
	}
	
	public static boolean buscarCiclo(GrafoListas g){
		boolean[] marcados = new boolean[CANTIDAD_DE_NODOS];
		Nodo padres[] = new Nodo[CANTIDAD_DE_NODOS];
		Pila p = new Pila();
		Pila ordenTopologico = new Pila();
		for (Nodo n : g.getNodos()) {
			if (!marcados[n.id]) {
				p.apilar(n);
				DFS(n,marcados,padres,p,ordenTopologico);
				ordenTopologico.apilar(p.desapilar());
			}
		}
		System.out.println(">>");
		ordenTopologico.print();
		return false;
	}

	private static boolean DFS(Nodo v, boolean[] marcados, Nodo[] padres, Pila p, Pila Ordentopologico) {
		marcados[v.id] = true;
		for (Nodo w : v.getAdyacentes()) {
			if (!marcados[w.id]) {
				padres[w.id] = v;
				p.apilar(w);
				DFS(w,marcados,padres,p,Ordentopologico);
				Ordentopologico.apilar(p.desapilar());
			}else {
				System.out.println("Se encontró un ciclo");
				System.out.print(v + "-");
				System.out.print(w);
				imprimirPadres(v, w, padres);
				if (w != null && padres[w.id] != v) {
				}
			}
		}
		return false;
	}
	
	private static void imprimirPadres(Nodo n, Nodo ultimo, Nodo[] padres) {
		if (n != null && padres[n.id] != ultimo) {
			imprimirPadres(padres[n.id], ultimo,  padres);
			System.out.print("-" + padres[n.id]);
		}
	}

}