package fielden.com.ua.search;

public class Edge {
	private final Vertex sourse, destination;

	public Vertex getSourse() {
		return sourse;
	}

	public Vertex getDestination() {
		return destination;
	}

	public Edge(final Vertex sourse, final Vertex destination) {
		this.sourse = sourse;
		this.destination = destination;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((sourse == null) ? 0 : sourse.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object thatEdge) {
		if (this == thatEdge) {
			return true;
		}
		if (thatEdge == null) {
			return false;
		}
		if (getClass() != thatEdge.getClass()) {
			return false;
		}
		final Edge other = (Edge) thatEdge;
		if (destination == null) {
			if (other.destination != null) {
				return false;
			}
		} else if (!destination.equals(other.destination)) {
			return false;
		}
		if (sourse == null) {
			if (other.sourse != null) {
				return false;
			}
		} else if (!sourse.equals(other.sourse)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return sourse + " -- " + destination;
	}
}
