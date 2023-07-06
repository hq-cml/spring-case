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
            case "case3":
                cs.Case3();
                break;
            case "case4":
                cs.Case4();
                break;
            case "case5":
                cs.Case5();
                break;
            case "case6":
                cs.Case6();
                break;
            case "case7":
                cs.Case7();
                break;
            case "case8":
                cs.Case8();
                break;
            case "case9":
                cs.Case9();
                break;
            case "case10":
                cs.Case10();
                break;
            case "case11":
                cs.Case11();
                break;
            case "case12":
                cs.Case12();
                break;
            case "case13":
                cs.Case13();
                break;
            default:
                System.out.println("Not support");
        }
    }
}
