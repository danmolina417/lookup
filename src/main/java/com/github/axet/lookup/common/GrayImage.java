package com.github.axet.lookup.common;

import java.awt.image.BufferedImage;

public class GrayImage extends SArray {
    public BufferedImage buf;

    public int grey(int x, int y) {
        int argb = buf.getRGB(x, y);

        // int a = (argb & 0xff000000) >> 24;
        int r = (argb & 0x00ff0000) >> 16;
        int g = (argb & 0x0000ff00) >> 8;
        int b = (argb & 0x000000ff);

        return (r + g + b) / 3;
    }

    public GrayImage(BufferedImage buf) {
        this.buf = buf;

        cx = buf.getWidth();
        cy = buf.getHeight();

        s = new double[cx * cy];

        for (int x = 0; x < cx; x++) {
            for (int y = 0; y < cy; y++) {
                s[i(x, y)] = grey(x, y);
            }
        }
    }
}
