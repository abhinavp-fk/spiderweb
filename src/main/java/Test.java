import org.spiderweb.Graph;
import org.spiderweb.objects.Condition;
import org.spiderweb.objects.Edge;
import org.spiderweb.objects.Vertex;
import org.spiderweb.util.ConditionValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: abhinavp
 * Date: 14/08/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args)
    {
        System.out.println("Works");
       // Condition<String> condition = new Condition<String>("size","csmall", Condition.ConditionType.EQUAL);
        Condition<Integer> condition = new Condition<Integer>("size",5, Condition.ConditionType.INLIST);
        //System.out.println(ConditionValidator.validate(10,condition));
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        System.out.println(ConditionValidator.validate(list, condition));
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("size",list);
        Edge<String> st = new Edge<String>("testEdge",params);

        Graph<String,String> graph = new Graph<String, String>();
        Vertex<String> v1 = new Vertex<String>("first",null);
        Vertex<String> v2 = new Vertex<String>("Second",null);

        //graph.addEdge(v1,null,null);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addEdge(v1,v2,st);

        List<Condition> conditionList = new ArrayList<Condition>();
        Condition<Integer> c1 = new Condition<Integer>("size",1, Condition.ConditionType.INLIST);
        conditionList.add(c1);
        System.out.println(graph.searchParent(v2,conditionList,null));
    }
}
