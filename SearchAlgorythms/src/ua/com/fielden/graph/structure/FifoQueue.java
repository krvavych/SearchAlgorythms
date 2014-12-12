package ua.com.fielden.graph.structure;

import java.util.LinkedList;
import java.util.Queue;

import ua.com.fielden.graph.Vertex;

public class FifoQueue implements IQueue {
	final Queue<Vertex> q = new LinkedList<>();

	@Override
	public FifoQueue push(final Vertex vertex) {
		q.add(vertex);
		return this;
	}

	@Override
	public Boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public Vertex pop() {
		return q.remove();
	}

}
