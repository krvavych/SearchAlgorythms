package fielden.com.ua.serch;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ua.com.fielden.graph.Builder;
import ua.com.fielden.graph.Edge;
import ua.com.fielden.graph.Graph;
import ua.com.fielden.graph.Vertex;

public class TestGraph {

	@Test
	public void graph_created_by_builder_should_be_equal_to_hand_createg_graph() {
		final Set<Vertex> vertexs = new HashSet<Vertex>();
		final Set<Edge> edges = new HashSet<Edge>();
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		vertexs.add(v1);
		vertexs.add(v2);
		edges.add(new Edge(v1, v2));
		final Graph graph = new Graph(edges, vertexs);

		final Builder builder = new Builder();
		final Vertex v3 = new Vertex(1, "element");
		final Vertex v4 = new Vertex(2, "element");
		final Graph buildGraph = builder.addVertex(v3).addVertex(v4)
				.addEdge(v3, v4).build();
		assertTrue(graph.equals(buildGraph));
		assertTrue(graph.hashCode() == buildGraph.hashCode());
	}

	@Test
	public void graph_should_not_have_null_set_of_verteces() {
		try {
			new Graph(null, null);
			fail();
		} catch (final Exception e) {
		}
	}

	@Test
	public void graph_should_not_have_edges_with_verteces_wich_donot_exist_in_setOfVertex() {
		final Set<Vertex> vertexs1 = new HashSet<Vertex>();
		final Set<Edge> edges1 = new HashSet<Edge>();
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(3, "element");
		vertexs1.add(v1);
		vertexs1.add(v2);
		edges1.add(new Edge(v1, v2));
		edges1.add(new Edge(v1, v3));
		try {
			new Graph(edges1, vertexs1);
			fail();
		} catch (final Exception e) {
		}
	}

	@Test
	public void adjacency_list_should_be_create_correctly() {
		final Builder builder = new Builder();
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(3, "element");
		final Graph graph = builder.addVertex(v1).addVertex(v2).addVertex(v3)
				.addEdge(v1, v2).addEdge(v2, v1).addEdge(v3, v2)
				.addEdge(v2, v3).build();
		graph.creationAdjacencyLists();
		System.out.println(graph.getAdjacencyVertrxOfVertex().toString());
		assertTrue((graph.getAdjacencyVertrxOfVertex().get(v2).contains(v1) && (graph
				.getAdjacencyVertrxOfVertex().get(v2).contains(v3))));

	}

	@Test
	public void list_of_edges_of_vertex_should_be_create_correct() {
		final Builder builder = new Builder();
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(3, "element");
		final Edge e1 = new Edge(v2, v1);
		final Edge e2 = new Edge(v2, v3);
		final Graph g = builder.addVertex(v1).addVertex(v2).addVertex(v3)
				.addEdge(v2, v1).addEdge(v3, v2).addEdge(v2, v3)
				.addEdge(v1, v2).build();
		g.creationEdgesOfVertex();
		System.out.println(g.getEdgesOfVertex().toString());
		assertTrue((g.getEdgesOfVertex().get(v2).contains(e1) && (g
				.getEdgesOfVertex().get(v2).contains(e2))));

	}

}
