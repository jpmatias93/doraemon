package org.academiadecodigo.simplegraphics.SnakeGame;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimplegfxGrid implements Grid {


    private int cols;
    private int rows;
    public static final int PADDING = 10;
    public static final int cellsize = 30;
    private Rectangle field;
    private Picture picture;


    public SimplegfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }


    public void init() {
  //
        field = new Rectangle(PADDING, PADDING + 660, cols * cellsize, cellsize);
        field.setColor(Color.WHITE);
        field.fill();
        //field = new Rectangle(PADDING, PADDING, cols * cellsize, rows * cellsize);

        //xpicture = new Picture(PADDING, PADDING, "snakeField2.jpg");

    }

    public void draw(){
        //field.draw();
        //field = new Rectangle(0, 0, cols * cellsize + 20*PADDING, rows * cellsize + 3*PADDING);
        //field.setColor(Color.WHITE);
        //  field.fill();
        picture = new Picture(PADDING, PADDING, "fundoFinal.png");
        //System.out.println(picture.getWidth());
        //System.out.println(picture.getHeight());
        //System.out.println(picture.pixels());
        picture.draw();
    }

    public void delete(){
        field.delete();
    }


    public int getPadding() {
        return PADDING;
    }

    public int getWidth(){
        return cols * cellsize;
    }


    public int getHeigth(){
        return rows * cellsize;
    }

    public int getX(){
        return field.getX();
    }

    public int getY() {
        return field.getY();
    }

    public int rowToY(int row) {
        return (row * cellsize) + PADDING;
    }

    public int columnToX(int column) {
        return (column * cellsize) + PADDING;

    }


    public GridPosition makeGridPosition(int col, int row) {
        return new SimplegfxGridPosition(col, row, this);
    }

    public int getCellsize() {
        return cellsize;
    }

    public int getCols() {
        return cols;
    }


    public int getRows() {
        return rows;
    }


}
