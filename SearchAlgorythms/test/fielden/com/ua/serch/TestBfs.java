package fielden.com.ua.serch;

import org.junit.Test;

import fielden.com.ua.search.Builder;
import fielden.com.ua.search.Graph;
import fielden.com.ua.search.Vertex;

public class TestBfs {

	@Test
	public void BFS_should_work_correctly() {
		final Builder builder = new Builder();
		final Vertex v1 = builder.addVertex(1, "element1");
		final Vertex v2 = builder.addVertex(2, "element2");
		final Vertex v3 = builder.addVertex(3, "element3");
		final Vertex v4 = builder.addVertex(4, "element4");
		final Vertex v5 = builder.addVertex(5, "element5");
		final Vertex v6 = builder.addVertex(6, "element6");
		builder.addEdge(v1, v2).addEdge(v2, v1).addEdge(v3, v2).addEdge(v2, v3)
				.addEdge(v4, v3).addEdge(v3, v4).addEdge(v2, v5)
				.addEdge(v5, v2).addEdge(v6, v4).addEdge(v4, v6);
		builder.creationAdjacencyLists(builder.getVertexOfMap(), builder.getVertex(), builder.getEdges());
		final Graph g = builder.build(builder);
		g.bfs(g, v1);
	}

}
