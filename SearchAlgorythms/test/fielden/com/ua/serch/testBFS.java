package fielden.com.ua.serch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import fielden.com.ua.search.BreadthFirstIterator;
import fielden.com.ua.search.Builder;
import fielden.com.ua.search.Edge;
import fielden.com.ua.search.Graph;
import fielden.com.ua.search.Vertex;

public class testBFS {

	@Test
	public void BFS_should_work_correct() {
		final Map<Vertex, Set<Vertex>> eMap = new HashMap<Vertex, Set<Vertex>>();
		final Builder builder = new Builder();
		final Set<Vertex> vertexs = new HashSet<Vertex>();
		final Set<Edge> edges = new HashSet<Edge>();
		final Vertex v1 = builder.addVertex(1, "element", vertexs);
		final Vertex v2 = builder.addVertex(2, "element", vertexs);
		final Vertex v3 = builder.addVertex(3, "element", vertexs);
		builder.addEdge(v1, v2, edges);
		builder.addEdge(v2, v1, edges);
		builder.addEdge(v3, v2, edges);
		builder.addEdge(v2, v3, edges);
		builder.creationAdjacencyLists(eMap, vertexs, edges);
		final Graph g = new Graph(builder);
		g.verteces = vertexs;
		g.edges = edges;
		System.out.println(g.edges.toString());
		final Iterator<Vertex> graph = new BreadthFirstIterator(g, v2);
		while (graph.hasNext()) {
			System.out.println(graph.next().getElement());
		}
	}

}
