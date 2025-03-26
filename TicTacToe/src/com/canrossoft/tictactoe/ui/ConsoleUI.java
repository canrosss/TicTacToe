package com.canrossoft.tictactoe.ui;
//Esta clase controla la experiencia basica de usuario para Consola*
public class ConsoleUI {

    Teletype tty = new Teletype();

    public void showWelcome(){
        tty.print("Bienvenido a TicTacToe 0.1");
    }

    public void askPlayerName(){
        tty.print("What is your name?");
    }

    public void print(String p){
        tty.print(p);
    }
}
