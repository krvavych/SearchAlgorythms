package fielden.com.ua.search;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Graph {
	public Edge edge;
	public Set<Vertex> verexes = new HashSet<Vertex>();
	public Set<Edge> edges = new HashSet<Edge>();

	public void addEdge(Edge edge) {
		final Vertex sorsV = ((Edge) this.edges).getSourseVertex();
		List<Vertex> srcNeighbors = new ArrayList<Vertex>();
		srcNeighbors.add(sorsV);
		final Vertex destV = ((Edge) this.edges).getDestinationVertex();
		srcNeighbors.add(destV);
	}
	public Iterable<Vertex> getNeighbors(Vertex vertex) {
		final Vertex sV = ((Edge) this.edges).getSourseVertex();
		final Vertex dV = ((Edge) this.edges).getDestinationVertex();
		List<Vertex> neighbors = new ArrayList<Vertex>();
		neighbors.add(sV);
		neighbors.add(dV);
		return Collections.unmodifiableList(neighbors);
	}
	public static void BFS(Graph g, String vertex) {
		final Iterator<String> graph1 = new BreadthFirstIterator(g, vertex);
		while (graph1.hasNext()) {
			System.out.print(graph1.next() + ' ');
		}
	}
	public static void DFS(Graph g, String vertex) {
		final Iterator<String> graph2 = new DeapthFirstIterator(g, vertex);
		while (graph2.hasNext()) {
			System.out.print(graph2.next() + ' ');
		}
	}
	public static void main(String[] args) {
		final Graph d = new Graph();
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("a")).setDestinationVertex(d.edge.destinationVertex.setName("b")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("b")).setDestinationVertex(d.edge.destinationVertex.setName("a")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("d")).setDestinationVertex(d.edge.destinationVertex.setName("b")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("b")).setDestinationVertex(d.edge.destinationVertex.setName("d")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("c")).setDestinationVertex(d.edge.destinationVertex.setName("b")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("b")).setDestinationVertex(d.edge.destinationVertex.setName("c")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("c")).setDestinationVertex(d.edge.destinationVertex.setName("d")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("d")).setDestinationVertex(d.edge.destinationVertex.setName("c")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("c")).setDestinationVertex(d.edge.destinationVertex.setName("h")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("h")).setDestinationVertex(d.edge.destinationVertex.setName("c")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("c")).setDestinationVertex(d.edge.destinationVertex.setName("f")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("f")).setDestinationVertex(d.edge.destinationVertex.setName("c")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("c")).setDestinationVertex(d.edge.destinationVertex.setName("g")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("g")).setDestinationVertex(d.edge.destinationVertex.setName("c")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("f")).setDestinationVertex(d.edge.destinationVertex.setName("g")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("g")).setDestinationVertex(d.edge.destinationVertex.setName("f")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("f")).setDestinationVertex(d.edge.destinationVertex.setName("e")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("e")).setDestinationVertex(d.edge.destinationVertex.setName("f")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("g")).setDestinationVertex(d.edge.destinationVertex.setName("e")));
		d.addEdge(d.edge.setSourseVertex(d.edge.sourseVertex.setName("e")).setDestinationVertex(d.edge.destinationVertex.setName("g")));
		BFS(d, "a");
		System.out.println();
		DFS(d, "d");
	}
}