package ua.com.fielden.graph.visitors;

import ua.com.fielden.graph.Vertex;


public class FindCount implements IVertexVisitor {

	private int count = 0;

	@Override
	public void visit(final Vertex vertex) {
		count = count + 1;
	}

	public int count() {
		return count;
	}

}
