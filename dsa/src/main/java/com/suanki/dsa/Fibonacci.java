package com.suanki.dsa;

public class Fibonacci {

    /**
     *
     * @param limit
     * How it works:
     *
     * 1. Start with the two first Fibonacci numbers 0 and 1.
     *    a. Add the two previous numbers together to create a new Fibonacci number.
     *    b. Update the value of the two previous numbers.
     *
     */
    public static int[] fibonacci(int limit){

        int first = 0;
        int second = 1;
        int next = 1;
        int [] fibnum = new int[limit];

        for(int num=0;num<limit;num++){

            if(num == 0){
                fibnum[0] = first;
            }
            else if(num == 1){
                fibnum[1] = second;
            }
            else {
                fibnum[num] = next;
                next = first + second;
            }

            first = second;
            second = next;
        }

        return fibnum;
    }
    //0 ,1,1,2,3,
    // limit 20, num=0, first=0, second=1, next=1  0/p 1
    //limit 20, num=1, first=1,second=1, next=2   0/p  2
    //limit 20, num=2, first=1,second=2, next=3   o/p  3
    //limit 20, num=3, first=2,second=3, next=5   o/p  5
}
