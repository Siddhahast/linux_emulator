package com.commands;

import com.DirectorySystem.NodeSystem;
import com.Entity.Node;
import com.DirectorySystem.NodePath;
import com.exceptions.NoSuchPathException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by siddhahastmohapatra on 18/01/17.
 */
public class CDCommand extends Command {

    String directoryName;

    public CDCommand(NodePath path, Node node, String directoryName, Stack<Node> stack){
        super(path);
        super.currentNode = node;
        super.stack = stack;
        this.directoryName = directoryName;
    }

    @Override
    public Node execute() {

        if(directoryName.charAt(0)=='/'){
            directoryName = directoryName.substring(1, directoryName.length());
            path.setNode(NodeSystem.getSystem().getRoot());
        }

        String[] files = directoryName.split("/");
        Queue<String> fileQ = new LinkedList<String>();
        for(int i = 0;i<files.length;i++){
            fileQ.add(files[i]);
        }
        Stack<Node> newStack = new Stack<Node>();

        if(files.length==0 || files[0].equals("")){
            currentNode = NodeSystem.getSystem().getRoot();
            path.setMap(currentNode.getFolders());
            path.setNode(currentNode);
            stack = new Stack<Node>();
        }else{
            Node t = path.traversePath(false, fileQ, newStack);
            if(t==null){
                //No such directory
                System.out.println(new NoSuchPathException().getMessage());
            } else{
                currentNode = t;
                stack = newStack;
                System.out.println("SUCCESS");
            }
        }
        return currentNode;
    }
}
