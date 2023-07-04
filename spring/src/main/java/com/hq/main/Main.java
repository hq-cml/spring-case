package com.hq.main;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Need one arg case!");
            return;
        }

        Cases cs = new Cases();
        String arg = args[0];
        switch (arg) {
            case "case1":
                cs.Case1();
                break;
            case "case2":
                cs.Case2();
                break;
            default:
                System.out.println("Not support");
        }
    }
}
