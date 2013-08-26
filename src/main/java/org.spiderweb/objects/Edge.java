package org.spiderweb.objects;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: abhinavp
 * Date: 29/07/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Edge<T> {
	
	private T edge;

    private Map<String, Object> attributes;

    public Edge(){}
    public Edge(T edge, Map<String, Object> attributes) {
        this.edge = edge;
        this.attributes = attributes;
    }

    public Edge(T edge) {
        this.edge = edge;
    }

    /**
	 * @return the edge
	 */
	public T getEdge() {
		return edge;
	}

	/**
	 * @param edge the edge to set
	 */
	public void setEdge(T edge) {
		this.edge = edge;
	}

	/**
	 * @return the attributes
	 */
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

    @Override
    public String toString() {
        return "Edge{" +
                "edge=" + edge +
                ", attributes=" + attributes +
                '}';
    }
}
