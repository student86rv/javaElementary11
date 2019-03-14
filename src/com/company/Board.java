package com.company;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private GraphicsContext gc;
    private List<Shape> shapes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;
        shapes.add(new Ball(this, gc, 10, 20));
        shapes.add(new Ball(this, gc, 100, 20));
        shapes.add(new Square(this, gc, 10, 300));
        shapes.add(new Square(this, gc, 25, 100));
        shapes.add(new Mouse(this, gc, 50, 250));
        shapes.add(new Mouse(this, gc, 100, 100));
        shapes.add(new Home(this, gc, 200, 200));
        shapes.add(new Home(this, gc, 400, 400));
    }

    public void move() {
        for (Shape shape : shapes) {
            shape.move();
        }
    }

    public void draw() {
        clean();
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    private void clean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }
}
