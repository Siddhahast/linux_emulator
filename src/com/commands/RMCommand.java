package com.commands;

import com.Entity.Node;
import com.DirectorySystem.NodePath;
import com.exceptions.DirectoryAlreadyExistException;
import com.exceptions.NoSuchPathException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by siddhahastmohapatra on 18/01/17.
 */
public class RMCommand extends Command {

    private String directoryName;

    public RMCommand(NodePath path, Node currentNode, String directoryName, Stack<Node> stack){
        super(path);
        super.currentNode = currentNode;
        this.directoryName = directoryName;
        super.stack = stack;
    }

    @Override
    public Node execute() {
        String[] files = directoryName.split("/");
        String makeFile = null;
        Queue<String> fileQ = new LinkedList<String>();
        for(int i = 0;i<files.length;i++){
            if(i==files.length-1){
                makeFile = files[i];
            } else{
                fileQ.add(files[i]);
            }
        }
        boolean allowLoopBack = true;
        Stack<Node> newStack = new Stack<Node>();
        Node t = path.traversePath(allowLoopBack, fileQ, newStack);
        if(t==null){
            //No such directory exist
            System.out.println(new NoSuchPathException().getMessage());
        } else{

            if(t.getFolders().get(makeFile)!=null){
                t.getFolders().remove(makeFile);
                //Success
                System.out.println("SUCCESS");
            } else{
                //Already exist
                System.out.println(new NoSuchPathException().getMessage());
            }
        }
        return currentNode;
    }
}
