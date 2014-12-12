package ua.com.fielden.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ua.com.fielden.graph.structure.FifoQueue;
import ua.com.fielden.graph.structure.FiloQueue;
import ua.com.fielden.graph.structure.IQueue;

public class Search implements Iterable<Vertex> {
	private  Graph graph;
	private  SearchBy searchParameter;
	private  Vertex startingVertex;

	public enum SearchBy {
		Dfs, Bfs
	}

	public Search(final Graph g, final SearchBy parameter,final Vertex startingVertex) {
		this.graph = g;
		this.searchParameter = parameter;
		this.startingVertex = startingVertex;
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new SearchIterator();
	}

	private class SearchIterator implements Iterator<Vertex> {
		public  IQueue q;
		public  Set<Vertex> visited = new HashSet<>();

		private SearchIterator() {
			if (searchParameter == SearchBy.Bfs) {
				q = new FifoQueue();
			} else {
				q = new FiloQueue();
			}
			for (final Vertex vertex : graph.getVerteces()) {
				if (vertex == startingVertex) {
					q.push(vertex);
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
			return !q.isEmpty();
		}

		@Override
		public Vertex next() {
			final Vertex next = q.pop();
			for (final Vertex neighbor : graph.getAdjacencyVertrxOfVertex().get(next)) {
				if (!visited.contains(neighbor)) {
					q.push(neighbor);
					visited.add(neighbor);
				}
			}
			return next;
		}
	}
}
