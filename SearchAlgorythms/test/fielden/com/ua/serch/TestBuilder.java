package fielden.com.ua.serch;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fielden.com.ua.search.Builder;
import fielden.com.ua.search.Edge;
import fielden.com.ua.search.Vertex;

public class TestBuilder {

	@Test
	public void it_should_be_imposible_to_add_the_same_edge() {
		final Vertex sourse = new Vertex(1, "element");
		final Vertex destination = new Vertex(2, "element");
		final Builder builder = new Builder();
		builder.addEdge(sourse, destination);
		try {
			builder.addEdge(sourse, destination);
			fail();
		} catch (final Exception e) {

		}
	}

	@Test
	public void it_should_be_imposible_to_add_the_same_vertex() {
		final Builder builder = new Builder();
		builder.addVertex(1, "element");
		try {
			builder.addVertex(1, "element");
			fail();
		} catch (final Exception e) {

		}

	}

	@Test
	public void adjacency_list_should_be_create_correct() {
		final Builder builder = new Builder();
		final Vertex v1 = builder.addVertex(1, "element");
		final Vertex v2 = builder.addVertex(2, "element");
		final Vertex v3 = builder.addVertex(3, "element");
		builder.addEdge(v1, v2).addEdge(v2, v1).addEdge(v3, v2).addEdge(v2, v3);
		builder.creationAdjacencyLists(builder.getVertexOfMap(),
				builder.getVertex(), builder.getEdges());
		System.out.println(builder.getVertexOfMap().toString());
		assertTrue((builder.getVertexOfMap().get(v2).contains(v1) && (builder
				.getVertexOfMap().get(v2).contains(v3))));

	}

	@Test
	public void list_of_edges_of_vertex_should_be_create_correct() {
		final Builder builder = new Builder();
		final Vertex v1 = builder.addVertex(1, "element");
		final Vertex v2 = builder.addVertex(2, "element");
		final Vertex v3 = builder.addVertex(3, "element");
		final Edge e1 = new Edge(v2, v1);
		final Edge e2 = new Edge(v2, v3);
		builder.addEdge(v2, v1).addEdge(v3, v2).addEdge(v2, v3).addEdge(v1, v2);
		builder.creationEdgesOfVertex(builder.getEdgesOfMap(),
				builder.getVertex(), builder.getEdges());
		System.out.println(builder.getEdgesOfMap().toString());
		assertTrue((builder.getEdgesOfMap().get(v2).contains(e1) && (builder
				.getEdgesOfMap().get(v2).contains(e2))));

	}

}
