package com.akadatsky;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Board {

    private final GraphicsContext GC;
    private Ball ball;


    public Board(GraphicsContext gc) {
        this.GC = gc;
        ball = new Ball(gc);
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
