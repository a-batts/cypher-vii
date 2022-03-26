package com.ajea.gametree;

import java.io.File;
import java.io.FileNotFoundException;

public class GameTree {
    private File dialogFile;
    private final TreeNode root = new TreeNode();

    public GameTree(String fileName){
        //Try and load resources file
        try{ setFile(fileName); }
        catch(FileNotFoundException e){
            System.out.println("Error - resources were not able to be loaded");
        }

        setUpTree();
    }

    private void setUpTree(){
        //NEED TO IMPLEMENT
        //Read from json file and import everything into tree nodes
        File dialog = dialogFile;
    }

    private void setFile(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        if (f.exists())
            dialogFile = f;
        else
            throw new FileNotFoundException();
    }
}
