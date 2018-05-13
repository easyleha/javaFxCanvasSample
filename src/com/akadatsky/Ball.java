package com.akadatsky;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {

    private final GraphicsContext GC;

    private int diameter;
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public Ball(GraphicsContext gc) {
        this.GC = gc;
        x = 30;
        y = 30;
        diameter = 20;

        xSpeed = 4;
        ySpeed = 3;
    }

    public void draw() {
        GC.setFill(Color.RED);
        GC.setStroke(Color.BLACK);
        GC.setLineWidth(2);

        GC.fillOval(x, y, diameter, diameter);
        GC.strokeOval(x, y, diameter, diameter);
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

}
