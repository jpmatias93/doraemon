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
    private Keyboard snakeKeyboard;


    private GridPosition lastPosition;
    private GridDirection lastDirection;


    private Picture snake;
    private Picture tail;

    public Snake(SimplegfxGrid grid) {
        snake = new Picture(200, 200, "doraemon.jpg");
        tail = new Picture(snake.getX() - grid.getCellsize() * 5, snake.getY(), "doraemon.jpg");
        tail.grow(-150, -200);
        tail.draw();
        snake.grow(-150, -200);
        snake.draw();
        direction = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
        System.out.println(getDirection());
        position = grid.makeGridPosition(100, 100);
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


    public void move(GridDirection direction, Picture picture) {

        position.moveDirection(direction, picture);

    }

    public Picture getPicture() {
        return snake;
    }
    public Picture getTail() {return tail;}


    public void setDirection(GridDirection direction) {
        this.direction = direction;
    }


    public void Snakekeyboard(Snake snake) {
        snakeKeyboard = new Keyboard(snake);

        KeyboardEvent eventRight = new KeyboardEvent();
        KeyboardEvent eventDown = new KeyboardEvent();
        KeyboardEvent eventUp = new KeyboardEvent();
        KeyboardEvent eventLeft = new KeyboardEvent();

        eventUp.setKey(KeyboardEvent.KEY_W);
        eventDown.setKey(KeyboardEvent.KEY_S);
        eventLeft.setKey((KeyboardEvent.KEY_A));
        eventRight.setKey(KeyboardEvent.KEY_D);


        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        snakeKeyboard.addEventListener(eventDown);
        snakeKeyboard.addEventListener(eventUp);
        snakeKeyboard.addEventListener(eventLeft);
        snakeKeyboard.addEventListener(eventRight);

    }

    @Override
    public void keyPressed(KeyboardEvent e){
        switch (e.getKey()) {
            case KeyboardEvent.KEY_W:
                setDirection(GridDirection.UP);
                break;
            case KeyboardEvent.KEY_S:
                setDirection(GridDirection.DOWN);
                break;
            case KeyboardEvent.KEY_A:
                setDirection(GridDirection.LEFT);
                break;
            case KeyboardEvent.KEY_D:
                setDirection(GridDirection.RIGHT);
                break;
        }
    };

    @Override
    public void keyReleased(KeyboardEvent e) {

    }


    public class Tail {

        private Picture tail;

        public Tail(SimplegfxGrid grid) {
            tail = new Picture(snake.getX() - grid.getCellsize() * 5, snake.getY(), "doraemon.jpg");
            tail.grow(-150, -200);
            tail.draw();
        }




    }

}
