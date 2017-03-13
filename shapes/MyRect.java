package shapes;

import java.awt.*;

/**
 * Created by TaiaLeite on 11/12/2016.
 * MyRect class is responsible to create Rectangles shapes in the Frame
 */
public class MyRect extends MyBoundedShape {
    /**
     * Class MyRect should have a constructor with arguments for the coordinates, color and determining whether
     * the shape is filled.
     * Initializing all instances.
     * <p>
     * Constructor should call the set methods rather than initialize the local variables directly.
     * Constructor will be used by MyOval and MyRect Classes Only.
     * Coordinates, color and determining whether the shape is filled.
     */
    public MyRect(int x1, int y1, int x2, int y2, Color color, boolean filling) {
        super(x1, y1, x2, y2, color, filling);
    }

    /**
     * Class MyRect should provide a no-argument constructor.
     */
    public MyRect() {
        super();
    }

    /**
     * Method overridden from parent MyShape
     * It will draw Rectangle shapes to the Frame based on user inputs
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getMyColor());
        g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        if (getFillingFlag()) {
            //Validating boolean, if is true it will fill the shape
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }

    @Override
    public String toString() {
        return String.format("MyRect{" +
                "x1=" + getX1() +
                ", y1=" + getY1() +
                ", x2=" + getX2() +
                ", y2=" + getY2() +
                ", fillingFlag=" + getFillingFlag() +
                ", myColor=" + getMyColor() +
                '}', super.toString());
    }
}
