package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Shape {

    public Ball(Board board, GraphicsContext gc, double x, double y) {
        super(board, gc, x, y);
    }

    @Override
    public void draw() {
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillOval(x, y, SIZE, SIZE);
        gc.strokeOval(x, y, SIZE, SIZE);
    }
}
