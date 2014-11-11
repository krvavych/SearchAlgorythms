package fielden.com.ua.search;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstIterator implements Iterator<Integer> {

	private Set<Integer> visited = new HashSet<Integer>();
	private Queue<Integer> queue = new LinkedList<Integer>();
	private Graph<Object> graph;

	public BreadthFirstIterator(Graph<Object> g, int startingVertexId) {
		this.graph = g;
		this.queue.add(startingVertexId);
		this.visited.add(startingVertexId);
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
	public Integer next() {
		Integer next = queue.remove();
		for (Integer neighbor : this.graph.getNeighbors(next)) {
			if (!this.visited.contains(neighbor)) {
				this.queue.add(neighbor);
				this.visited.add(neighbor);
			}
		}
		return next;
	}
}
