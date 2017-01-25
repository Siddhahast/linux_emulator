package com.EntityDao;
import com.Entity.Node;

import java.util.Map;
/**
 * Created by siddhahastmohapatra on 17/01/17.
 */
public class NodeDAO {

    private Node node;
    private Map<String, Node> map;

    public NodeDAO(Node node){
        this.node = node;
        this.map = node.getFolders();
    }

    public void addNode(String name){
        if(map.get(name)!=null){
            //Raise Exception
        } else{
            map.put(name, new Node(name));
            //Success
        }
    }

    public void deleteNode(String name){
        if(map.get(name)==null){
            //Raise Exception
        } else{
            map.remove(name);
            //Success...
        }
    }

}
