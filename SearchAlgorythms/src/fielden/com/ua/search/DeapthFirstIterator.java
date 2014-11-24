package fielden.com.ua.search;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Set;

public class DeapthFirstIterator implements Iterator<Vertex> {
	private Set<Vertex> visited = new HashSet<Vertex>();
	private Deque<Iterator<Vertex>> stack = new LinkedList<Iterator<Vertex>>();
	private Graph graph;
	private Vertex next;

	public DeapthFirstIterator(final Graph g, final Vertex startingVertex) {
		this.graph = g;
		final Builder builder = new Builder();
		builder.creationAdjacencyLists(graph.getAdjacencyVertrxOfVertex(), graph.getVerteces(), graph.getEdges());
		this.stack.push(graph.getAdjacencyVertrxOfVertex().get(startingVertex).iterator());
		this.next = startingVertex;
	}


	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	@Override
	public Vertex next() {
		if (this.next == null) {
			throw new NoSuchElementException();
		}
		try {
			this.visited.add(this.next);
			return this.next;
		} finally {
			this.advance();
		}
	}

	private void advance() {
		Iterator<Vertex> neighbors = this.stack.peek();
		do {
			while (!neighbors.hasNext()) {
				this.stack.pop();
				if (this.stack.isEmpty()) {
					this.next = null;
					return;
				}
				neighbors = this.stack.peek();
			}

			this.next = neighbors.next();
		} while (this.visited.contains(this.next));
		this.stack.push(this.graph.getAdjacencyVertrxOfVertex().get(this.next).iterator());
	}
}
