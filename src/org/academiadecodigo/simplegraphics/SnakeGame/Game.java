package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {

    private SimplegfxGrid grid;
    private Snake snake;
    private int delay;

    public Game(int col, int row, int delay) {
        grid = new SimplegfxGrid(col, row);
        this.delay = delay;
    }

    public void init() {
        grid.init();
        snake = new Snake(grid);
        snake.setSimplegfxGrid(grid);
        snake.Snakekeyboard(snake);

    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(delay);

            snake.move(snake.getDirection(),snake.getPicture());
            snake.move(snake.getDirection(),snake.getTail());
        }
    }

}
