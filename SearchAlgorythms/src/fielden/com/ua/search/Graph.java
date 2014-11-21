package fielden.com.ua.search;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Graph {
	public Set<Vertex> verteces = new HashSet<Vertex>();
	public Set<Edge> edges = new HashSet<Edge>();
	public final  Map<Vertex, Set<Edge>> edgesOfVertex;
	public final Map<Vertex, Set<Vertex>> adjacencyVertrxOfVertex;

	public boolean contains(final Vertex vertex) {
		return verteces.contains(vertex);
	}

	public int numberOfVertexes() {
		return verteces.size();
	}

	public void addEdge(final Vertex s, final Vertex d) {
		final Edge edge = new Edge(s, d);
		if (!edges.contains(edge)) {
			edges.add(edge);
		}
		if (!verteces.contains(s)) {
			verteces.add(s);
		}
		if (!verteces.contains(d)) {
			verteces.add(d);
		}
	}
	public Graph(final Set<Edge> edges, final Set<Vertex> verteces, final Map<Vertex, Set<Edge>> edgesOfVertex, final Map<Vertex, Set<Vertex>> adjacencyVertexOfVertex){
		this.edges = edges;
		this.verteces = verteces;
		this.edgesOfVertex = edgesOfVertex;
		this.adjacencyVertrxOfVertex = adjacencyVertexOfVertex;
	}
	public void dfs(final Graph g, final Vertex v){
	final Builder builder = new Builder();
		final Iterator<Vertex> graph = new DeapthFirstIterator(g, v);
		while (graph.hasNext()) {
			final Vertex nextVertex = graph.next();
			builder.visitor(nextVertex);
		}
	}

	public void bfs(final Graph g, final Vertex v){
		final Builder builder = new Builder();
			final Iterator<Vertex> graph = new BreadthFirstIterator(g, v);
			while (graph.hasNext()) {
				final Vertex nextVertex = graph.next();
				builder.visitor(nextVertex);
			}
		}

	public static void main(final String[] args) {

	}

}