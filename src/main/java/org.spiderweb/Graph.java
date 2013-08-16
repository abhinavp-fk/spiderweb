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
public class Graph<V, E>  {

    DirectedGraph<Vertex<V>, Edge<E>> directedGraph;
    
    public Graph() {
        Edge<E> e = new Edge<E>();
       directedGraph = new DefaultDirectedGraph<Vertex<V>,Edge<E>>((Class<? extends Edge<E>>) e.getClass());
	}

    public void addVertex(Vertex<V> vertex){
          directedGraph.addVertex(vertex);
    }

    public void addEdge(Vertex<V> fromVertice, Vertex<V> toVertice, Edge<E> edge){
          directedGraph.addEdge(fromVertice, toVertice, edge);
    }

    public List<Vertex<V>> searchParent(Vertex<V> fromNode, List<Condition> nodeRelationConditions, List<Condition> nodeConditions) {
        List<Vertex<V>> resultSet = new ArrayList<Vertex<V>>();
        findMatchingParents(fromNode, nodeRelationConditions, nodeConditions, resultSet);
        return resultSet;
    }

    boolean attribtuesMatched(Map<String,Object> attributes, List<Condition> conditions, boolean mustHaveConditions)
    {
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

    void findMatchingParents(Vertex<V> vertice, List<Condition> nodeRelationConditions, List<Condition> nodeConditions,List<Vertex<V>> resultSet)
    {
       Set<Edge<E>> edges = directedGraph.incomingEdgesOf(vertice);
        for(Edge<E> edge: edges)
        {
            if(attribtuesMatched(edge.getAttributes(),nodeRelationConditions,false) )
            {
                if(attribtuesMatched(directedGraph.getEdgeSource(edge).getAttributes(),nodeConditions,true))
                {
                    resultSet.add(directedGraph.getEdgeSource(edge));
                }
                findMatchingParents(directedGraph.getEdgeSource(edge), nodeRelationConditions, nodeConditions, resultSet);
            }

        }
    }
}
