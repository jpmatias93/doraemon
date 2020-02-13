package org.academiadecodigo.simplegraphics.SnakeGame;

public class Game {

    private SimplegfxGrid grid;
    private Snake snake;
    private int delay;
    private Tail tail;
    private Doraemon doraemon;
    private Food food;
    private int score;


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

        System.out.println(doraemon.getPos().getRow());
        System.out.println(doraemon.getPos().getCol());
        System.out.println(food.getPos().getCol());
        System.out.println(food.getPos().getCol());
    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(delay);

            doraemon.move();

            if (doraemon.getX() == food.getX() && doraemon.getY() == food.getY()) {
                food.setDead();
                food = new Food(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
                score = score + 5;
            }

            if (score > 10) {
                delay = 100;
            }
            if (score > 20) {
                delay = 50;
            }
            if (score > 50) {
                delay = 25;
            }

            if (doraemon.isDead()) {
                System.out.println("GAME OVER");
                System.out.println("Score: " + score);
                break;
            }

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
