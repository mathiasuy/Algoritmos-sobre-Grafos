package utils;

public class GrafoMatriz {

	boolean[][] nodos;
	
	public GrafoMatriz(int alto, int ancho) {
		this.nodos = new boolean[alto][ancho];
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				this.nodos[i][j] = false;
			}
		}
			
	}
	
	public void marcar(Nodo a, Nodo b) {
		nodos[a.id][b.id] = true;
	}
	
	public boolean marcado(Nodo a, Nodo b) {
		return nodos[a.id][b.id];
	}
	
	public void desmarcar(Nodo a, Nodo b) {
		nodos[a.id][b.id] = false;
	}
	
}