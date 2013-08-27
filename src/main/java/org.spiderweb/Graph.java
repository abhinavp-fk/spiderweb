package org.spiderweb;


import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.spiderweb.objects.Condition;
import org.spiderweb.objects.Edge;
import org.spiderweb.objects.Vertex;
import org.spiderweb.util.ConditionValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: abhinavp
 * Date: 29/07/13
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Graph<V, E> {

    DirectedGraph<Vertex<V>, Edge<E>> directedGraph;
    
    public Graph() {
        Edge<E> e = new Edge<E>();
        directedGraph = new DefaultDirectedGraph<Vertex<V>,Edge<E>>((Class<? extends Edge<E>>) e.getClass());
	}

    public boolean addVertex(Vertex<V> vertex){
          return directedGraph.addVertex(vertex);
    }

    public boolean addEdge(Vertex<V> fromVertice, Vertex<V> toVertice, Edge<E> edge){
        return directedGraph.addEdge(fromVertice, toVertice, edge);
    }


    public boolean containsVertex(Vertex<V> vertex)
    {
        return directedGraph.containsVertex(vertex);
    }

    public boolean containsEdge(Edge<E> edge)
    {
        return directedGraph.containsEdge(edge);
    }

    boolean attribtuesMatched(Map<String,Object> attributes, List<Condition> conditions, boolean mustHaveConditions)
    {
        System.out.println("Attributes :"+attributes);
        System.out.println("Conditions :"+conditions);
        if(mustHaveConditions==false && (attributes==null ||conditions == null))
            return true;
        if(mustHaveConditions==true && conditions==null)
            return true;

        for(Condition condition : conditions)
        {

            String key = condition.getKey();
            if(mustHaveConditions && (attributes==null ||!attributes.containsKey(key)) )
            {
                return false;
            }
            if(attributes.containsKey(key) && ! ( ConditionValidator.validate(attributes.get(key),condition)) )
            {
                System.out.println("False found where : Matching attribute for key :"+key + " where attribute value :"+attributes.get(key) );
                return false;
            }
        }
        return true;
    }

    void findMatchingParents(Vertex<V> vertex, List<Condition> nodeRelationConditions, List<Condition> nodeConditions,List<V> resultSet)
    {
       Set<Edge<E>> edges = directedGraph.incomingEdgesOf(vertex);
        for(Edge<E> edge: edges)
        {
            if(attribtuesMatched(edge.getAttributes(),nodeRelationConditions,false) )
            {
                System.out.println("Checking for edge "+edge);
                if(attribtuesMatched(directedGraph.getEdgeSource(edge).getAttributes(),nodeConditions,true))
                {
                    resultSet.add(directedGraph.getEdgeSource(edge).getNode());
                }
                findMatchingParents(directedGraph.getEdgeSource(edge), nodeRelationConditions, nodeConditions, resultSet);
            }

        }
    }
    public List<V> searchParents(Vertex<V> fromNode, List<Condition> nodeRelationConditions, List<Condition> nodeConditions) {
        List<V> resultSet = new ArrayList<V>();
        findMatchingParents(fromNode, nodeRelationConditions, nodeConditions, resultSet);
        return resultSet;
    }

    void findMatchingChildren(Vertex<V> vertex, List<Condition> nodeRelationConditions, List<Condition> nodeConditions,List<V> resultSet)
    {
        Set<Edge<E>> edges = directedGraph.outgoingEdgesOf(vertex);
        for(Edge<E> edge: edges)
        {
            if(attribtuesMatched(edge.getAttributes(),nodeRelationConditions,false) )
            {
                if(attribtuesMatched(directedGraph.getEdgeTarget(edge).getAttributes(),nodeConditions,true))
                {
                    resultSet.add(directedGraph.getEdgeTarget(edge).getNode());
                }
                findMatchingChildren(directedGraph.getEdgeTarget(edge), nodeRelationConditions, nodeConditions, resultSet);
            }

        }
    }
    public List<V> searchChildren(Vertex<V> fromNode, List<Condition> nodeRelationConditions, List<Condition> nodeConditions) {
        List<V> resultSet = new ArrayList<V>();
        findMatchingChildren(fromNode, nodeRelationConditions, nodeConditions, resultSet);
        return resultSet;
    }
}
