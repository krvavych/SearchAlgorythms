package fielden.com.ua.search;

import static org.junit.Assert.*;

import org.junit.Test;

import fielden.com.ua.search.Graph;

public class AlgorythmsTest {

	@Test
	public void algorythms_should_work_corect() {
		final Graph g = new Graph();
		g.addEdge("a","c");
		g.addEdge("c","a");
		g.addEdge("c","d");
		g.addEdge("d","c");
		g.addEdge("a","d");
		g.addEdge("d","a");
		assertEqual(f)
	}

}
