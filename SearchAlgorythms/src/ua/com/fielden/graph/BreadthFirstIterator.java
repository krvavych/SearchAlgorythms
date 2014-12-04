package ua.com.fielden.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstIterator implements Iterator<Vertex> {

	private Set<Vertex> visited = new HashSet<>();
	private Queue<Vertex> queue = new LinkedList<>();
	private Graph graph;

	public BreadthFirstIterator(final Graph g, final Vertex startingVertex) {
		this.graph = g;
		for (final Vertex vertex : graph.getVerteces()) {
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
		return !queue.isEmpty();
	}

	@Override
	public Vertex next() {
		final Vertex next = queue.remove();
		for (final Vertex neighbor : graph.getAdjacencyVertrxOfVertex().get(
				next)) {
			if (!visited.contains(neighbor)) {
				queue.add(neighbor);
				visited.add(neighbor);
			}
		}
		return next;
	}
}
