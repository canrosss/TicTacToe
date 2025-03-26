package com.canrossoft.tictactoe.model;
//Esta clase representa un tablero de TicTacToe de 3x3

public class Board {
    public boolean isPlaying = false;

    private static final int MAX_X = 3;
    private static final int MAX_Y = 3;
    private static final char SPACE = '.';
    private char[][]positions = new char[MAX_X][MAX_Y];

    public void setPositions(char[][] positions) {
        this.positions = positions; // Recibe el una copia del arreglo  del mismo tamaño y lo copia
    }

    public char[][] getPositions() {
        return positions;
    }

    public void showBoard(){
       for(int cell_x = 0;cell_x < positions.length; cell_x++)
       {
           if(cell_x == 0){
               System.out.println("  ---0------1------2---");
           }

           if(cell_x <= positions.length){
               System.out.print(cell_x + " |");
           }
           for(int cell_y = 0;cell_y < positions.length; cell_y++) {
               System.out.print("  " +positions[cell_x][cell_y] + "  | ");
           }
           System.out.println(" ");

           if(cell_x == 2){
               System.out.println("  ---------------------");
           }
       }
    }

    public void initializeBoard(){

        for(int x = 0;x < positions.length; x++)
        {
            for(int y = 0; y < positions.length;y++){
                positions[x][y]=SPACE;
            }
        }
    }

    public void checkBoard(){
        //Robotnik
        if(positions[0][0]=='M' && positions[0][1]=='M' && positions[0][2] == 'M'){
            isPlaying = false;
            System.out.println("Robotnik gana!");
        }

        if(positions[1][0]=='M' && positions[1][2]=='M' && positions[1][3] == 'M'){
            isPlaying = false;
            System.out.println("Robotnik gana!");
        }

        if(positions[0][0]=='M' && positions[0][2]=='M' && positions[0][3] == 'M'){
            isPlaying = false;
            System.out.println("Robotnik gana!");
        }
       //0,0 && 0,1 && 0,2
       if(positions[0][0]=='H' && positions[0][1]=='H' && positions[0][2] == 'H'){
           isPlaying = false;
           System.out.println("Human gana!");
       }

    }

    public Board()
    {
        initializeBoard();
        this.isPlaying = true;
    }



}
