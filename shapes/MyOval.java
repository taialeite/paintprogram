package shapes;

import java.awt.*;

/**
 * Created by TaiaLeite on 11/12/2016.
 * MyOval class is responsible to create Oval shapes in the Frame
 */
public class MyOval extends MyBoundedShape {
    /**
     * Class MyOval should have a constructor with arguments for the coordinates, color and determining whether
     * the shape is filled.
     * Initializing all instances.
     * <p>
     * Constructor should call the set methods rather than initialize the local variables directly.
     * Constructor will be used by MyOval and MyRect Classes Only.
     * Coordinates, color and determining whether the shape is filled.
     */
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filling) {
        super(x1, y1, x2, y2, color, filling);
    }

    /**
     * Class MyOval should provide a no-argument constructor.
     */
    public MyOval() {
        super();
    }

    /**
     * Method overridden from parent MyShape
     * It will draw Oval shapes to the Frame based on user inputs
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getMyColor());
        g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        if (getFillingFlag()) {
            //Validating boolean, if is true it will fill the shape
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }

    @Override
    public String toString() {
        return String.format("MyOval{" +
                "x1=" + getX1() +
                ", y1=" + getY1() +
                ", x2=" + getX2() +
                ", y2=" + getY2() +
                ", fillingFlag=" + getFillingFlag() +
                ", myColor=" + getMyColor() +
                '}', super.toString());
    }
}
