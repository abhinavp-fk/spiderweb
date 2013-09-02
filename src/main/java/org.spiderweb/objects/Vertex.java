package org.spiderweb.objects;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: abhinavp
 * Date: 29/07/13
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vertex<T> {
	
	private T node;

    private Map<String,Map<String, Object>> attributes;

    private String type;
	/**
	 * @param node
	 */
/*	public Vertex(T node) {
		this.node = node;
	}
  */
	/**
	 * @param node
	 * @param attributes
	 */
	public Vertex(T node, String type, Map<String,Map<String, Object>> attributes) {
		this.node = node;
		this.attributes = attributes;
        this.type = type;
	}

	/**
	 * @return the node
	 */
	public T getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(T node) {
		this.node = node;
	}

	/**
	 * @return the attributes
	 */
	public Map<String,Map<String, Object>> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Map<String,Map<String, Object>> attributes) {
		this.attributes = attributes;
	}


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Vertex{" +
                "node=" + node +
                ", attributes=" + attributes +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((node == null) ? 0 : node.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex<T> other = (Vertex<T>) obj;
        if (node == null) {
            if (other.node != null)
                return false;
        } else if (!node.equals(other.node))
            return false;
        return true;
    }
}
