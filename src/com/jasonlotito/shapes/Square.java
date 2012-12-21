package com.jasonlotito.shapes;


import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

/**
 * @author Jason Lotito <jasonlotito@gmail.com>
 */
public class Square {
    protected int width;
    protected int height;
    protected int x;
    protected int y;

    public Square(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int left()
    {
        return x;
    }

    public int width()
    {
        return width;
    }

    public int height()
    {
        return height;
    }

    public int right()
    {
        return x+width;
    }

    public int top()
    {
        return y+height;
    }

    public int bottom()
    {
        return y;
    }

    public Vector2f center()
    {
        Vector2f center = new Vector2f(x + (width/2), y + (height/2));

        return center;
    }
    
    public void draw()
    {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(left(), bottom());
        GL11.glVertex2f(left() + width(), bottom());
        GL11.glVertex2f(left() + width(), bottom() + height());
        GL11.glVertex2f(left(), bottom() + height());
        GL11.glEnd();
    }
}
