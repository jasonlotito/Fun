package com.jasonlotito;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;


public class Input {

    private static int LEFT_MOUSE_BUTTON = 0;
    private static int RIGHT_MOUSE_BUTTON = 1;

    private int mouseX;
    private int mouseY;


    private boolean leftButtonDown = false;

    public boolean isRightButtonDown() {
        return rightButtonDown;
    }

    public boolean isLeftButtonDown() {
        return leftButtonDown;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getMouseX() {
        return mouseX;
    }

    private boolean rightButtonDown = false;

    public static void main(String[] argv) {
        Input input = new Input();

    }

    public void pollInput() {
        if (Mouse.isButtonDown(LEFT_MOUSE_BUTTON)) {
            leftButtonDown = true;
            mouseX = Mouse.getX();
            mouseY = Mouse.getY();
        } else {
            leftButtonDown = false;
        }

        if (Mouse.isButtonDown(RIGHT_MOUSE_BUTTON)) {
            rightButtonDown = true;
            mouseX = Mouse.getX();
            mouseY = Mouse.getY();
        } else {
            rightButtonDown = false;
        }
    }
}
