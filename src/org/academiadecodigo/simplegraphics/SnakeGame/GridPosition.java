package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Objects;

public interface GridPosition {



    public int getCol();


    public int getRow();


    public void setPos(int col, int row);


    public void moveDirection(GridDirection direction, Picture picture);

    public void show();


    public void hide();

    public int getLastX();

    public int getLastY();



    public boolean equals(GridPosition position);







}
