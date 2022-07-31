package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Logic {
    
    private BufferedImage image;
    private char white;
    private char black;

    public Logic(char white, char black, String path) throws IOException {

        image = ImageIO.read(new File(path));
        this.white = white;
        this.black = black;
    }

    public void printImg() {

        int pixel;

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                pixel = image.getRGB(j, i);
                if ((pixel & 0x00ffffff) == 0) {
                    System.out.print(this.black);
                 }  else {
                    System.out.print(this.white);
                }
            }
                System.out.println();
        }
    }


    
}
