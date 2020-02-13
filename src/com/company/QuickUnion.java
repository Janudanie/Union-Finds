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
        //joins the tree 'p' to the tree 'q'
        int topOfP = find(p);
        int topOfQ = find(q);
        if(topOfP != topOfQ) {
            pointSets[topOfP] = pointSets[topOfQ];
            count--;
        }
    }

    @Override
    public int find(int p) {
        while(p != pointSets[p])
            p=pointSets[p];
        return pointSets[p];
    }

    @Override
    public boolean connected(int p, int q) {
        if(find(p) == find(q)) return true;
        return false;
    }

    @Override
    public int count() {
        return count;
    }
}
