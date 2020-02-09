package com.company;

public class QuickUnion implements UnionFind {
    private int count;
    private int[] pointSets;


    public QuickUnion (int count){
        this.count=count;
        this.pointSets = new int[count];
        for(int i=0 ; i<pointSets.length ; i++ ) pointSets[i]=i;
    }

    @Override
    public void union(int p, int q) {
        //joins the first tree to the second tree
        int topOfP = findTop(p);
        int topOfQ = findTop(q);
        if(topOfP != topOfQ) {
            pointSets[topOfP] = pointSets[topOfQ];
            count--;
        }
    }

    @Override
    public int find(int p) {
        return pointSets[p];

    }

    @Override
    public int findTop(int p) {
        //finds the top of the tree
        while(p != pointSets[p])
            p=pointSets[p];
        return pointSets[p];

    }


    @Override
    public boolean connected(int p, int q) {
        if(findTop(p) == findTop(q)) return true;
        return false;
    }

    @Override
    public int count() {
        return count;
    }
}
