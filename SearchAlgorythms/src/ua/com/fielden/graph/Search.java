package ua.com.fielden.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Search implements Iterable<Vertex> {
	private Graph graph;
	private Set<Vertex> visited = new HashSet<>();
	private Queue<Vertex> queue = new LinkedList<>();
	private Stack<Vertex> stack = new Stack<>();
	private SearchBy searchParameter;
	private Vertex startingVertex;

	public enum SearchBy {
		Dfs, Bfs
	}

	public Search(final Graph g, final SearchBy parameter, final Vertex startingVertex) {
		this.graph = g;
		this.searchParameter = parameter;
		this.startingVertex = startingVertex;
	}

	@Override
	public Iterator<Vertex> iterator() {
		if (searchParameter == SearchBy.Bfs) {
			return new BfsIterator();
		} else {
			return new DfsIterator();
		}
	}

	public class BfsIterator implements Iterator<Vertex> {

		public BfsIterator() {
			for (final Vertex vertex : graph.getVerteces()) {
				if (vertex == startingVertex) {
					queue.add(vertex);
					visited.add(vertex);
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
			for (final Vertex neighbor : graph.getAdjacencyVertrxOfVertex().get(next)) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
			return next;
		}

	}

	public class DfsIterator implements Iterator<Vertex> {

		public DfsIterator() {
			for (final Vertex vertex : graph.getVerteces()) {
				if (vertex == startingVertex) {
					stack.add(vertex);
					visited.add(vertex);
				}
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Vertex next() {
			final Vertex next = stack.pop();
			for (final Vertex neighbor : graph.getAdjacencyVertrxOfVertex().get(next)) {
				if (!visited.contains(neighbor)) {
					stack.add(neighbor);
					visited.add(neighbor);
				}
			}
			return next;
		}
	}
}
