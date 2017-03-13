package shapes;

import java.awt.*;

/**
 * Created by TaiaLeite on 15/12/2016.
 * Assignment 3: Polymorphism
 * MyShape class is a abstract class and is extended by MyRect, MyOval and MyLine
 * Every shape will use the same variables and methods from MyShape
 */
public abstract class MyShape {
    private int x1; // x-coordinate of first endpoint
    private int y1; // y-coordinate of first endpoint
    private int x2; // x-coordinate of second endpoint
    private int y2; // y-coordinate of second endpoint
    private Color color; // color of the shapes

    /**
     * Constructor to be overridden by child
     */
    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    /**
     * Constructor with no arguments that sets all coordinates to 0 and color to BLACK
     * <p>
     * Will be override by all Shapes
     */
    public MyShape() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.color = Color.BLACK;
    }

    public Color getMyColor() {
        return color;
    }

    public void setMyColor(Color myColor) {
        this.color = myColor;
    }

    /**
     * Generating Getters and Setters for the instances variables,
     * Setters should verify that the arguments is greater or equal to 0 before set the coordinate.
     * If not, set it to 0.
     */
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        if (x1 >= 0) {
            this.x1 = x1;
        } else {
            this.x1 = 0;
        }
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        if (y1 >= 0) {
            this.y1 = y1;
        } else {
            this.x1 = 0;
        }
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        if (x2 >= 0) {
            this.x2 = x2;
        } else {
            this.x2 = 0;
        }
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        if (y2 >= 0) {
            this.y2 = y2;
        } else {
            this.y2 = 0;
        }
    }

    /**
     * This method will draw the shape on the Frame
     * Each child will override this method.
     */
    public abstract void draw(Graphics g);

    @Override
    public String toString() {
        return "MyShape{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                ", color=" + color +
                '}';
    }
}

