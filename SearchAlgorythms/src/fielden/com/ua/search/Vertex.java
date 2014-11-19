package fielden.com.ua.search;

public class Vertex {
	private Object element;
	private int id;

	public Vertex(final int id, final Object element) {
		this.element = element;
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(final Object thatVertex) {
		if (this == thatVertex) {
			return true;
		}
		if (thatVertex == null) {
			return false;
		}
		if (getClass() != thatVertex.getClass()) {
			return false;
		}
		final Vertex other = (Vertex) thatVertex;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	public int getId() {
		return id;
	}

	public Vertex setId(final int id) {
		this.id = id;
		return this;
	}

	public Object getElement() {
		return element;
	}

	public Vertex setElement(final Object element) {
		this.element = element;
		return this;
	}

	@Override
	public String toString() {
		return id + this.element.toString();
	}
}
