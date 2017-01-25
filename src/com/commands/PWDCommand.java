package com.commands;

import com.Entity.Node;
import com.DirectorySystem.NodePath;

import java.util.Stack;

/**
 * Created by siddhahastmohapatra on 18/01/17.
 */
public class PWDCommand extends Command{


    public PWDCommand(NodePath path, Node currentNode, Stack<Node> stack){
        super(path);
        super.currentNode = currentNode;
        super.stack = stack;
    }

    @Override
    public Node execute() {
        Stack<Node> copyStack = new Stack<Node>();

        while (!stack.isEmpty()){
            copyStack.push(stack.pop());
        }

        StringBuffer sb = new StringBuffer();
        String s = null;
        while(!copyStack.isEmpty()){
            Node top = copyStack.pop();
            s = top.getFileName();
            sb.append(s+"/");
            stack.push(top);
        }

        System.out.println(new String(sb) + currentNode.getFileName());
        return currentNode;
    }
}
