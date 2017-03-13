package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by TaiaLeite on 03/01/2017.
 * Draw Frame will create the frame to hold the panel for the Shapes.
 * It will have buttons to drive the user to draw the shapes, a statusBar with mouse move information
 * and a middle panel where user will draw the shape he desires.
 */
public class DrawFrame extends JFrame {
    public DrawFrame() {
        super("Drawing Application");
        JLabel statusBar = new JLabel(" ");
        DrawPanel panel = new DrawPanel(statusBar);
        JPanel components = new JPanel();
        JButton undo = new JButton("Undo");
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.clearLastShape();
            }
        });
        JButton clearAll = new JButton("Clear All");
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.clearDrawing();
            }
        });
        String[] colors = {"Black", "Red", "Green", "Cyan", "Magenta", "Pink",
                "Yellow", "Gray", "Orange", "LightGray", "Blue", "DarkGray", "White"};
        JComboBox color = new JComboBox(colors);
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String colorChoice = (String) color.getSelectedItem();
                panel.setCurrentColor(returnColor(colorChoice));//Call method that return the color representation
            }
        });
        String[] shapes = {"Line", "Rectangle", "Oval"};//Line = 0, Rect = 1, Oval = 2
        JComboBox shapeChoise = new JComboBox(shapes);
        shapeChoise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = shapeChoise.getSelectedIndex();//Getting shape index into the Array shapes
                panel.setShapeType(choice);
            }
        });
        JCheckBox filled = new JCheckBox("Filled");
        filled.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    panel.setFilledShape(true);//Set shape to filled
                else
                    panel.setFilledShape(false);//Set shape to not filled
            }
        });
        components.add(undo);
        components.add(clearAll);
        components.add(color);
        components.add(shapeChoise);
        components.add(filled);

        this.add(components, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(statusBar, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
    }

    /**
     * Check the colorChoice menu to find the currentl
     * selected color, and return the appropriate color Object.
     *
     * @return Color
     */
    private Color returnColor(String color) {
        switch (color) {
            case "Red":
                return Color.red;
            case "Green":
                return Color.green;
            case "Blue":
                return Color.blue;
            case "Cyan":
                return Color.cyan;
            case "Magenta":
                return Color.magenta;
            case "Pink":
                return Color.pink;
            case "Yellow":
                return Color.yellow;
            case "Black":
                return Color.black;
            case "Gray":
                return Color.gray;
            case "Orange":
                return Color.orange;
            case "LightGray":
                return Color.lightGray;
            case "DarkGray":
                return Color.darkGray;
            case "White":
                return Color.white;
            default:
                return Color.white;
        }
    }
}

