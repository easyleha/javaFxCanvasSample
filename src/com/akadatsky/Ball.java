package com.akadatsky;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {

    private final GraphicsContext GC;

    private String name;
    private double diameter;
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;


    public Ball(GraphicsContext gc) {
        this.GC = gc;
        x = 30;
        y = 30;
        diameter = 20;

        xSpeed = 2;
        ySpeed = 1.5;

    }


    public Ball(double diameter, double x, double y, double xSpeed, double ySpeed, GraphicsContext gc) {
        this.diameter = diameter;
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.GC = gc;
    }


    public GraphicsContext getGC() {
        return GC;
    }

    public String getName() {
        return name;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
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

        double MAX_X = GC.getCanvas().getWidth();
        double MAX_Y = GC.getCanvas().getHeight();

        if (x <= 0 || x + diameter >= MAX_X) {
            xSpeed = -xSpeed;
        }

        if (y <= 0 || y + diameter >= MAX_Y) {
            ySpeed = -ySpeed;
        }
    }

}