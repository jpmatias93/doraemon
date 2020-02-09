package org.academiadecodigo.simplegraphics.SnakeGame;

public interface Grid {

    public void init();

    public int getCols();


    public int getRows();


    public GridPosition makeGridPosition();


    public GridPosition makeGridPosition(int col, int row);





}
