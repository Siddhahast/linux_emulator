package com.commands;

import com.DirectorySystem.NodePath;
import com.Entity.Node;

import java.util.Stack;

/**
 * Created by siddhahastmohapatra on 18/01/17.
 */
public class CommandGenerator {

    public CommandGenerator(){

    }

    public Command generateCommand(String input, NodePath path, Node currentNode, Stack<Node> stack){
        String[] inputs = input.split(" ");
        Command c =  ResolveCommand(inputs, path, currentNode, stack);
        return c;
    }

    private Command ResolveCommand(String[] commands, NodePath path, Node currentNode, Stack<Node> stack){
        Command command = null;
        if(commands.length==1){
            switch (commands[0]){
                case "ls":
                    command = new LSCommand(path, currentNode, stack);
                    break;
                case "pwd":
                    command = new PWDCommand(path, currentNode, stack);
                    break;
            }
        } else if(commands.length == 2){
            switch (commands[0]){
                case "cd":
                    command = new CDCommand(path, currentNode, commands[1], stack);
                    break;
                case "mkdir":
                    command = new MakeDirCommand(path, currentNode, commands[1], stack);
                    break;
                case "rm":
                    command = new RMCommand(path,currentNode, commands[1], stack);
                    break;
                case "session":
                    command = new ClearSessionCommand(path, currentNode, stack);
                    break;
            }
        } else{
            command = new InvalidCommand(path);
        }
        return command;
    }

}
