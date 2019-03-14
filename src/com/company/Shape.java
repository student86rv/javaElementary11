package com.company;

import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public abstract class Shape {

    protected double SIZE = 30;
    protected Board board;
    protected GraphicsContext gc;
    protected double x;
    protected double y;

    private double xSpeed;
    private double ySpeed;

    public Shape(Board board, GraphicsContext gc, double x, double y) {
        this.board = board;
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

        reverseMove();

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

    private void reverseMove() {
        for (Shape shape : board.getShapes()) {
            if (shape == this) {
                continue;
            }
            if (shape.getDistance(x, y) < SIZE) {
                if (x < shape.getX()) {
                    xSpeed = - Math.abs(xSpeed);
                } else {
                    xSpeed = Math.abs(xSpeed);
                }

                if (y < shape.getY()) {
                    ySpeed = - Math.abs(ySpeed);
                } else {
                    ySpeed = Math.abs(ySpeed);
                }
            }
        }
    }

    public double getDistance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public abstract void draw();
}
