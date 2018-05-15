package com.akadatsky;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final GraphicsContext GC;
    private Ball ball;


    public Board(GraphicsContext gc) {
        this.GC = gc;
        ball = new Ball(gc);

        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(20, 30, 30, 3, 1.5, gc));
        ballList.add(new Ball(20, 40, 30, 3, 2.5, gc));
        ballList.add(new Ball(20, 50, 30, 2, 4.5, gc));


    }

    public void keyPressed(KeyCode code) {
        switch (code) {
            case LEFT:
                Logger.log("LEFT pressed");
                break;
            case RIGHT:
                Logger.log("RIGHT pressed");
                break;
        }

    }

    public void draw() {
        clean();
        ball.draw();
    }

    public void renderNextFrame() {
        ball.move();
    }

    private void clean() {
        GC.clearRect(0, 0, GC.getCanvas().getWidth(), GC.getCanvas().getHeight());
        GC.setFill(Color.LIGHTGRAY);
        GC.fillRoundRect(0, 0, GC.getCanvas().getWidth(), GC.getCanvas().getHeight(), 0, 0);
    }

}