package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Food {


    private SimplegfxGrid grid;
    private boolean dead = false;
    private GridPosition pos;
    //private Ellipse ellipse;
    private Rectangle rectangle;
    private Picture picture;

    public Food(GridPosition pos, SimplegfxGrid grid) {
        this.grid = grid;
        this.pos= pos;
        /*this.ellipse = new Ellipse(Math.ceil(Math.random()*grid.getWidth()), Math.ceil(Math.random()*grid.getHeigth()),grid.getCellsize(),grid.getCellsize());
        this.ellipse.setColor(Color.CYAN);
        this.ellipse.fill();*/
        int randomX = grid.getPadding() + grid.getCellsize() * (int) (Math.random() * grid.getCols());
        int randomY = grid.getPadding() + grid.getCellsize() * (int) (Math.random() * grid.getRows());
        // System.out.println("X " + randomX);
        // System.out.println("Y " + randomY);
        //this.rectangle = new Rectangle(randomX, randomY, grid.getCellsize(), grid.getCellsize());
        //rectangle.setColor(Color.MAGENTA);
        //rectangle.fill();
        this.picture = new Picture(randomX,randomY, "snakeApple.jpg");
        picture.draw();
    }

    public int getX() {
        //return rectangle.getX();
        return picture.getX();
    }

    public int getY() {
        //return rectangle.getY();
        return picture.getY();
    }

    public GridPosition getPos() {
        return pos;
    }


    public void setDead() {
        dead = true;
        //rectangle.delete();
        picture.delete();
    }

    public void delete() {
        //this.rectangle.delete();
        this.picture.delete();
    }
}
