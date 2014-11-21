package fielden.com.ua.search;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstIterator implements Iterator<Vertex> {

	private Set<Vertex> visited = new HashSet<Vertex>();
	private Queue<Vertex> queue = new LinkedList<Vertex>();
	private Graph graph;

	public BreadthFirstIterator(final Graph g, final Vertex startingVertex) {
		this.graph = g;
		for (final Vertex vertex : graph.verteces) {
			if (vertex == startingVertex) {
				this.queue.add(vertex);
				this.visited.add(vertex);
			}
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasNext() {
		return !this.queue.isEmpty();
	}

	@Override
	public Vertex next() {
		final Builder builder = new Builder();
		builder.creationAdjacencyLists(graph.adjacencyVertrxOfVertex, graph.verteces, graph.edges);
		final Vertex next = queue.remove();
		for (final Vertex neighbor : graph.adjacencyVertrxOfVertex.get(next)) {
			if (!this.visited.contains(neighbor)) {
				this.queue.add(neighbor);
				this.visited.add(neighbor);
			}
		}
		return next;
	}
}
