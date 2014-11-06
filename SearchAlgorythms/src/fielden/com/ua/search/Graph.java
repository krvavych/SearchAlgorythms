package fielden.com.ua.search;

import java.util.ArrayList;

public class Graph<T> {
	private ArrayList<Vertex<T>> verteces;

	public Graph() {
		verteces = new ArrayList<Vertex<T>>();
	}

	public boolean addVertex(Vertex<T> vertex) {
		if (verteces.contains(vertex)) {
			return false;
		}
		verteces.add(vertex);
		return true;
	}

	public boolean contains(Vertex<T> vertex) {
		return verteces.contains(vertex);
	}

	public Vertex<T> get(int index) {
		return verteces.get(index);
	}

	public int count() {
		return verteces.size();
	}

	public boolean equals(Graph<T> obj) {
		if(this.verteces.size() != obj.verteces.size()){
			return false;
		}
		ArrayList<Vertex<T>> temp = new ArrayList<Vertex<T>>(this.verteces);
		return (!temp.retainAll(obj.verteces));
	}

}