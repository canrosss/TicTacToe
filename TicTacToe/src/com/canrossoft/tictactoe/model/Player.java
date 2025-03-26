package com.canrossoft.tictactoe.model;

public class Player {
    private int X_pos = 0;
    private int Y_pos = 0;
    private String name = "Unknow";
    private char[][]positions = new char[3][3];
    private char mark = 'X';
    private Boolean status = false;

    public Player(String n, char m){
       setName(n); //name
       setMark(m); //mark
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public void markPos(int x, int y){
        this.X_pos = x;
        this.Y_pos = y;
        if(this.X_pos >= 0 && this.X_pos <=2){
            if(this.Y_pos >=0 && this.Y_pos <=2){

                if(this.positions[X_pos][Y_pos] ==  this.mark || this.positions[X_pos][Y_pos] == this.mark)
                {
                    System.out.println("Position in use by you! try another one!");
                    this.status = false;
                }
                else {
                    this.positions[X_pos][Y_pos] = this.mark;
                    this.status = true;
                }
            }
        }
        else{
            System.out.println("Not valid! out of the range!");
            this.status = false;
        }
    }

    public void setPositions(char[][] positions) {
        this.positions = positions;
    }

    public char[][] getPositions() {
        return positions;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
