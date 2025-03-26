package com.canrossoft.tictactoe.ui;

public class Teletype {
    private static int DELAY = 10;
    static String txt = "Testing Teleype!!";
    public void print(String str){
        if (str.contains("\n"))
        {
            //System.out.println("Contains!");
        }
        else {
            //System.out.println("Not contains!");
            str = str + "\n";
        }
        //Checking if the str contains \n
        for (int c = 0; c < str.length();c++){
            System.out.print(str.charAt(c));
            try {
                Thread.sleep(DELAY);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

    }

}
