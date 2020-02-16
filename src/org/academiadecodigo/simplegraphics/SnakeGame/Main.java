package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Main {

    public static void main(String[] args) throws InterruptedException {





       Game game = new Game(22,22,200);

       game.init();

       game.start();


        /*


        while(true) {
            System.out.println(((Snake) sprite).getDirection());
            ((Snake) sprite).snakeMove(((Snake) sprite).getDirection());
        }

        */

    }

}
