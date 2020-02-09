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

    @Override
    public void union(int p, int q) {
        //joins the first tree to the second tree
        int topOfP = findTop(p);
        int topOfQ = findTop(q);
        if(topOfP != topOfQ) {
            if(sizeOfTree[topOfP] <= sizeOfTree[topOfQ] ) {
                pointSets[topOfP] = pointSets[topOfQ];
                sizeOfTree[topOfQ] = sizeOfTree[topOfQ] + sizeOfTree[topOfP];
            }

            if(sizeOfTree[topOfQ] < sizeOfTree[topOfP] ){
                pointSets[topOfQ] = pointSets[topOfP];}
                sizeOfTree[topOfP] = sizeOfTree[topOfQ] + sizeOfTree[topOfP];

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
