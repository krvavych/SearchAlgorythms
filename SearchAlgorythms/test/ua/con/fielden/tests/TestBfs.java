package ua.con.fielden.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ua.com.fielden.graph.Builder;
import ua.com.fielden.graph.Graph;
import ua.com.fielden.graph.Vertex;
import ua.com.fielden.graph.visitors.VertexPrinter;

public class TestBfs {

	@Test
	public void Bfs_should_work_correctly() {
		final Builder builder = new Builder();
		final Vertex v1 = new Vertex(1, "element1");
		final Vertex v2 = new Vertex(2, "element2");
		final Vertex v3 = new Vertex(3, "element3");
		final Vertex v4 = new Vertex(4, "element4");
		final Vertex v5 = new Vertex(5, "element5");
		final Vertex v6 = new Vertex(6, "element6");
		builder.addVertex(v1).addVertex(v2).addVertex(v3).addVertex(v4)
				.addVertex(v5).addVertex(v6).addEdge(v1, v2).addEdge(v2, v1)
				.addEdge(v3, v2).addEdge(v2, v3).addEdge(v4, v3)
				.addEdge(v3, v4).addEdge(v2, v5).addEdge(v5, v2)
				.addEdge(v6, v4).addEdge(v4, v6);
		final Graph graph = builder.build();
		final List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(4);
		list.add(6);
		assertTrue(list.equals(graph.bfs(v1, new VertexPrinter())));
	}

	@Test
	public void Bfs_should_work_as_expected() {
		final Builder builder = new Builder();
		final Vertex v1 = new Vertex(1, "element1");
		final Vertex v2 = new Vertex(2, "element2");
		final Vertex v3 = new Vertex(3, "element3");
		final Vertex v4 = new Vertex(4, "element4");
		final Vertex v5 = new Vertex(5, "element5");
		final Vertex v6 = new Vertex(6, "element6");
		builder.addVertex(v1).addVertex(v2).addVertex(v3).addVertex(v4)
				.addVertex(v5).addVertex(v6).addEdge(v1, v2).addEdge(v2, v1)
				.addEdge(v3, v1).addEdge(v1, v3).addEdge(v4, v3)
				.addEdge(v3, v4).addEdge(v3, v5).addEdge(v5, v3)
				.addEdge(v6, v4).addEdge(v4, v6);
		final Graph g = builder.build();
		final List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(3);
		list.add(6);
		list.add(1);
		list.add(5);
		list.add(2);
		assertTrue(list.equals(g.bfs(v4, new VertexPrinter())));
	}

}