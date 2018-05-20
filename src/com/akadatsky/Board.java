package com.akadatsky;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private final GraphicsContext GC;
    private List<Ball> ballList;


    public Board(GraphicsContext gc) {
        this.GC = gc;

        ballList = new ArrayList<>();

        ballList.add(new Ball(30, 30, 30, 3, 1.5, gc, ballList));
        ballList.add(new Ball(30, 30, 30, 3, 2.5, gc, ballList));
        ballList.add(new Ball(30, 30, 30, 2, 4.5, gc, ballList));

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
        ballList.get(0).draw();
        ballList.get(1).draw();
        ballList.get(2).draw();

    }

    public void renderNextFrame() {
        ballList.get(0).move();
        ballList.get(1).move();
        ballList.get(2).move();

    }

    private void clean() {
        GC.clearRect(0, 0, GC.getCanvas().getWidth(), GC.getCanvas().getHeight());
        GC.setFill(Color.LIGHTGRAY);
        GC.fillRoundRect(0, 0, GC.getCanvas().getWidth(), GC.getCanvas().getHeight(), 0, 0);
    }

}