package ua.com.fielden.graph.visitors;

import ua.com.fielden.graph.Vertex;

public class VertexPrinter implements IVertexVisitor {

	private int count = 0;

	@Override
	public void visit(final Vertex vertex) {
		System.out.println( ++count +":"+ vertex.getElement());
	}

}
