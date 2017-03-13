package frame;

import javax.swing.*;

import shapes.MyLine;
import shapes.MyOval;
import shapes.MyRect;
import shapes.MyShape;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

/**
 * Created by TaiaLeite on 03/01/2017.
 * DrawPanel will generates the area for user to paint.
 * It give options to user to paint lines, ovals and rects to the screen. shapes can be filled or not
 * DrawPanel also clean lastShape, clean allShapes and undo last action
 */
public class DrawPanel extends JPanel {
    private MyShape shapes[];//array that store all shapes
    private int shapeCount; // counts the number of shapes in the array
    private int shapeType; //determines the type of shape to draw.
    private MyShape currentShape; //represents the current shape the user is drawing.
    private Color currentColor; //represents the current drawing color.
    private boolean filledShape; // determines whether to draw a filled shape.
    private JLabel statusLabel; //represents the status bar. The status bar will display the coordinates of the current
    // mouse position

    /**
     * Constructor for DrawPanel that has a single JLabel parameter. In the constructor, initialize statusLabel
     * with the value passed to the parameter. Also initialize array shapes with 100 entries, shapeCount to 0, shapeType
     * to the value that represents a line, currentShape to null and currentColor to Color.BLACK. The constructor will
     * set the background color of the Draw-Panel to Color.WHITE and register the MouseListener and
     * MouseMotionListener.
     */
    public DrawPanel(JLabel status) {
        this.statusLabel = status;
        shapes = new MyShape[100];
        shapeCount = 0;
        shapeType = 0; //initialize shapeType to the value that represents a line
        currentShape = null;
        currentColor = Color.BLACK;
        filledShape = false;

        setBackground(Color.WHITE);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    /**
     * paintComponent that draws the shapes in the array if currentShape is not null
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shapeCount != 0) {
            for (int i = 0; i < shapeCount; i++) {//Interacting through the array using shapeCount
                shapes[i].draw(g);
            }
        }
        if (currentShape != null) {//If current shape is not null draw a shape
            currentShape.draw(g);//New shape is drew based in Type chosen - 0 Line, 1 Oval, 2 Rect
        }
    }

    /**
     * Method clearLastShape clear the last shape drawn by decrementing instance variable shapeCount.
     * shapeCount is never less than zero.
     */
    public void clearLastShape() {
        if (shapeCount != 0) {
            shapeCount--;
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Panel is already empty!");
        }
    }

    /**
     * Method clearDrawing remove all the shapes in the current drawing by setting shapeCount to zero.
     */
    public void clearDrawing() {
        shapeCount = 0;
        repaint();
    }

    /**
     * Set methods for the shapeType, currentColor and filledShape.
     */
    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void setFilledShape(boolean filledShape) {
        this.filledShape = filledShape;
    }

    @Override
    public String toString() {
        return "DrawPanel{" +
                "shapes=" + Arrays.toString(shapes) +
                ", shapeCount=" + shapeCount +
                ", shapeType=" + shapeType +
                ", currentShape=" + currentShape +
                ", currentColor=" + currentColor +
                ", filledShape=" + filledShape +
                ", statusLabel=" + statusLabel +
                '}';
    }

    /**
     * Class DrawPanel provide event handling to enable the user to draw with the mouse. It has a single inner
     * class that both extends MouseAdapter and implements MouseMotionListener to handle all mouse events in one class.
     */
    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        /**
         * It assigns currentShape a new shape of the type specified by shapeType and
         * initializes both points to the mouse position.
         */
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if (shapeType == 0) {//Line Type
                currentShape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), currentColor);
            } else if (shapeType == 1) {//Rect Type
                currentShape = new MyRect(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
            } else if (shapeType == 2) {//Oval Type
                currentShape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(), currentColor, filledShape);
            }
        }

        /**
         * mouseReleased finish drawing the current shape and place it in the array.
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            currentShape.setX2(e.getX());//Setting the second point of currentShape to current mouse position
            currentShape.setY2(e.getY());
            shapes[shapeCount] = currentShape;//Putting the new shape into the array
            shapeCount++;//Increasing Array
            currentShape = null;//Setting currentShape to null
            repaint();
        }

        /**
         * Method mouseMoved to set the text of the statusLabel so that it displays the mouse coordinates—this will
         * update the label with the coordinates every time the user moves (but does not drag) the mouse within the
         * DrawPanel.
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            statusLabel.setText(String.format("Mouse Moved at [%d, %d]", e.getX(), e.getY()));
        }

        /**
         * It sets the second point of the currentShape to the current mouse position and calls method repaint.
         * This will allow the user to see the shape while dragging the mouse. Also, update the JLabel in mouseDragged
         * with the current position of the mouse.
         */
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            statusLabel.setText(String.format("Mouse Dragged at [%d, %d]", e.getX(), e.getY()));
            repaint();
        }
    }
}
