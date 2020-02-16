package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

public class Doraemon extends Characters implements KeyboardHandler {



    private GridPosition pos;
    private SimplegfxGrid grid;
    private boolean dead = false;
    private Keyboard keyboard;
    private Picture doraemon;
    private File audioFile;

    protected GridDirection currentDirection;


    public Doraemon(GridPosition pos, SimplegfxGrid grid) {
        this.grid = grid;

        //this.doraemon = new Picture(grid.columnToX(15), grid.rowToY(15), "snakeHeadRight2.jpg");

        //this.doraemon = new Rectangle(grid.columnToX(15), grid.rowToY(15),grid.getCellsize(),grid.getCellsize());
        this.doraemon = new Picture(grid.columnToX(15), grid.rowToY(15), "resources/doraemonRightFinal.png");
        //this.doraemon = new Picture(50,50, "BwPMAyDK_400x400.jpg");
        this.pos = pos;
        keyboard = new Keyboard(this);
        this.currentDirection = GridDirection.DEFAULT;

        init();
    }

    public void draw() {
        doraemon.draw();
    }


    public int getX() {
        return doraemon.getX();
    }

    public int getY() {
        return doraemon.getY();
    }


    public int lastX() {
        return pos.getLastX();
    }

    public int lastY() {
        return pos.getLastY();
    }

    /**
     * Initialize keyboard handlers
     */
    public void init() {
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent faster = new KeyboardEvent();
        faster.setKey(KeyboardEvent.KEY_SPACE);
        faster.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent slower = new KeyboardEvent();
        slower.setKey(KeyboardEvent.KEY_SPACE);
        slower.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(faster);
        keyboard.addEventListener(slower);

    }

    public int mvUp =0, mvDown = 0, mvLeft = 0, mvRight = 0;
    Clip audioClipHitWall;

    public boolean isHittingWall() {
        switch (currentDirection) {
            case LEFT:
                if (doraemon.getX() + grid.getCellsize() == grid.getPadding()) {
                    doraemon.translate(grid.getCellsize(), 0);

                    return true;

                }
            case RIGHT:
                if (doraemon.getX() == grid.getPadding() + grid.getWidth()){
                    //System.out.println(doraemon.getX());
                    doraemon.translate(- grid.getCellsize(), 0);

                    return true;
                }
            case UP:
                if (doraemon.getY() + grid.getCellsize() == grid.getPadding()) {
                    doraemon.translate(0, grid.getCellsize());

                    return true;
                }
            case DOWN:
                if (doraemon.getY() == grid.getPadding() + grid.getHeigth()){
                    doraemon.translate(0, -grid.getCellsize());

                    return true;
                }
        }

        return false;

    }


    public void move() {
        accelerate(currentDirection);
    }

    public boolean isDead(){
        return dead;
    }

    public void setDead(){

        doraemon.delete();
        dead = true;
    }

    public GridPosition getPos() {
        return pos;
    }

    public void accelerate(GridDirection direction) {

        if (isDead()) {
            return;
        }

        this.currentDirection = direction;

        getPos().moveDirection(direction, doraemon);
        if (isHittingWall()) {
           // audioFile = new File("resources/doraemonCrash.wav");

            try {
                InputStream audiosrc = getClass().getResourceAsStream("/resources/doraemonCrash.wav");
                InputStream bufferedIn = new BufferedInputStream(audiosrc);

                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);


                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                audioClipHitWall = (Clip) AudioSystem.getLine(info);
                audioClipHitWall.open(audioStream);
                audioClipHitWall.start();



            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            setDead();

        }
    }





    /**
     * Handles key press events
     *
     * @param keyboardEvent the keyboard event
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            return;
        }

        if (isDead()) {
            return;
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                if (currentDirection == GridDirection.RIGHT) {
                    break;
                }
                currentDirection = GridDirection.LEFT;

                //doraemon.load("comeresquerda.png");

                doraemon.load("resources/doraemonLeftFinal.png");
            break;
            case KeyboardEvent.KEY_D:
                if (currentDirection == GridDirection.LEFT) {
                    break;
                }
                currentDirection = GridDirection.RIGHT;
                //doraemon.load("comerdireita.png");

                doraemon.load("resources/doraemonRightFinal.png");
               break;
            case KeyboardEvent.KEY_W:
                if (currentDirection == GridDirection.DOWN) {
                    break;
                }
                currentDirection = GridDirection.UP;
                //       doraemon.load("snakeHeadUp2.jpg");
                doraemon.load("resources/doraemonUpFinal2.png");
               break;
            case KeyboardEvent.KEY_S:
                if (currentDirection == GridDirection.UP) {
                    break;
                }
                currentDirection = GridDirection.DOWN;
               //   doraemon.load("snakeHeadDown2.jpg");
               doraemon.load("resources/doraemonDown.png");
               break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }


}



