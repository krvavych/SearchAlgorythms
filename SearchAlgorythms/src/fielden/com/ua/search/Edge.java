package fielden.com.ua.search;

public class Edge<T>{
	private Vertex<T> sourse, destination;

	public Vertex<T> getSourse() {
		return sourse;
	}

	public Edge<T> setSourse(Vertex<T> sourse) {
		this.sourse = sourse;
		return this;
	}

	public Vertex<T> getDestination() {
		return destination;
	}

	public Edge<T> setDestination(Vertex<T> destination) {
		this.destination = destination;
		return this;
	}

	public Edge(Vertex<T> sourse, Vertex<T> destinstion) {
		this.sourse = sourse;
		this.destination = destinstion;
	}

	public boolean equals(Edge<T> obj) {
		return sourse.equals(obj.getDestination())
				&& destination.equals(obj.getDestination());
	}

	public String toString() {
		return "(" + sourse.getElement() + ", " + destination.getElement() + ")";
	}
	

	
}
