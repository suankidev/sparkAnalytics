package com.suanki;

import com.suanki.dsa.Fibonacci;
import com.suanki.dsa.FibonacciSc;

import java.util.Arrays;

public class SampleFibonacciMain {


    public static void main(String [] args){

        System.out.println("Hello , Welcome to DSA Learning!");

        LinePrinter.linetPrinter();

                Arrays.stream(Fibonacci.fibonacci(20))
                        .forEach(value -> System.out.println(value));


        LinePrinter.linetPrinter();


 Arrays.stream(FibonacciSc.fibonacci(20)).forEach(
         value -> System.out.println(value)
 );


        LinePrinter.linetPrinter();
    }



    }
