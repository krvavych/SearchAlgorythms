package fielden.com.ua.search;

public class Edge {
	final private Integer id;
	final private Vertex sourse;
	final private Vertex destination;
	
	public Edge( Integer id, Vertex sourse, Vertex destination){
		this.id = id;
		this.sourse = sourse;
		this.destination = destination;
	}

	public Integer getId() {
		return id;
	}

	public Vertex getSourse() {
		return sourse;
	}

	public Vertex getDestination() {
		return destination;
	}

	@Override
	public String toString() {
		return  id +" "+ sourse +" "+ destination;
	}

}
