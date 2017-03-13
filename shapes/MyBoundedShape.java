package shapes;

import java.awt.*;

/**
 * Created by TaiaLeite on 03/01/2017.
 * Class MyBoundedShape will be extended by MyOval and MyRect
 */
public abstract class MyBoundedShape extends MyShape {
    private boolean filling;//Filling the shapes

    /**
     * Class MyBoundedShape should provide a constructor with arguments for the coordinates, color and determining
     * whether the shape is filled.
     * Initializing all instances.
     * <p>
     * Constructor should call the set methods rather than initialize the local variables directly.
     * Constructor will be used by MyOval and MyRect Classes Only.
     * Coordinates, color and determining whether the shape is filled.
     */
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filling) {
        super(x1, y1, x2, y2, color);
        this.filling = filling;
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setFillingFlag(filling);
        setMyColor(color);
    }

    /**
     * Class MyBoundedShape should provide a no-argument constructor.
     */
    public MyBoundedShape() {
        super();
        filling = false;
    }

    /**
     * Create methods to help draw rectangles and ovals
     * It is the smaller of the two x-coordinates values
     */
    public int getUpperLeftX() {
        return Math.min(getX1(), getX2());
    }

    /**
     * It is the smaller of the two y-coordinates values
     */
    public int getUpperLeftY() {
        return Math.min(getY1(), getY2());
    }

    /**
     * The width is the absolute value of the difference between the two x-coordinates values.
     */
    public int getWidth() {
        return Math.abs(getX1() - getX2());
    }

    /**
     * The height is the absolute value of the difference between the two y-coordinates values.
     */
    public int getHeight() {
        return Math.abs(getY1() - getY2());
    }

    public boolean getFillingFlag() {
        return filling;
    }

    public void setFillingFlag(boolean fillingFlag) {
        this.filling = fillingFlag;
    }

    /**
     * Method overridden from parent MyShape
     * It will draw Rectangle and Oval shapes to the Frame based on user inputs
     */
    @Override
    public abstract void draw(Graphics g);

    @Override
    public String toString() {
        return String.format("MyBoundedShape{" +
                "x1=" + getX1() +
                ", y1=" + getY1() +
                ", x2=" + getX2() +
                ", y2=" + getY2() +
                ", fillingFlag=" + getFillingFlag() +
                ", myColor=" + getMyColor() +
                '}', super.toString());
    }
}
