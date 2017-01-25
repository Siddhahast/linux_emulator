package com.commands;

import com.DirectorySystem.NodePath;
import com.DirectorySystem.NodeSystem;
import com.Entity.Node;

import java.util.Stack;

/**
 * Created by siddhahastmohapatra on 19/01/17.
 */
public class ClearSessionCommand extends Command {


    public ClearSessionCommand(NodePath path,  Node node, Stack<Node> stack){
        super(path);
        super.currentNode = node;
        super.stack = stack;
    }

    @Override
    public Node execute() {
        currentNode = NodeSystem.getSystem().getRoot();
        NodeSystem.getSystem().resetRootMap();
        stack = new Stack<Node>();
        path.setNode(currentNode);
        path.setMap(currentNode.getFolders());
        return null;
    }
}
