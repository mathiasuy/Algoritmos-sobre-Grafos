package ejercicios;

import utils.GrafoListas;
import utils.Nodo;
import utils.Queue;

public class EncontrarNodoHubEnGrafo {

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

		n0.add(n3);
		n0.add(n10);
		
		n10.add(n0);
		n3.add(n0);
		
		n10.add(n6);
		n3.add(n6);
		
		n6.add(n3);
		n6.add(n10);
		
		n6.add(n8);
		n8.add(n6);
		
		n8.add(n5);
		n5.add(n8);
		
		n5.add(n7);
		n7.add(n5);
		
		n5.add(n9);
		n9.add(n5);
		
		n9.add(n4);
		n4.add(n9);
		
		n10.add(n4);
		n4.add(n10);
		
		n7.add(n11);
		n11.add(n7);
		
		
		
		boolean[] marcados = new boolean[CANTIDAD_DE_NODOS];
		int k = encontrarHubBFS(n0,marcados,n11);
		System.out.println("Nodo hub: " + k);
	}

	
	public static int encontrarHubBFS(Nodo s, boolean[] marcados, Nodo t) {
		int nivel[] = new int[CANTIDAD_DE_NODOS];
		Queue q = new Queue();
		marcados[s.id] = true;
		nivel[s.id] = 1;
		q.enqueue(s);
		int cantidad_por_nivel[] = new int[CANTIDAD_DE_NODOS];
		while (!q.isEmpty()) {
			Nodo u = q.dequeue();
			for (Nodo w : u.getAdyacentes()) {
				if (nivel[w.id] < 1) {
					nivel[w.id] = nivel[u.id] + 1;
				}
				if (!marcados[w.id]) {
					marcados[w.id] = true;
					q.enqueue(w);
//					System.out.println("Nivel: " + nivel[w.id]);
					cantidad_por_nivel[nivel[w.id]]++;
//					System.out.println(u + " -> " + w);
				}
			}
		}
		for (int k = 0; k < cantidad_por_nivel.length; k++) {
			if (cantidad_por_nivel[k]== 1) {
				System.out.println(cantidad_por_nivel[k]);
				return k;
			};
		}
		return -1;
	}

}