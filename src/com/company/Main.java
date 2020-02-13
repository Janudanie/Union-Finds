package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int N = 10;

        QuickUnion nodes = new QuickUnion(N);

        nodes.union(2,3);
        nodes.union(3,4);
        nodes.union(5,6);

        nodes.union(5,2);

        System.out.println(nodes.count());

        for (int x = 0 ; x < 10 ;x++)
            System.out.print(x + " ");
        System.out.println("");


        for (int i = 0 ; i < N;i++)
        {
            System.out.print(nodes.find(i)+ " ");
        }
    }
}
