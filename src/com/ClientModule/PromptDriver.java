package com.ClientModule;

import com.DirectorySystem.NodeSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by siddhahastmohapatra on 19/01/17.
 */
public class PromptDriver {

    public static void main(String[] args) throws Exception{
        NodeSystem system = NodeSystem.getSystem();
        CommandPrompt prompt = new CommandPrompt(system, system.getRoot());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (;;){
            String commandInput = br.readLine();
            prompt.processCommand(commandInput);
        }
    }
}
