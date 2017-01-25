package com.DirectorySystem;

import com.Entity.Node;

import java.util.HashMap;

/**
 * Created by siddhahastmohapatra on 17/01/17.
 */
public class NodeSystem {

    private Node root;

    private static NodeSystem system = new NodeSystem();

    public static NodeSystem getSystem(){
        return system;
    }

    private NodeSystem(){
        root = new Node("/");
    }

    public Node getRoot(){
        return root;
    }

    public void resetRootMap(){
        root.setMap(new HashMap<String, Node>());
    }

}
