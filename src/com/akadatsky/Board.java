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

        ballList.add(new Ball(20, 30, 30, 3, 1.5, gc, ballList));
        ballList.add(new Ball(30, 40, 30, 3, 2.5, gc, ballList));
        ballList.add(new Ball(40, 50, 30, 2, 4.5, gc, ballList));
        ballList.add(new Ball(50, 50, 30, 2, 4.5, gc, ballList));
        ballList.add(new Ball(27, 50, 30, 2, 5.5, gc, ballList));
        ballList.add(new Ball(27, 50, 30, 2, 6.5, gc, ballList));
        ballList.add(new Ball(28, 50, 30, 2, 1.5, gc, ballList));
        ballList.add(new Ball(26, 50, 30, 2, 2.5, gc, ballList));
        ballList.add(new Ball(28, 50, 30, 4, 20, gc, ballList));
        ballList.add(new Ball(35, 50, 30, 3, 30, gc, ballList));
        ballList.add(new Ball(100, 50, 30, 5, 4.5, gc, ballList));


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
        ballList.get(3).draw();
        ballList.get(4).draw();
        ballList.get(5).draw();
        ballList.get(6).draw();
        ballList.get(7).draw();
        ballList.get(8).draw();
        ballList.get(9).draw();
        ballList.get(10).draw();
    }

    public void renderNextFrame() {
        ballList.get(0).move();
        ballList.get(1).move();
        ballList.get(2).move();
        ballList.get(3).move();
        ballList.get(4).move();
        ballList.get(5).move();
        ballList.get(6).move();
        ballList.get(7).move();
        ballList.get(8).move();
        ballList.get(9).move();
        ballList.get(10).move();
    }

    private void clean() {
        GC.clearRect(0, 0, GC.getCanvas().getWidth(), GC.getCanvas().getHeight());
        GC.setFill(Color.LIGHTGRAY);
        GC.fillRoundRect(0, 0, GC.getCanvas().getWidth(), GC.getCanvas().getHeight(), 0, 0);
    }

}