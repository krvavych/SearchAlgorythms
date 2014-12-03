package ua.con.fielden.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import ua.com.fielden.graph.Edge;
import ua.com.fielden.graph.Vertex;

public class TestEdge {

	@Test
	public void the_same_edge_should_be_equal() {
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(1, "element");
		final Edge e1 = new Edge(v1, v2);
		final Edge e2 = new Edge(v2, v3);
		final Edge e3 = new Edge(v3, v2);
		assertTrue(e1.equals(e1) && (e1.equals(e3)) && (!e2.equals(e1)));
	}

	@Test
	public void hashCodes_of_equal_vertexes_shoul_be_the_same() {
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(1, "element");
		final Edge e1 = new Edge(v1, v2);
		final Edge e2 = new Edge(v2, v3);
		final Edge e3 = new Edge(v3, v2);
		assertTrue((e1.hashCode() == (e3.hashCode()))
				&& (e2.hashCode() != (e1.hashCode())));
	}

	@Test
	public void it_should_be_impossible_to_create_edges_with_null_vertexes() {
		try {
			new Edge(null, new Vertex(0, null));
			fail();
		} catch (final Exception e) {
		}
	}
}
