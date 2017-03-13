package shapes;

import java.awt.*;

/**
 * Created by TaiaLeite on 11/12/2016.
 * MyLine class is responsible to create Lines shapes in the Frame
 */
public class MyLine extends MyShape {
    /**
     * Initializing all instances.
     * <p>
     * Constructor should call the set methods rather than initialize the local variables directly.
     * Constructor will be used by MyLine Only.
     * Class MyLine should provide a no-argument constructor and a constructor with arguments
     * for the coordinates and color.
     */
    public MyLine(int xOne, int yOne, int xTwo, int yTwo, Color myColor) {
        setX1(xOne);
        setY1(yOne);
        setX2(xTwo);
        setY2(yTwo);
        setMyColor(myColor);
    }

    /**
     * Class MyLine should provide a no-argument constructor.
     */
    public MyLine() {
        super();
    }

    /**
     * Method overridden from parent MyShape
     * It will draw Rectangle shapes to the Frame based on user inputs
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getMyColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }

    @Override
    public String toString() {
        return String.format("MyLine{" +
                "x1=" + getX1() +
                ", y1=" + getY1() +
                ", x2=" + getX2() +
                ", y2=" + getY2() +
                ", myColor=" + getMyColor() +
                '}', super.toString());
    }
}