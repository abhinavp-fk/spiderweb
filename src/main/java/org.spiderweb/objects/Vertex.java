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

    private Map<String, Object> attributes;

	/**
	 * @param node
	 */
	public Vertex(T node) {
		this.node = node;
	}

	/**
	 * @param node
	 * @param attributes
	 */
	public Vertex(T node, Map<String, Object> attributes) {
		this.node = node;
		this.attributes = attributes;
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
        return "Vertex{" +
                "node=" + node +
                ", attributes=" + attributes +
                '}';
    }
}
