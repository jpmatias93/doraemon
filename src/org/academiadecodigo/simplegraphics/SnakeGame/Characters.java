package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Characters {

    private Picture picture;


    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public void delete() {
        picture.delete();
    }

    //public Characters()
}
