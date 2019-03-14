package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Mouse extends Shape {
    public Mouse(Board board, GraphicsContext gc, double x, double y) {
        super(board, gc, x, y);
    }

    @Override
    public void draw() {
        double earSize = SIZE / 2;

        gc.setFill(Color.GRAY);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillOval(x, y, SIZE, SIZE);
        gc.strokeOval(x, y, SIZE, SIZE);

        gc.setFill(Color.BLACK);
        gc.fillOval(x - earSize, y, earSize, earSize);
        gc.strokeOval(x - earSize, y, earSize, earSize);

        gc.fillOval(x + SIZE, y, earSize, earSize);
        gc.strokeOval(x + SIZE, y, earSize, earSize);
    }
}
