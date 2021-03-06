package ua.con.fielden.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import ua.com.fielden.graph.Builder;
import ua.com.fielden.graph.Vertex;

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
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(1, "element");
		builder.addVertex(v1);
		try {
			builder.addVertex(v2);
			fail();
		} catch (final Exception e) {
		}
	}


	@Test
	public void it_should_be_impossible_to_add_edge_with_null_verteves() {
		final Builder builder = new Builder();
		try {
			builder.addEdge(null, null);
			builder.addEdge(null, new Vertex(1, 1));
			builder.addEdge(new Vertex(1, 2), null);
			fail();
		} catch (final Exception e) {
		}
	}

	@Test
	public void graph_cannot_be_without_any_vertexes() {
		final Builder builder = new Builder();
		try {
			builder.build();
			fail();
		} catch (final Exception e) {
		}
	}

	@Test
	public void it_should_be_impossible_to_build_graph_with_edge_vertexes_of_wich_not_egzist_in_setOfVertex() {
		final Builder builder = new Builder();
		final Vertex v1 = new Vertex(1, "element");
		builder.addVertex(v1);
		builder.addEdge(new Vertex(2, "element"), new Vertex(1, 1));
		builder.addEdge(new Vertex(1, 2), new Vertex(3, null));
		try {
			builder.build();
			fail();
		} catch (final Exception e) {
		}
	}
}
