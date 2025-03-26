package com.canrossoft.tictactoe;
import com.canrossoft.tictactoe.ai.IA;
import com.canrossoft.tictactoe.model.Board;
import com.canrossoft.tictactoe.model.Player;
import com.canrossoft.tictactoe.ui.ConsoleUI;
import java.util.Random;
import java.util.Scanner;

//Notas de la version:
// Ya funciona la logica para marcar posiciones de Human
// Tambien la IA puede marcar, pero aun hay defectos porque se sobreescriben las posiciones
// Si pongo caracter, crashea to'

public class TicTacToe {

    public static Boolean isPlaying = false; //Starts on false
    public static Board board = new Board(); //Inicializa el board con N
    public static Player p = new Player("Pepe", 'H'); //Inicializa al Player
    public static IA ia = new IA("Robotnik", 'M');

    public static ConsoleUI console = new ConsoleUI();

    public static void startGame(){
        isPlaying = true;
        console.showWelcome();
        console.print("Player mark: " + p.getMark());
        console.print("Board:");
        board.showBoard();
//        console.print("What is your position? > ");
    }
    public TicTacToe(){
        startGame();
    }
    public static void main(String[] args) {

        Random random = new Random();

        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        console.askPlayerName();
        String input = scanner.nextLine();
        p.setName(input);
        if(input.isEmpty()){
            console.print("Colocando el nombre por default!");
           p.setName("Pepito");
        }
        console.print("Player name: " + p.getName());

        while(board.isPlaying == true) {
            int x_rand = random.nextInt(3);
            int y_rand = random.nextInt(3);
            int x = 0;
            int y = 0;
            console.print("Tell me your move: (Use the board coordinates)");
            p.setPositions(board.getPositions()); //Mostramos el tablero al player
            console.print("X: ");
            x = scanner.nextInt();
            console.print("Y: ");
            y = scanner.nextInt();
            p.markPos(x,y);
            board.setPositions(p.getPositions());
            board.showBoard();
            if(p.getStatus()){
                console.print("Good movement..");
            }
            else {
                console.print("Too bad!!");
                continue;
            }
            console.print("Now my MOVE!");
            if (x_rand != x || y_rand != y){
                console.print("IA X: " + x_rand);
                console.print("IA Y: " + y_rand);
                System.out.println("Aha! one available!");
                ia.setPositions(board.getPositions());
                ia.markPos(x_rand,y_rand);
                board.setPositions(ia.getPositions());
            }
            else {
                System.out.println("Almost human! i did the same movement!");
                console.print("IA X: " + x_rand);
                console.print("IA Y: " + y_rand);
            }
            board.showBoard();
            board.checkBoard();
            if(board.isPlaying==false){
                break;
            }
        }


    }
}