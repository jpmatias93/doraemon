package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.File;

public class Game implements KeyboardHandler {

    private SimplegfxGrid grid;
    private Snake snake;
    private int delay;
    private Tail tail;
    private Doraemon doraemon;
    private Food food;
    private Gigante gigante;
    private int score;
    private Keyboard keyboard;
    private Picture pic;
    private File audioFile;


    public Game(int col, int row, int delay) {
        grid = new SimplegfxGrid(col, row);
        this.delay = delay;
        this.keyboard = new Keyboard(this);
    }

    public int mvUp =0, mvDown = 0, mvLeft = 0, mvRight = 0;
    Clip audioClipGame;


    public void init() {

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(space);

        //this.pic = new Picture(0, 0, "intro.png");
        //pic.draw();
        grid.init();

        audioFile = new File("/Users/codecadet/projects/snakeMaster/snake/Resources/doraemonGame.wav");

        try {

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClipGame = (Clip) AudioSystem.getLine(info);
            audioClipGame.open(audioStream);
            audioClipGame.start();


            System.out.println("Punch");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


        /*snake = new Snake(grid);
        snake.setSimplegfxGrid(grid);
        snake.Snakekeyboard(snake);
        tail = new Tail (grid, snake);
        tail.setSimplegfxGrid(grid);
        */
        doraemon = new Doraemon(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        food = new Food(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        gigante = new Gigante(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        if (e.getKey() == KeyboardEvent.KEY_SPACE) {
            try {
                start();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
    }

    public void start() throws InterruptedException {
        //grid.init();
        //doraemon = new Doraemon(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        //food = new Food(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        //gigante = new Gigante(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);

        while (true) {
            Thread.sleep(delay);
            doraemon.move();
            gigante.move();

            System.out.println(doraemon.getX());
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
                audioClipGame.close();
                break;
            }

            if (doraemon.getX() == gigante.getX() && doraemon.getY() == gigante.getY()) {
                doraemon.setDead();

                System.out.println("GAME OVER");
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
