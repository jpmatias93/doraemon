package org.academiadecodigo.simplegraphics.SnakeGame;

public class Game {

    private SimplegfxGrid grid;
    private Snake snake;
    private int delay;
    private Tail tail;
    private Doraemon doraemon;
    private Food food;


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
        doraemon = new Doraemon(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        food = new Food(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(delay);

            doraemon.move();

            System.out.println("foodRow" + food.getPos().getRow());
            System.out.println("foodCol" + food.getPos().getCol());
            System.out.println("snakeRow" + doraemon.getPos().getRow());
            System.out.println("snakeCol" + doraemon.getPos().getCol());


            /*if (doraemon.getPos().getRow() == food.getPos().getCol() && doraemon.getPos().getCol() == food.getPos().getCol()) {
                System.out.println("comeu");
                food.setDead();
            }*/

           /* snake.snakeMove(snake.getDirection(),snake.getSnakePicture());
            tail.tailMove(tail.getDirection(), tail.getPosition(), tail.getPicture());
*/
        }
    }

}
