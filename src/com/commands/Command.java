package com.commands;

import com.Entity.Node;
import com.DirectorySystem.NodePath;

import java.util.Stack;

/**
 * Created by siddhahastmohapatra on 18/01/17.
 */
public abstract class Command {

    protected NodePath path;
    protected Node currentNode;
    protected Stack<Node> stack;

    public Command(NodePath nodePath){
        this.path = nodePath;
    }

    public Node getCurrentNode(){
        return currentNode;
    }

    public Stack<Node> getStack(){
        return stack;
    }

    public abstract Node execute();

}
