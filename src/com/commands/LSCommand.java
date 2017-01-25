package com.commands;

import com.Entity.Node;
import com.DirectorySystem.NodePath;

import java.util.Map;
import java.util.Stack;

/**
 * Created by siddhahastmohapatra on 18/01/17.
 */
public class LSCommand extends Command {

    public LSCommand(NodePath path, Node currentNode, Stack<Node> stack){
        super(path);
        super.currentNode = currentNode;
        super.stack = stack;
    }

    @Override
    public Node execute() {
        Map<String, Node> map = currentNode.getFolders();
        for(Map.Entry<String, Node> entry: map.entrySet()){
            System.out.println(entry.getKey());
        }
        return currentNode;
    }
}
