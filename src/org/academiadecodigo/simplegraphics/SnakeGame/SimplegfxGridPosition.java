package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimplegfxGridPosition implements GridPosition {

    private int col;
    private int row;
    private Grid grid;
    private SimplegfxGrid simpleGfxGrid;
    private Rectangle rectangle;
    private Picture doraemon;

    public SimplegfxGridPosition(SimplegfxGrid grid) {
        this.col = (int) (Math.random() * grid.getCols());
        this.row = (int) (Math.random() * grid.getRows());
        this.simpleGfxGrid = grid;
        rectangle = new Rectangle(simpleGfxGrid.columnToX(getCol()), simpleGfxGrid.rowToY(getRow()), simpleGfxGrid.getCellsize(), simpleGfxGrid.getCellsize());
        show();
    }

    public SimplegfxGridPosition(int col, int row, SimplegfxGrid grid) {
        this.col = col;
        this.row = row;
        this.simpleGfxGrid = grid;
        rectangle = new Rectangle(simpleGfxGrid.columnToX(col), simpleGfxGrid.rowToY(row), simpleGfxGrid.getCellsize(), simpleGfxGrid.getCellsize());
        show();
        rectangle.setColor(Color.BLACK);
    }


    public Grid getGrid() {
        return grid;
    }


    public void show() {
        rectangle.fill();
    }


    public void hide() {
        rectangle.delete();
    }


    public boolean equals(GridPosition gridPosition) {
        return this.col == gridPosition.getCol() && this.row == gridPosition.getRow() ? true : false;
    }


    public int getCol() {
        return col;
    }


    public int getRow() {
        return row;
    }


    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }


    public void moveDirection(GridDirection direction)
    {
        int x = simpleGfxGrid.columnToX(getCol());
        int y = simpleGfxGrid.rowToY(getRow());
        System.out.println(getCol());
        System.out.println(getRow());
        switch (direction) {
                case UP:
                    moveUp();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case RIGHT:
                    moveRight();
                    break;
            }

        int x2 = simpleGfxGrid.columnToX(getCol());
        int y2 = simpleGfxGrid.rowToY(getRow());
        System.out.println(getCol());
        System.out.println(getRow());
        rectangle.translate(x2 - x, y2 - y);
    }

    public int getCellsize() {
        return simpleGfxGrid.getCellsize();
    }

    public void moveUp() {
        setPos(getCol(), getRow() - 1);
    }

    public void moveDown() {
        setPos(getCol(), getRow() + 1);
    }

    public void moveLeft() {
        setPos(getCol() - 1, getRow());
    }

    public void moveRight() {
        setPos(getCol() + 1, getRow());
    }


}
