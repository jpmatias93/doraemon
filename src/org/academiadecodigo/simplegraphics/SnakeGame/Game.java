package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private SimplegfxGrid grid;
    private int delay;
    private int inidelay;
    private Doraemon doraemon;
    private Food food;
    private Gigante gigante;
    private int score;
    private Keyboard keyboard;

    private Picture picture;
    private Gigante suneo;
    private int highscore;

    private Picture pic;


    public Game(int col, int row, int delay) {
        grid = new SimplegfxGrid(col, row);
        inidelay = delay;
        this.delay = delay;
        this.keyboard = new Keyboard(this);
    }

    public void init() {

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(space);


        //this.pic = new Picture(0, 0, "intro.png");
        //pic.draw();
        grid.init();

        picture = new Picture(0, 0, "init.png");
        picture.draw();


    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        try {
            if (e.getKey() == KeyboardEvent.KEY_SPACE) {
                picture.delete();
                grid.draw();
                doraemon.draw();
                food.draw();
            }
            return;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public void keyReleased(KeyboardEvent e) {
    }

    public void start() throws InterruptedException {

        grid.init();
        doraemon = new Doraemon(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        food = new Food(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        gigante = new Gigante(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid, "gigante.png");
        suneo = new Gigante(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid, "suenodireita.png");

        while (true) {
            Thread.sleep(delay);
            doraemon.move();
            gigante.move();
            suneo.move();

            System.out.println(doraemon.getX());
            if (doraemon.getX() == food.getX() && doraemon.getY() == food.getY()) {

                food.setDead();
                food = new Food(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
                food.draw();
                score = score + 2;
            }

            if (score == 0) {
                delay = inidelay;
            }
            if (score > 5) {
                suneo.draw();
                suneo.move();
                delay = 170;
            }
            if (score > 10) {
                gigante.draw();
                gigante.move();
                delay = 125;
            }

            if (score > 15) {
                delay = 100;
            }
            if (score > 30) {
                delay = 50;
            }

            if (doraemon.isDead()) {
                this.picture = new Picture(0, 0, "wasted.png");
                this.picture.draw();
                food.delete();
                gigante.delete();
                suneo.delete();
                score = 0;
                doraemon.setDead();
                gigante.delete();
                suneo.delete();
                grid.delete();


                reset();
                System.out.println("GAME OVER");
                System.out.println("Score: " + score);

                break;
            }

            if (doraemon.getX() == gigante.getX() && doraemon.getY() == gigante.getY()) {
                this.picture = new Picture(0, 0, "wasted.png");
                this.picture.draw();
                food.delete();
                gigante.delete();
                suneo.delete();
                score = 0;
                doraemon.setDead();
                gigante.delete();
                suneo.delete();
                grid.delete();


                reset();
                System.out.println("GAME OVER");
                System.out.println("Score: " + score);
                break;

            }
        }
            if (doraemon.getX() == suneo.getX() && suneo.getY() == doraemon.getY()) {
                this.picture = new Picture(0, 0, "wasted.png");
                this.picture.draw();
                food.delete();
                gigante.delete();
                suneo.delete();
                score = 0;
                doraemon.setDead();
                gigante.delete();
                suneo.delete();
                grid.delete();


                reset();
                System.out.println("GAME OVER");
                System.out.println("Score: " + score);

            }

        }



    public void reset() throws InterruptedException {
        start();
    }



    public void gameOver() throws InterruptedException {
        doraemon.setDead();
        this.picture = new Picture(0, 0, "wasted.png");
        this.picture.draw();
        food.delete();
        gigante.delete();
        suneo.delete();
        score = 0;

        gigante.delete();
        suneo.delete();
        grid.delete();
        reset();

    }
}


