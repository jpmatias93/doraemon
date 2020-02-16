package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Food {


    private SimplegfxGrid grid;
    private boolean dead = false;
    private GridPosition pos;
    private Picture picture;

    public Food(GridPosition pos, SimplegfxGrid grid) {
        this.grid = grid;
        this.pos= pos;
        int randomX = grid.getPadding() + grid.getCellsize() * (int) (Math.random() * grid.getCols());
        int randomY = grid.getPadding() + grid.getCellsize() * (int) (Math.random() * grid.getRows());

        this.picture = new Picture(randomX,randomY, "doraiaki.png");

    }


    public void draw() {

      picture.draw();
    }


    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public GridPosition getPos() {
        return pos;
    }


    public void setDead() {
        dead = true;
        picture.delete();
    }

    public void delete() {
        this.picture.delete();
    }
}
