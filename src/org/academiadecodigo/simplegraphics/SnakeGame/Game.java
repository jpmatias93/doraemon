package org.academiadecodigo.simplegraphics.SnakeGame;

public class Game {

    private SimplegfxGrid grid;
    private Snake snake;
    private int delay;
    private Tail tail;
    private Doraemon doraemon;


    public Game(int col, int row, int delay) {
        grid = new SimplegfxGrid(col, row);
        this.delay = delay;
    }

    public void init() {
        grid.init();
        /*snake = new Snake(grid);
        snake.setSimplegfxGrid(grid);
        snake.Snakekeyboard(snake);
        tail = new Tail (grid, snake);
        tail.setSimplegfxGrid(grid);
        */
        doraemon = new Doraemon(this.grid.makeGridPosition(), this.grid);
    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(delay);

            doraemon.move();

           /* snake.snakeMove(snake.getDirection(),snake.getSnakePicture());
            tail.tailMove(tail.getDirection(), tail.getPosition(), tail.getPicture());
*/
        }
    }

}
