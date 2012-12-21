package com.jasonlotito;

import com.jasonlotito.shapes.Square;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {
    private long lastFPS;
    private int fps;

    public Main() {

        Input inputHandler = new Input();

        lastFPS = getTime();

        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        initGL();


        int left = 100;
        int bottom = 100;
        int width = 200;
        int height = 200;

        int cleft = left;
        int cbottom = bottom;
        int cwidth = width;
        int cheight = height;

        Square square = new Square(width, height, left, bottom);

        while (!Display.isCloseRequested()) {

//            if (inputHandler.isLeftButtonDown() || inputHandler.isRightButtonDown()) {
//                System.out.println("MOUSE DOWN @ X: " + inputHandler.getMouseX() + " Y: " + inputHandler.getMouseY());
//            }
//
            inputHandler.pollInput();
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            // set the color of the quad (R,G,B,A)
            GL11.glColor3f(0.5f, 0.5f, 1.0f);

            if (inputHandler.isLeftButtonDown()) {
                cleft = inputHandler.getMouseX() - (width/2);
                cbottom = inputHandler.getMouseY() - (height/2);
            }



            // draw quad
            square.setX(cleft);
            square.setY(cbottom);
            square.setWidth(cwidth);
            square.setHeight(cheight);

            square.draw();

            Display.update();
            Display.sync(30);

            updateFPS();
        }

        Display.destroy();
    }

    private static void drawQuad(int cleft, int cbottom, int cwidth, int cheight) {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(cleft, cbottom);
        GL11.glVertex2f(cleft + cwidth, cbottom);
        GL11.glVertex2f(cleft + cwidth, cbottom + cheight);
        GL11.glVertex2f(cleft, cbottom + cheight);
        GL11.glEnd();
    }

    private static void initGL() {
        // init OpenGL
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 0, 600, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    protected long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    protected void updateFPS()
    {
        if(getTime() - lastFPS > 1000) {
            Display.setTitle("FPS " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
    }

    public static void main(String[] args) {
        new Main();
    }
}

