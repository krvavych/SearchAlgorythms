package fielden.com.ua.serch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ua.com.fielden.graph.Vertex;

public class TestVertex {

	@Test
	public void the_same_vertexes_shoul_be_equal() {
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(1, "element");
		final Vertex v4 = new Vertex(2, null);
		assertFalse(v1.equals(v2));
		assertTrue(v2.equals(v4));
		assertTrue(v1.equals(v3));
		if (v1.hashCode() == v3.hashCode()) {
			assertTrue(v1.equals(v3));
		}
	}

	@Test
	public void different_verteces_should_have_different_hashCodes() {
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(1, "element");
		assertFalse(v1.hashCode() == (v2.hashCode()));
		assertTrue(v1.hashCode() == (v3.hashCode()));
		if (v1.hashCode() == (v3.hashCode())) {
			assertTrue(v1.equals(v3) && v3.equals(v1));
		}
	}
}
