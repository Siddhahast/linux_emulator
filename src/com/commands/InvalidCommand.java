package com.commands;

import com.Entity.Node;
import com.DirectorySystem.NodePath;

/**
 * Created by siddhahastmohapatra on 18/01/17.
 */
public class InvalidCommand extends Command{

    public InvalidCommand(NodePath path){
        super(path);
    }

    @Override
    public Node execute() {
            return currentNode;
    }
}
