package org.academiadecodigo.simplegraphics.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.File;

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
    private int characters = 0;
    private boolean spaceBar;

    private Characters[] character;
    private CollisionDetector collisionDetector;


    private Picture picture1;
    private Text text;

    private Picture pic;
    private File audioFile;


    public Game(int col, int row, int delay) {
        grid = new SimplegfxGrid(col, row);
        inidelay = delay;
        this.delay = delay;
        this.keyboard = new Keyboard(this);
    }

    public int mvUp =0, mvDown = 0, mvLeft = 0, mvRight = 0;
    Clip audioClipIntroTheme;
    Clip audioClipGame;
    Clip audioGameOver;
    Clip audioEat;
    Clip audioPunch;


    public void init() {

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(space);

        KeyboardEvent esc = new KeyboardEvent();
        esc.setKey(KeyboardEvent.KEY_X);
        esc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(esc);


        grid.init();

        picture = new Picture(grid.getPadding(), grid.getPadding(), "intro.png");
        audioFile = new File("/Users/codecadet/joaomatias/projects/snake/Resources/doraemonIntroTheme.wav");

        try {

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClipIntroTheme = (Clip) AudioSystem.getLine(info);
            audioClipIntroTheme.open(audioStream);
            audioClipIntroTheme.start();



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
        gigante = new Gigante(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid, "gigante.png");
        picture = new Picture(0, 0, "intro.png");
        picture.draw();


    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (e.getKey() == KeyboardEvent.KEY_X) {
            System.exit(1);
        }

        try {
            if (!spaceBar) {
                if (e.getKey() == KeyboardEvent.KEY_SPACE) {
                    picture.delete();
                    //picture1.draw();

                    //text.draw();
                    grid.draw();
                    doraemon.draw();
                    food.draw();
                    suneo.draw();

                    audioClipIntroTheme.close();

                    audioFile = new File("/Users/codecadet/joaomatias/projects/snake/Resources/doraemonGame.wav");

                    try {

                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                        AudioFormat format = audioStream.getFormat();
                        DataLine.Info info = new DataLine.Info(Clip.class, format);
                        audioClipGame = (Clip) AudioSystem.getLine(info);
                        audioClipGame.open(audioStream);
                        audioClipGame.start();

                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }

                }
                spaceBar = true;
                return;
            }
            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {
    }

    public void start() throws InterruptedException {

        //Rectangle rect = new Rectangle(680, 10, 200, 660);
        //Text text = new Text(750, 370, "Score  " + score);
        //rect.setColor(Color.BLACK);
        //rect.fill();
        //Text text = new Text(750, 370, "Score  " + score);
        //text.setColor(Color.WHITE);
        //text.grow(30,20);
        //picture1 = new Picture(500, 70, "doraemonPontos.png");
        //picture1.grow(-330, -370);
        //grid.init();


        doraemon = new Doraemon(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        food = new Food(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
        //gigante = new Gigante(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid, "giganteFinal.png");
        suneo = new Gigante(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid, "suneoFinal2.png");

        character = new Characters[]{doraemon, suneo};

        collisionDetector = new CollisionDetector(character);

        while (true) {
            Thread.sleep(delay);


            doraemon.move();
            //  suneo.draw();
            suneo.move();
            //  gigante.move();

            //collisionDetector.check(doraemon);


            //System.out.println(doraemon.getX());
            if (doraemon.getX() == food.getX() && doraemon.getY() == food.getY()) {

                audioFile = new File("/Users/codecadet/joaomatias/projects/snake/Resources/eatSound.wav");

                try {

                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                    AudioFormat format = audioStream.getFormat();
                    DataLine.Info info = new DataLine.Info(Clip.class, format);
                    audioEat = (Clip) AudioSystem.getLine(info);
                    audioEat.open(audioStream);
                    audioEat.start();

                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }

                food.setDead();
                food = new Food(this.grid.makeGridPosition(grid.getCols(), grid.getRows()), this.grid);
                food.draw();
                score = score + 2;
            }

            if (score == 0) {
                delay = inidelay;
            }
            if (score > 5) {
                characters = 2;
                suneo.draw();
                //suneo.move();
                delay = 170;
            }
            if (score > 10) {
                characters = 3;
                gigante.draw();
                //gigante.move();
                delay = 125;
            }

            if (score > 15) {
                delay = 100;
            }
            if (score > 30) {
                delay = 50;
            }

            if (doraemon.isDead()) {
                audioClipGame.close();
                this.picture = new Picture(grid.getPadding(), grid.getPadding(), "gameover.png");
                this.picture.draw();
                food.delete();
                gigante.delete();
                suneo.delete();
                score = 0;
                doraemon.setDead();
                gigante.delete();
                suneo.delete();
                grid.delete();
                spaceBar = false;
                // System.out.println(doraemon.getX());
                //System.out.println(doraemon.getY());

                audioFile = new File("/Users/codecadet/joaomatias/projects/snake/Resources/pacmanGameOver.wav");

                try {

                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                    AudioFormat format = audioStream.getFormat();
                    DataLine.Info info = new DataLine.Info(Clip.class, format);
                    audioGameOver = (Clip) AudioSystem.getLine(info);
                    audioGameOver.open(audioStream);
                    audioGameOver.start();

                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }

                reset();
                System.out.println("GAME OVER");
                System.out.println("Score: " + score);

                break;
            }


            if (characters >= 3) {
                if (doraemon.getX() == gigante.getX() && doraemon.getY() == gigante.getY()) {
                    audioClipGame.close();
                    doraemon.setDead();
                    this.picture = new Picture(grid.getPadding(), grid.getPadding(), "gameover.png");
                    this.picture.draw();
                    food.delete();
                    gigante.delete();
                    suneo.delete();
                    score = 0;
                    gigante.delete();
                    suneo.delete();
                    grid.delete();

                    audioFile = new File("/Users/codecadet/joaomatias/projects/snake/Resources/punchSound.wav");

                    try {

                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                        AudioFormat format = audioStream.getFormat();
                        DataLine.Info info = new DataLine.Info(Clip.class, format);
                        audioPunch = (Clip) AudioSystem.getLine(info);
                        audioPunch.open(audioStream);
                        audioPunch.start();

                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }


                    audioFile = new File("/Users/codecadet/joaomatias/projects/snake/Resources/pacmanGameOver.wav");

                    try {

                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                        AudioFormat format = audioStream.getFormat();
                        DataLine.Info info = new DataLine.Info(Clip.class, format);
                        audioGameOver = (Clip) AudioSystem.getLine(info);
                        audioGameOver.open(audioStream);
                        audioGameOver.start();

                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }


                    reset();
                    System.out.println("GAME OVER");
                    System.out.println("Score: " + score);
                    break;

                }
            }


            if (suneo.lastX() - 180 == doraemon.lastX() + grid.getCellsize() && suneo.getY() == doraemon.getY() ){
                //if(doraemon.lastX() == suneo.getX() && doraemon.getY() == suneo.getY()){
                doraemon.setDead();
                System.out.println("PUNHETA CRLLL!!!!!!");
                System.out.println(doraemon.getX() + " Doraemon X");
                System.out.println(suneo.getX() + " Suneo X");
                System.out.println(doraemon.getY() + " Doraemon Y");
                System.out.println(suneo.getY() + " Suneo Y");
                //}
            }

            if(doraemon.lastX() - 110  ==  suneo.lastX()  && suneo.getY() == doraemon.getY()){

                System.out.println(doraemon.getX() + " Doraemon X");
                System.out.println(suneo.getX() + " Suneo X");
                System.out.println(doraemon.getY() + " Doraemon Y");
                System.out.println(suneo.getY() + " Suneo Y");

                doraemon.setDead();
            }


              /*  if (doraemon.getX() == suneo.getX() && suneo.getY() == doraemon.getY()) {

            if (characters >= 2) {
                if (doraemon.getX() == suneo.getX() && suneo.getY() == doraemon.getY()) {
                    audioClipGame.close();
                    doraemon.setDead();
                    this.picture = new Picture(grid.getPadding(), grid.getPadding(), "gameover.png");
                    this.picture.draw();
                    food.delete();
                    gigante.delete();
                    suneo.delete();
                    score = 0;
                    gigante.delete();
                    suneo.delete();
                    grid.delete();

                         try {

                        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                        AudioFormat format = audioStream.getFormat();
                        DataLine.Info info = new DataLine.Info(Clip.class, format);
                        audioGameOver = (Clip) AudioSystem.getLine(info);
                        audioGameOver.open(audioStream);
                        audioGameOver.start();

                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }

                    reset();
                    System.out.println("GAME OVER");
                    System.out.println("Score: " + score);
                    break;
                }
                */


        }


    }


    public void reset() throws InterruptedException {
        start();
    }


    public void gameOver() throws InterruptedException {
        audioClipGame.close();
        doraemon.setDead();
        this.picture = new Picture(0, 0, "gameover.png");
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


