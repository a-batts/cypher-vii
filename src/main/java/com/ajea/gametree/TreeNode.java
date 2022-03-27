package com.ajea.gametree;

import static com.ajea.Main.PLAYER;

public class TreeNode {
    public TreeNode left = null;
    public TreeNode right = null;

    //Optional game dialog displayed before prompt
    public String dialog;
    //Prompt and choices for game action node
    public String prompt;
    public String[] choices;

    public TreeNode(){}

    public TreeNode(TreeNode left, TreeNode right){
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setData(String prompt, String[] choices){
        this.prompt = prompt;
        this.choices = choices;
    }
}
