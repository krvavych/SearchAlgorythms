package fielden.com.ua.search;

import java.util.List;

public class Graph {
	final private List<Vertex> verteces;
	final private List<Edge> edges;
	
	public Graph (List<Vertex> verteces, List<Edge> edges){
		this.verteces = verteces;
		this.edges = edges;
	}

	public List<Vertex> getVerteces() {
		return verteces;
	}

	public List<Edge> getEdges() {
		return edges;
	}

}
