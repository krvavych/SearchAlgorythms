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

	public Search(final Graph g, final SearchBy parameter,
			final Vertex startingVertex) {
		this.graph = g;
		this.searchParameter = parameter;
		this.startingVertex = startingVertex;
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new BfsOrDfsIterator();
	}

	public class BfsOrDfsIterator implements Iterator<Vertex> {
		private Vertex next;

		public BfsOrDfsIterator() {
			for (final Vertex vertex : graph.getVerteces()) {
				if (vertex == startingVertex) {
					if (searchParameter == SearchBy.Bfs) {
						queue.add(vertex);
					} else {
						stack.add(vertex);
					}
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
			if (searchParameter == SearchBy.Bfs) {
				return !queue.isEmpty();
			} else {
				return !stack.isEmpty();
			}
		}

		@Override
		public Vertex next() {
			if (searchParameter == SearchBy.Bfs) {
				next = queue.remove();
			} else {
				next = stack.pop();
			}
			for (final Vertex neighbor : graph.getAdjacencyVertrxOfVertex().get(next)) {
				if (!visited.contains(neighbor)) {
					if(searchParameter == SearchBy.Bfs){
						queue.add(neighbor);
					} else {
						stack.add(neighbor);
					}
					visited.add(neighbor);
				}
			}
			return next;
		}
	}
}
