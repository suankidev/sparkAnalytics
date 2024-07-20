package com.suanki;


public class LinePrinter {


    public static void linetPrinter(){
        System.out.println();

        for(int i=0; i<50; i++){
            System.out.print("=");
        }

        System.out.println();


    }

    private LinePrinter(){
        throw new IllegalStateException("Utility can't be invoked");
    }
}
