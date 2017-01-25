package com.ClientModule;

import com.DirectorySystem.NodePath;
import com.DirectorySystem.NodeSystem;
import com.Entity.Node;
import com.commands.Command;
import com.commands.CommandGenerator;

import java.util.Stack;

/**
 * Created by siddhahastmohapatra on 18/01/17.
 */
public class CommandPrompt {

    private NodeSystem nodeSystem;
    private Node currentNode;
    private Stack<Node> stack;
    private NodePath path;
    private Command command;

    public CommandPrompt(NodeSystem system, Node node){
        this.nodeSystem = system;
        this.currentNode = node;
        this.path = new NodePath(system.getRoot(), system);
        this.stack = new Stack<Node>();
    }

    public void processCommand(String input){
        this.command = new CommandGenerator().generateCommand(input, path, currentNode, stack);
        command.execute();
        currentNode = command.getCurrentNode();
        path.setNode(currentNode);
        path.setMap(currentNode.getFolders());
        stack = command.getStack();
    }

}
