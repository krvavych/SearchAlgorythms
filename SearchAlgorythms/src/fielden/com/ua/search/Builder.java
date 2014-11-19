package fielden.com.ua.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Builder implements IVisitor {
	public Map<Vertex, Set<Vertex>> edgesOfVertex = new HashMap<Vertex, Set<Vertex>>();
	public Set<Vertex> vertexes = new HashSet<Vertex>();
	public Set<Edge> edges = new HashSet<Edge>();

	public Builder addEdge(final Vertex s, final Vertex d, final Set<Edge> edges) {
		final Edge edge = new Edge(s, d);
		if (!edges.contains(edge)) {
			edges.add(edge);
		} else {
			System.out.println("This edge already exists");
		}
		return this;
	}

	public Vertex addVertex(final int id, final Object element,
			final Set<Vertex> vertexes) {
		final Vertex vertex = new Vertex(id, element);
		if (!vertexes.contains(vertex)) {
			vertexes.add(vertex);
		} else {
			System.out.println("This vertex already exists");
		}
		return vertex;
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

	public Map<Vertex, Set<Vertex>> creationAdjacencyLists() {
		for (final Vertex vertex : vertexes) {
			final Set<Vertex> adjacencyVertrxes = new HashSet<Vertex>();
			for (final Edge edge : edges) {
				if (edge.getSourse() == vertex) {
					adjacencyVertrxes.add(edge.getDestination());
				}
			}
			edgesOfVertex.put(vertex, adjacencyVertrxes);
		}
		return edgesOfVertex;
	}

	@Override
	public void visitor(final Vertex vertex) {
		vertex.getElement();

	}

}
