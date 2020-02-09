package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Snake implements KeyboardHandler {

    private Grid grid;
    private SimplegfxGrid simplegfxGrid;
    private GridPosition position;
    private GridDirection direction;



    private GridPosition lastPosition;
    private GridDirection lastDirection;


    private Picture snake;



    public Snake(SimplegfxGrid grid) {
        snake = new Picture(200,200,"doraemon.jpg");
        snake.grow(-150, -200);
        snake.draw();
        direction = GridDirection.values()[(int)(Math.random() * GridDirection.values().length)];
        System.out.println(getDirection());
        position = grid.makeGridPosition(100,100);
    }

    public void setSimplegfxGrid(Grid grid) {
       this.grid = grid;
    }

    public GridPosition getPosition() {
        return position;
    }





    public GridDirection getDirection() {
        return direction;
    }



    @Override
    public void keyPressed(KeyboardEvent e) {

    }




    public void move(GridDirection direction) {
        
        position.moveDirection(direction);

    }






    @Override
    public void keyReleased(KeyboardEvent e) {
        /*
        Keyboard k = new Keyboard(this);


        KeyboardEvent eventRight = new KeyboardEvent();
        KeyboardEvent eventDown = new KeyboardEvent();
        KeyboardEvent eventUp = new KeyboardEvent();
        KeyboardEvent eventLeft = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_W);
        eventDown.setKey(KeyboardEvent.KEY_S);
        eventLeft.setKey((KeyboardEvent.KEY_A));
        eventRight.setKey(KeyboardEvent.KEY_D);


        eventDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(eventDown);
        k.addEventListener(eventUp);
        k.addEventListener(eventLeft);
        k.addEventListener(eventRight);
        */

        switch(e.getKey()) {
            case KeyboardEvent.KEY_W:
                direction = GridDirection.UP;
               break;
            case KeyboardEvent.KEY_S:
                direction = GridDirection.DOWN;
                break;
            case KeyboardEvent.KEY_A:
                direction = GridDirection.LEFT;
                break;
            case KeyboardEvent.KEY_D:
                direction = GridDirection.RIGHT;
                break;
        }
    }
}
