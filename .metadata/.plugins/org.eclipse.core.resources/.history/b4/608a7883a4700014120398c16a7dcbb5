package fielden.com.ua.search;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	public final Set<Vertex> verteces = new HashSet<Vertex>();
	public final Set<Edge> edges = new HashSet<Edge>();

	public boolean contains(final Vertex vertex) {
		return verteces.contains(vertex);
	}

	public int numberOfVertexes() {
		return verteces.size();
	}

	public void addEdge(final Vertex s, final Vertex d) {
		final Edge edge = new Edge(s, d);
		if (!edges.contains(edge)) {
			edges.add(edge);
		}
		if (!verteces.contains(s)) {
			verteces.add(s);
		}
		if (!verteces.contains(d)) {
			verteces.add(d);
		}
	}

	public static void main(final String[] args) {
	}
}