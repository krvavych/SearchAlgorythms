package ua.con.fielden.tests;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import ua.com.fielden.graph.Builder;
import ua.com.fielden.graph.Graph;
import ua.com.fielden.graph.Search;
import ua.com.fielden.graph.Search.SearchBy;
import ua.com.fielden.graph.Vertex;

public class TestForSearch {

	@Test
	public void dfs_search_should_work_correctly() {
		final Builder builder = new Builder();
		final Vertex v1 = new Vertex(1, "a");
		final Vertex v2 = new Vertex(2, "b");
		final Vertex v3 = new Vertex(3, "e");
		final Vertex v4 = new Vertex(4, "c");
		final Vertex v5 = new Vertex(5, "d");
		final Graph g = builder.addVertex(v1).addVertex(v2).addVertex(v3)
				.addVertex(v4).addVertex(v5).addEdge(v1, v2).addEdge(v2, v1)
				.addEdge(v2, v3).addEdge(v3, v2).addEdge(v2, v4)
				.addEdge(v4, v2).addEdge(v5, v3).addEdge(v3, v5).build();
		final LinkedList<Vertex> list = new LinkedList<>();
		list.add(v3);
		list.add(v5);
		list.add(v2);
		list.add(v4);
		list.add(v1);
		final Iterator<Vertex> iter = list.iterator();
		final Search a = new Search(g, SearchBy.Dfs, v3);
		for (final Vertex vertex : a) {
			assertEquals(iter.next(), vertex);
		}
	}

	@Test
	public void bfs_search_should_work_correctly() {
		final Builder builder = new Builder();
		final Vertex v1 = new Vertex(1, "a");
		final Vertex v2 = new Vertex(2, "b");
		final Vertex v3 = new Vertex(3, "e");
		final Vertex v4 = new Vertex(4, "c");
		final Vertex v5 = new Vertex(5, "d");
		final Graph g = builder.addVertex(v1).addVertex(v2).addVertex(v3)
				.addVertex(v4).addVertex(v5).addEdge(v1, v2).addEdge(v2, v1)
				.addEdge(v2, v3).addEdge(v3, v2).addEdge(v2, v4)
				.addEdge(v4, v2).addEdge(v5, v3).addEdge(v3, v5).build();
		final Search a = new Search(g, SearchBy.Bfs, v3);
		final LinkedList<Vertex> list = new LinkedList<>();
		list.add(v3);
		list.add(v2);
		list.add(v5);
		list.add(v1);
		list.add(v4);
		final Iterator<Vertex> iter = list.iterator();
		for (final Vertex vertex : a) {
			assertEquals(iter.next(), vertex);
		}
	}

}
