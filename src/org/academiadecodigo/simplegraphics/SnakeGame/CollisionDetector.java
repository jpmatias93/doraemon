package org.academiadecodigo.simplegraphics.SnakeGame;

public class CollisionDetector {

    private Characters[] characters;

    public CollisionDetector(Characters[] characters) {
        this.characters = characters;
    }

    /*public boolean isUnsafe(GridPosition position) {
        for (Characters c : characters) {
        }
    }*/

    public void check(Characters character) {

        for (Characters c : characters) {

            if (c == character) {
                continue;
            }

            if (c.getX() == character.getX() && c.getY() == character.getY()) {
                c.delete();
                character.delete();
            }

        }
    }


}
