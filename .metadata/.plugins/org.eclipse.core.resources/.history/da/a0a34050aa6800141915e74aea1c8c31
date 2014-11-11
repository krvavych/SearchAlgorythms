package fielden.com.ua.search;

import java.util.Iterator;

import org.junit.Test;

import fielden.com.ua.search.Graph;
public class tests {

	@Test
	
	 public void algorythms_should_work_corect() {
		final Graph g = new Graph();
		g.addEdge("a","c");
		g.addEdge("c","a");
		g.addEdge("c","d");
		g.addEdge("d","c");
		g.addEdge("a","d");
		g.addEdge("d","a");
		String testString = "acbdb";
		assertEqual( DFS(g,"a"));
	}
}
