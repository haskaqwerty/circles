package haskaqwerty.github;

import javax.swing.*;
import java.awt.*;
public class GameCanvas extends  JPanel{

    private final  GameWindow gameWindow;
    private long lastFrameTime;
    GameCanvas(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        lastFrameTime=System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime=System.nanoTime();
        float deltaTime = (currentTime-lastFrameTime) * 1e-9f;
        lastFrameTime=currentTime;

        gameWindow.OnDrawFrame(this, g, deltaTime);

        try {
            Thread.sleep((int)(1f / 60f) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft(){
        return  0;
    }
    public int getRight(){
        return  getWidth()-1;
    }
    public int getTop(){
        return  0;
    }
    public int getBottom(){
        return  getHeight()-1;
    }
}
