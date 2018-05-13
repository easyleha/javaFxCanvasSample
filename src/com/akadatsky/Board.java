package com.akadatsky;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Board {

    private final GraphicsContext gc;
    private Ball ball;

    public Board(GraphicsContext gc) {
        this.gc = gc;
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
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRoundRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight(), 0, 0);
    }

}
