package com.company;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public abstract class Shape {

    protected double SIZE = 30;

    protected GraphicsContext gc;
    protected double x;
    protected double y;

    private double xSpeed;
    private double ySpeed;

    public Shape(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;

        Random random = new Random();
        xSpeed = 2 + random.nextInt(5);
        ySpeed = 2 + random.nextInt(5);
    }

    public void move() {

        x += xSpeed;
        y += ySpeed;

        if (x + SIZE > gc.getCanvas().getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y + SIZE > gc.getCanvas().getHeight()) {
            ySpeed = -ySpeed;
        }
        if (x < 0) {
            xSpeed = -xSpeed;
        }
        if (y < 0) {
            ySpeed = -ySpeed;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract void draw();
}
