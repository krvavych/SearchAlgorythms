package ua.com.fielden.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Search {
	private Graph graph;
	private Set<Vertex> visited = new HashSet<>();
	private Queue<Vertex> queue = new LinkedList<>();
	private Stack<Vertex> stack = new Stack<>();
	private SearchBy searchParameter;

	public enum SearchBy {
		Dfs, Bfs
	}

	public LinkedList<Vertex> search(final Graph graph, final Vertex startVertex,
			final SearchBy parameter) {
		LinkedList<Vertex> list = new LinkedList<>();
		this.searchParameter = parameter;
		this.graph = graph;
		for (final Vertex vertex : this.graph.getVerteces()) {
			if (vertex == startVertex) {
				if (searchParameter == SearchBy.Bfs) {
					this.queue.add(vertex);
				} else if (searchParameter == SearchBy.Dfs) {
					this.stack.push(vertex);
				}
				this.visited.add(vertex);
				//System.out.println(vertex);
			}
		}
		list = searchContinue(searchParameter);
		return list;
	}

	private LinkedList<Vertex> searchContinue(final SearchBy parameter) {
		final LinkedList<Vertex> list = new LinkedList<Vertex>();
		if (parameter == SearchBy.Bfs) {
			System.out.println(queue.peek());
			list.add(queue.peek());
			while (!queue.isEmpty()) {
				final Vertex vertex = queue.remove();
				for (final Iterator<Vertex> iter = graph.getAdjacencyVertrxOfVertex().get(vertex).iterator(); iter.hasNext();) {
					final Vertex next = iter.next();
					if (!visited.contains(next)) {
						System.out.println(next);
						visited.add(next);
						queue.add(next);
						list.add(next);
					}
				}
			}
			return list;
		} else if (parameter == SearchBy.Dfs) {
			while (!stack.isEmpty()) {
				final Vertex vertex = stack.peek();
				for (final Iterator<Vertex> iter = graph.getAdjacencyVertrxOfVertex().get(vertex).iterator(); iter.hasNext();) {
					final Vertex next = iter.next();
					if (!visited.contains(next) ) {
						visited.add(next);
						stack.push(next);
					} else if(!stack.isEmpty()){
						final Vertex addVertex = stack.pop();
						System.out.println(addVertex);
						list.add(addVertex);
					}
				}
			}
		}
		return list;
	}
}
