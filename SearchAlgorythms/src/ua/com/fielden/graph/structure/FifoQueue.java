package ua.com.fielden.graph.structure;

import java.util.LinkedList;
import java.util.Queue;

import ua.com.fielden.graph.Vertex;

public class FifoQueue implements MyQueue {
	final Queue<Vertex> q = new LinkedList<>();

	@Override
	public FifoQueue add(final Vertex vertex) {
		q.add(vertex);
		return this;
	}

	@Override
	public Boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public FifoQueue remove() {
		q.remove();
		return this;
	}

}
