package org.academiadecodigo.simplegraphics.SnakeGame;

public enum GridDirection {
    UP,
    DOWN,
    LEFT,
    DEFAULT,
    RIGHT;

    /*public boolean isOpposite(GridDirection direction) {
        return direction.equals(oppositeDirection());
    }

    public GridDirection oppositeDirection() {

        GridDirection opposite = null;

        switch (this) {
            case UP:
                opposite = GridDirection.DOWN;
                break;
            case DOWN:
                opposite = GridDirection.UP;
                break;
            case LEFT:
                opposite = GridDirection.RIGHT;
                break;
            case RIGHT:
                opposite = GridDirection.LEFT;
                break;
            case DEFAULT:
                opposite = GridDirection.RIGHT;
        }

        return opposite;
    }*/

}
