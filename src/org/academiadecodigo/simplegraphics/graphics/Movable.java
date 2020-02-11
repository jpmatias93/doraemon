package org.academiadecodigo.simplegraphics.graphics;

/**
 * Methods for moving a shape
 */
public interface Movable {

    /**
     * Moves by a given amount.
     *
     * @param dx the amount by which to snakeMove in x-direction
     * @param dy the amount by which to snakeMove in y-direction
     */
    public void translate(double dx, double dy);

}
