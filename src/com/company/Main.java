
/* Sample Java application illustrating:
          - use of BUTTONS to move IMAGES
		  - use of a second CLASS
*/

package com.company;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame
{
    public static void main(String[] args)
    {
        DrawingPanel myPanel = new DrawingPanel();
        Main sampleAppln = new Main();
        sampleAppln.setSize(600,600);
        sampleAppln.addWindowListener(new WindowEventHandler());
        sampleAppln.add(myPanel);
        sampleAppln.show();
    }
}

class WindowEventHandler extends WindowAdapter
{
    public void windowClosing(WindowEvent evt)
    {
        System.exit(0);
    }
}

class DrawingPanel extends Panel implements ActionListener
{
    Button left, right, up, down, red, blue ,left_top, left_down, right_top, right_down;
    CustomRectangle myRectangle;

    DrawingPanel()
    {
        left = new Button("Left");
        right = new Button("Right");
        up = new Button("Up");
        down = new Button("Down");

        left_top = new Button("Left Top");
        left_down = new Button("left Down");
        right_top = new Button ("Right top");
        right_down = new Button("Right down");
        red = new Button("Red");
        blue = new Button("Blue");

        add(left);
        add(right);
        add(up);
        add(down);
        add(red);
        add(blue);
        add(left_top);
        add(left_down);
        add(right_top);
        add(right_down);

        left.addActionListener(this);
        right.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);
        red.addActionListener(this);
        blue.addActionListener(this);
        left_top.addActionListener(this);
        left_down.addActionListener(this);
        right_top.addActionListener(this);
        right_down.addActionListener(this);

        myRectangle = new CustomRectangle();
    }

    public void paint(Graphics g)
    {
        myRectangle.drawShape(g);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == left) { myRectangle.setX(-5); }
        if(e.getSource() == left_top){ myRectangle.setX(-5);myRectangle.setY(-5); }
        if(e.getSource() == left_down){ myRectangle.setX(5);myRectangle.setY(5); }
        if(e.getSource() == right_top){ myRectangle.setY(-5);myRectangle.setX(-5); }
        if(e.getSource() == right_down){ myRectangle.setY(5);myRectangle.setX(5); }



        if(e.getSource() == right) { myRectangle.setX(5); }
        if(e.getSource() == up) { myRectangle.setY(-5); }
        if(e.getSource() == down) { myRectangle.setY(5); }
        if(e.getSource() == red) { myRectangle.setColor(255,0,0); }
        if(e.getSource() == blue) { myRectangle.setColor(0,0,128); }
        repaint();
    }
}

class CustomRectangle
{
    private int x,y,width,height;
    Color c;

    int[] carX = new int[]{100,150,150,175,200,200,100,100};
    int[] carY = new int[]{100,100,75,75,100,125,125,100};
    int numOfPoints = 7;

    public CustomRectangle()
    {
        x = 100;
        y = 100;
        width = 100;
        height = 50;
        c = new Color(0,255,0);
    }

    public CustomRectangle(int newX, int newY)
    {
        x = newX;
        y = newY;
        width = 100;
        height = 50;
        c = new Color(0,255,0);
    }

    public CustomRectangle(int newX, int newY, int newWidth, int newHeight, int c1, int c2, int c3)
    {
        x = newX;
        y = newY;
        width = newWidth;
        height = newHeight;
        c = new Color(c1,c2,c3);
    }

    public void setX(int newX)
    {
        x = x + newX;
    }

    public void setY(int newY)
    {
        y = y + newY;
    }

    public void setWidth(int newWidth)
    {
        width = width + newWidth;
    }

    public void setHeight(int newHeight)
    {
        height = height + newHeight;
    }

    public void setColor(int c1, int c2, int c3)
    {
        c = new Color(c1,c2,c3);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void drawShape(Graphics g)
    {
        int[] carXUpdated = new int[carX.length];
        int[] carYUpdated = new int[carY.length];
        for (var i = 0; i < carX.length; i++)
        {
            carXUpdated[i] = carX[i] + x;
        }
        for (var i = 0; i <carY.length; i++)
        {
            carYUpdated[i] = carY[i] + y;
        }

        g.setColor(c);
        //g.fillRect(x,y,width,height);
        g.fillPolygon(carXUpdated,carYUpdated,numOfPoints);
        g.setColor(Color.black);
        g.fillOval(x + 115,y + 115,20,20);
        g.fillOval(x + 165,y + 115,20,20);
        g.setColor(Color.orange);
        g.fillRect(105 + x, 80 + y,30,20);
    }
}


// Add a button to re-colour the shape green.

// Change the hopping distance from 5 pixels to 10 pixels.

