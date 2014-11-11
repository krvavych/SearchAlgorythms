package fielden.com.ua.search;

import java.util.Iterator;
import java.util.LinkedList;

public class Vertex<T> {
	private T element;
	private int id;
	private LinkedList<Edge<T>> pointers;

	public Vertex() {
		this(null);
	}

	public Vertex(T element) {
		this.element = element;
		setPointers(new LinkedList<Edge<T>>());
	}

	public int getId() {
		return id;
	}
	
	public Vertex<T> setId(int id) {
		this.id = id;
		return this;
	}

	public T getElement() {
		return element;
	}

	public Vertex<T> setElement(T element) {
		this.element = element;
		return this;
	}	

	public LinkedList<Edge<T>> getEdge() {
		return getPointers();
	}

	public Iterator<Edge<T>> iterator() {
		return getPointers().iterator();
	}

	public boolean equals(Vertex<T> obj) {
		if (this.getPointers().size() != obj.getEdge().size()) {
			return false;
		}
		LinkedList<Edge<T>> temp = new LinkedList<Edge<T>>(obj.getEdge());
		return  (!temp.retainAll(this.getPointers()));
	}

	public String toString() {
		return this.element.toString();
	}

	public LinkedList<Edge<T>> getPointers() {
		return pointers;
	}

	public void setPointers(LinkedList<Edge<T>> pointers) {
		this.pointers = pointers;
	}

}
