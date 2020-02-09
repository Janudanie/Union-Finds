package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int N = 10;

        QuickUnion alextest = new QuickUnion(N);

        alextest.union(2,3);
        alextest.union(3,4);
        alextest.union(5,6);

        alextest.union(5,2);

        System.out.println(alextest.count());

        for (int x = 0 ; x < 10 ;x++)
            System.out.print(x + " ");
        System.out.println("");


        for (int i = 0 ; i < N;i++)
        {
            System.out.print(alextest.find(i)+ " ");
        }
    }
}
