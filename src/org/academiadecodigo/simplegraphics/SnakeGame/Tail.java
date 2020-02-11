package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tail {

    private Picture tail;
    private Snake snake;
    private Grid grid;
    private GridPosition position;
    private GridDirection direction;
    private SimplegfxGrid simplegfxGrid;



    public Tail(SimplegfxGrid grid, Snake snake) {
        this.snake = snake;
        tail = new Picture(100,200, "doraemon.jpg");
        tail.grow(-150, -200);
        tail.draw();
        direction = snake.getLastDirection();
        System.out.println(direction + " should be the same");
        position  = snake.getPosition();
    }

    public GridPosition getPosition(){
        return snake.getLastPosition();
    }

    public GridDirection getDirection() {
        System.out.println("4" + direction);
        return snake.getLastDirection();
    }

    

    public void tailMove(GridDirection direction, GridPosition position, Picture picture) {

        this.position.moveDirection(direction, picture);



    }


    public Picture getPicture(){
        return tail;
    }

    public void setSimplegfxGrid(Grid grid) {
        this.grid = grid;
    }




}
