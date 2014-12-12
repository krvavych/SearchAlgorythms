package ua.com.fielden.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ua.com.fielden.graph.structure.FifoQueue;
import ua.com.fielden.graph.structure.FiloQueue;
import ua.com.fielden.graph.structure.IQueue;
import ua.com.fielden.graph.visitors.IVertexVisitor;

public class Search implements Iterable<Vertex> {
	private final Graph graph;
	private final SearchBy searchParameter;
	private final Vertex startingVertex;
	private final IVertexVisitor visitor;

	public enum SearchBy {
		Dfs, Bfs
	}

	public Search(final Graph g, final SearchBy parameter,final Vertex startingVertex, final IVertexVisitor visitor) {
		this.graph = g;
		this.searchParameter = parameter;
		this.startingVertex = startingVertex;
		this.visitor = visitor;
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new SearchIterator();
	}

	private class SearchIterator implements Iterator<Vertex> {
		public  final IQueue queue;
		public  final Set<Vertex> visited = new HashSet<>();

		private SearchIterator() {
			if (searchParameter == SearchBy.Bfs) {
				queue = new FifoQueue();
			} else {
				queue = new FiloQueue();
			}
			for (final Vertex vertex : graph.getVerteces()) {
				if (vertex == startingVertex) {
					queue.push(vertex);
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
			final Vertex next = queue.pop();
			for (final Vertex neighbor : graph.getAdjacencyVertrxOfVertex().get(next)) {
				if (!visited.contains(neighbor)) {
					queue.push(neighbor);
					visited.add(neighbor);
				}
			}
			if (visitor != null) {
				visitor.visit(next);
			}
			return next;
		}
	}
}
