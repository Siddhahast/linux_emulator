package com.Entity;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by siddhahastmohapatra on 17/01/17.
 */
public class Node {

    String fileName;

    Map<String, Node> map;

    public Node(String fileName){
        this.fileName = fileName;
        map = new HashMap<String, Node>();
    }

    public String getFileName(){
        return fileName;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public Map<String, Node> getFolders(){
        return map;
    }

    public void setMap(Map<String, Node> map){
        this.map = map;
    }

}
