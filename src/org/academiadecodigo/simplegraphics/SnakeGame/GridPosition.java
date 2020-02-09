package org.academiadecodigo.simplegraphics.SnakeGame;

public interface GridPosition {



    public int getCol();


    public int getRow();


    public void setPos(int col, int row);


    public void moveDirection(GridDirection direction);

    public void show();


    public void hide();





    public boolean equals(GridPosition position);







}
