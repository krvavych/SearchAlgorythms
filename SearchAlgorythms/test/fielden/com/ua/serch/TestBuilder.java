package fielden.com.ua.serch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import fielden.com.ua.search.Builder;
import fielden.com.ua.search.Edge;
import fielden.com.ua.search.Vertex;

public class TestBuilder {

	@Test
	public void it_should_be_imposible_to_add_the_same_edge() {
		final Set<Edge> edges = new HashSet<Edge>();
		final Vertex sourse = new Vertex(1, "element");
		final Vertex destination = new Vertex(2, "element");
		final Edge edge1 = new Edge(sourse, destination);
		final Edge edge2 = new Edge(sourse, destination);
		final Edge edge3 = new Edge(destination, sourse);
		edges.add(edge1);
		assertFalse(edges.add(edge2));
		assertTrue(edges.add(edge3));
	}

	@Test
	public void it_should_be_imposible_to_add_the_same_vertex() {
		final Set<Vertex> vertexes = new HashSet<Vertex>();
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(1, "element");
		final Vertex v3 = new Vertex(2, "element");
		vertexes.add(v1);
		assertFalse(vertexes.add(v2));
		assertTrue(vertexes.add(v3));
	}

	@Test
	public void adjacency_list_should_be_create_correct() {
		final Set<Vertex> vertexs = new HashSet<Vertex>();
		final Set<Edge> edges = new HashSet<Edge>();
		final Builder builder = new Builder();
		final Vertex v1 = builder.addVertex(1, "element", vertexs);
		final Vertex v2 = builder.addVertex(2, "element", vertexs);
		final Vertex v3 = builder.addVertex(3, "element", vertexs);
		builder.
		addEdge(v1, v2).
		addEdge(v2, v1).
		addEdge(v3, v2).
		addEdge(v2, v3);
		final Map<Vertex, Set<Vertex>> eMap = new HashMap<Vertex, Set<Vertex>>();
		builder.creationAdjacencyLists(eMap, vertexs, edges);
		System.out.println(eMap.toString());
		assertTrue((eMap.get(v2).contains(v1)&&(eMap.get(v2).contains(v3))));

	}

	@Test
	public void list_of_edges_of_vertex_should_be_create_correct() {
		final Map<Vertex, Set<Edge>> eMap = new HashMap<Vertex, Set<Edge>>();
		final Set<Vertex> vertexs = new HashSet<Vertex>();
		final Set<Edge> edges = new HashSet<Edge>();
		final Builder builder = new Builder();
		final Vertex v1 = builder.addVertex(1, "element", vertexs);
		final Vertex v2 = builder.addVertex(2, "element", vertexs);
		final Vertex v3 = builder.addVertex(3, "element", vertexs);
		final Edge e1 = new Edge(v2, v1);
		final Edge e2 = new Edge(v2, v3);
		builder.
		addEdge(v2, v1).
		addEdge(v3, v2).
		addEdge(v2, v3).
		addEdge(v1, v2);
		builder.creationEdgesOfVertex(eMap, vertexs, edges);
		System.out.println(eMap.toString());
		assertTrue((eMap.get(v2).contains(e1)&&(eMap.get(v2).contains(e2))));

	}


}
