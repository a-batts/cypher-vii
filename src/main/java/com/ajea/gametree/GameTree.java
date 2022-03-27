package com.ajea.gametree;

import com.ajea.FileLoader;
import com.ajea.Main;
import com.google.gson.JsonObject;

public class GameTree {
    private final JsonObject data;
    private final TreeNode root = new TreeNode();

    public GameTree(String fileName){
        FileLoader fl = new FileLoader().loadJSON(fileName);
        data = fl.asJsonObject();
    }

    public GameTree initTree(){
        //Initialize first node
        setData(this.root, 1);
        //Initialize the rest of the story line once it is done
        TreeNode a, b, c, d, f, g, h, i, j, l, m, n, o, q, r, s, t, u, v;

        a = new TreeNode();
        b = new TreeNode();
        setData(a, 2);
        setData(b, 3);
        this.root.setLeft(a);
        this.root.setRight(b);

        c = new TreeNode();
        d = new TreeNode();
        setData(c, 4);
        setData(d, 5);
        a.setLeft(c);
        a.setRight(d);

        f = new TreeNode();
        setData(f, 6);
        b.setLeft(a);
        b.setRight(f);

        g = new TreeNode();
        h = new TreeNode();
        setData(g, 7);
        setData(h, 8);
        c.setLeft(g);
        c.setRight(h);

        i = new TreeNode();
        j = new TreeNode();
        setData(i, 9);
        setData(j, 14);
        d.setLeft(i);
        d.setLeft(j);

        l = new TreeNode();
        setData(l,10);
        f.setLeft(a);
        f.setRight(l);

        m = new TreeNode();
        n = new TreeNode();
        setData(m, 11);
        setData(n, 12);
        h.setLeft(m);
        h.setRight(n);

        o = new TreeNode();
        setData(o, 13);
        i.setLeft(o);
        i.setRight(j);

        q = new TreeNode();
        r = new TreeNode();
        setData(q, 15);
        setData(r, 16);
        n.setLeft(q);
        n.setRight(r);

        s = new TreeNode();
        t = new TreeNode();
        setData(s, 17);
        setData(t, 18);
        j.setLeft(s);
        j.setRight(t);
        
        u = new TreeNode();
        v = new TreeNode();
        setData(u, 19);
        setData(v, 20);
        t.setLeft(u);
        t.setRight(v);

        return this;
    }

    /**
     * Set the prompt and choices for a TreeNode
     * @param node TreeNode
     * @param index index of JSON line
     */
    private void setData(TreeNode node, int index){
        node.setData(getPrompt(index), getChoices(index));
    }

    private String getPrompt(int index){
        JsonObject promptData = data.get(Integer.toString(index)).getAsJsonArray().get(0).getAsJsonObject().get("prompts").getAsJsonArray().get(0).getAsJsonObject();

        return switch (Main.PLAYER.getLevelOfSkill(promptData.get("skill").getAsString()).getLevelInt()) {
            case 2, 3 -> promptData.get("long").toString();
            case 4, 5 -> promptData.get("medium").toString();
            default -> promptData.get("short").toString();
        };
    }

    private String[] getChoices(int index){
        JsonObject choiceData = data.get(Integer.toString(index)).getAsJsonArray().get(0).getAsJsonObject().get("choices").getAsJsonArray().get(0).getAsJsonObject();

        return new String[]{choiceData.get("a").toString(), choiceData.get("b").toString()};
    }

    public TreeNode getRoot(){
        return root;
    }
}
