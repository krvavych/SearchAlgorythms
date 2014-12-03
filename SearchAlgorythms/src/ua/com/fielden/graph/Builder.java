package ua.com.fielden.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Builder {
	private Map<Vertex, Set<Edge>> edgesOfVertex = new HashMap<Vertex, Set<Edge>>();
	private Map<Vertex, Set<Vertex>> adjacencyVertexOfVertex = new HashMap<Vertex, Set<Vertex>>();
	private final Set<Vertex> vertexes = new HashSet<Vertex>();
	private final Set<Edge> edges = new HashSet<Edge>();

	public Builder addEdge(final Vertex s, final Vertex d) {
		if (s == null || d == null) {
			throw new IllegalArgumentException("Vertexes couldn`t be null");
		}
		final Edge edge = new Edge(s, d);
		if (!edges.contains(edge)) {
			edges.add(edge);
		} else {
			throw new IllegalArgumentException("This edge already exists");
		}
		return this;
	}

	public Builder addVertex(final Vertex vertex ) {
		if (!vertexes.contains(vertex)) {
			vertexes.add(vertex);
		} else {
			throw new IllegalArgumentException("This vertex already exists");
		}
		return this;
	}

	public boolean contains(final Set<Vertex> set, final Vertex obj) {
		for (final Vertex object : set) {
			if (obj == object) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public Graph build() {
		if (vertexes.isEmpty()) {
			throw new IllegalArgumentException("Graph must have vertexes");
		}
		for (final Edge edge : edges) {
			if (!vertexes.contains(edge.getSourse())
					|| !vertexes.contains(edge.getDestination())) {
				throw new IllegalArgumentException(
						"Wrong data for graph building");
			}
		}
		final Graph g = new Graph(edges, vertexes);
		return g;
	}

	public Set<Vertex> getVertex() {
		return vertexes;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public Map<Vertex, Set<Edge>> getEdgesOfMap() {
		return edgesOfVertex;
	}

	public Map<Vertex, Set<Vertex>> getVertexOfMap() {
		return adjacencyVertexOfVertex;
	}
}
