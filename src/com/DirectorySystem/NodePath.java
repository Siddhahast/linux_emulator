package com.DirectorySystem;
import com.Entity.Node;

import java.util.*;

/**
 * Created by siddhahastmohapatra on 17/01/17.
 */
public class NodePath {

    private Node node;
    private Map<String, Node> map;
    private NodeSystem system;

    public NodePath(Node node, NodeSystem system){
        this.node = node;
        this.map = node.getFolders();
        this.system = system;
    }

    public Node traversePath(boolean allowLoopBack, Queue<String> fileTree, Stack<Node> stack){
        Node x = node;
        while(x!=null && !fileTree.isEmpty()){
            String file = fileTree.poll();
            stack.push(x);
            if(x.getFolders().get(file)==null){
                return null;
            } else{
                x = x.getFolders().get(file);
            }
        }
        if(allowLoopBack && !fileTree.isEmpty()){
            return x;
        } else{
            return x;
        }
    }

    public void setNode(Node currentNode){
        this.node = currentNode;
    }

    public void setMap(Map<String, Node> map ){
        this.map = map;
    }






    private Node traversePath(Node x, Queue<String> fileNames, boolean allowLoopBack){
        if(x == null){
            return null;
        }
        if(fileNames.size()==0 || fileNames.isEmpty() || fileNames==null){
            return null;
        }

        if(fileNames.size()==1 && node.getFolders().get(fileNames.peek())!=null){
            return allowLoopBack?x:node.getFolders().get(fileNames.peek());
        }
        String file = fileNames.poll();
        Node child = map.get(file);
        if(child == null){
            return x;
        } else{
            return allowLoopBack?x:traversePath(child, fileNames, allowLoopBack);
        }
    }


}
