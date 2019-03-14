package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Home extends Shape {

    public Home(Board board, GraphicsContext gc, double x, double y) {
        super(board, gc, x, y);
    }

    @Override
    public void draw() {
        double[] xPoints = {x - 5, x + SIZE / 2, x + SIZE + 5};
        double[] yPoints = {y, y - SIZE / 2, y};
        int nPoints = 3;

        gc.setFill(Color.BROWN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.fillPolygon(xPoints, yPoints, nPoints);
        gc.strokePolygon(xPoints, yPoints, nPoints);

        gc.setFill(Color.GREEN);
        gc.fillRect(x, y, SIZE, SIZE);
        gc.strokeRect(x, y, SIZE, SIZE);
    }
}
