package com.company;

public class WeightedUnion implements UnionFind {
    private int count;
    private int[] pointSets;
    private int[] sizeOfTree;


    public WeightedUnion (int count){
        this.count=count;
        this.pointSets = new int[count];
        this.sizeOfTree = new int[count];
        for(int i=0 ; i<pointSets.length ; i++ ) pointSets[i]=i;
        for(int i=0 ; i<sizeOfTree.length ; i++ ) sizeOfTree[i]=1;
    }

    private void joinTrees(int smallestTree, int biggestTree){
        pointSets[smallestTree] = pointSets[biggestTree];
        sizeOfTree[biggestTree] = sizeOfTree[biggestTree] + sizeOfTree[smallestTree];
    }

    @Override
    public void union(int p, int q) {
        //joins the smallest tree to the largest tree
        int topOfP = find(p);
        int topOfQ = find(q);
        if(topOfP != topOfQ) {
            if(sizeOfTree[topOfP] <= sizeOfTree[topOfQ] ) joinTrees(topOfP,topOfQ);
            if(sizeOfTree[topOfQ] < sizeOfTree[topOfP] ) joinTrees(topOfQ,topOfP);
        count--;
        }
    }

    @Override
    public int find(int p) {
        //finds the top of the tree
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
