package com.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyListener2 implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getClickCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int i = e.getButton();
        if (i == 0) {
            System.out.println("左键按下");
        }
        if (i == 1) {
            System.out.println("滚轮按下");
        }
        if (i == 2) {
            System.out.println("右键按下");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
