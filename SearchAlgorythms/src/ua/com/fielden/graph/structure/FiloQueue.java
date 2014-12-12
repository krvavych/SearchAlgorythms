package ua.com.fielden.graph.structure;

import java.util.Stack;

import ua.com.fielden.graph.Vertex;

public class FiloQueue implements IQueue {
	final private Stack<Vertex> stack = new Stack<>();

	@Override
	public FiloQueue push(final Vertex vertex) {
		stack.push(vertex);
		return this;
	}

	@Override
	public Boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Vertex pop() {
		return stack.pop();
	}

}
