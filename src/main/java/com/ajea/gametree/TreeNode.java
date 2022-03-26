package com.ajea.gametree;

public class TreeNode {
    private TreeNode left = null;
    private TreeNode middle = null;
    private TreeNode right = null;

    //Optional game dialog displayed before prompt
    public String dialog;
    //Prompt and choices for game action node
    public String prompt;
    public Choice[] choices;

    public TreeNode(){}

    public TreeNode(TreeNode left, TreeNode middle, TreeNode right){
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getMiddle() {
        return middle;
    }

    public void setMiddle(TreeNode middle) {
        this.middle = middle;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void getChoices(){

    }
}