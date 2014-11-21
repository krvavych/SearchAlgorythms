package fielden.com.ua.serch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fielden.com.ua.search.Vertex;

public class TestVertex {

	@Test
	public void vertexEquality() {
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(1, "element");
		assertFalse(v1.equals(v2));
		assertTrue(v1.equals(v3));

	}

	@Test
	public void different_verteces_should_have_different_hashCodes(){
		final Vertex v1 = new Vertex(1, "element");
		final Vertex v2 = new Vertex(2, "element");
		final Vertex v3 = new Vertex(1, "element");
		assertFalse(v1.hashCode()==(v2.hashCode()));
		assertTrue(v1.hashCode()==(v3.hashCode()));

	}

}
