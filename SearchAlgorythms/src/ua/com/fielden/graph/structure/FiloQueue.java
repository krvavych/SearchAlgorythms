package ua.com.fielden.graph.structure;

import java.util.Stack;

import ua.com.fielden.graph.Vertex;

public class FiloQueue implements MyQueue {
	final private Stack<Vertex> stack = new Stack<>();

	@Override
	public FiloQueue add(final Vertex vertex) {
		stack.push(vertex);
		return this;
	}

	@Override
	public Boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public FiloQueue remove() {
		stack.pop();
		return this;
	}

}
