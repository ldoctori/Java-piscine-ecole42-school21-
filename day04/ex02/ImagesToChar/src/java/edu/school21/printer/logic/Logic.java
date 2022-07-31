package edu.school21.printer.logic;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Logic {
    
    private BufferedImage image;
    private Attribute white;
    private Attribute black;

    public Logic(String white, String black, String path) throws IOException {
        image = ImageIO.read(File.class.getResource(path));
        this.white = getColor(white);
        this.black = getColor(black);
    }

    public void printImg() {

        int pixel;

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                pixel = image.getRGB(j, i);
                if ((pixel & 0x00ffffff) == 0) {
                    System.out.print(Ansi.colorize(" ", this.black));
                 }  else {
                    System.out.print(Ansi.colorize(" ", this.white));
                }
            }
                System.out.println();
        }
    }

    private Attribute getColor(String color) throws IOException {
        switch (color) {
            case "BLACK":
                return Attribute.BLACK_BACK();
            case "BLUE":
                return Attribute.BLUE_BACK();
            case "BRIGHT_BLACK":
                return Attribute.BRIGHT_BLACK_BACK();
            case "BRIGHT_BLUE":
                return Attribute.BRIGHT_BLUE_BACK();
            case "BRIGHT_CYAN":
                return Attribute.BRIGHT_CYAN_BACK();
            case "BRIGHT_GREEN":
                return Attribute.BRIGHT_GREEN_BACK();
            case "BRIGHT_MAGENTA":
                return Attribute.BRIGHT_MAGENTA_BACK();
            case "BRIGHT_RED":
                return Attribute.BRIGHT_RED_BACK();
            case "BRIGHT_WHITE":
                return Attribute.BRIGHT_WHITE_BACK();
            case "BRIGHT_YELLOW":
                return Attribute.BRIGHT_YELLOW_BACK();
            case "CYAN":
                return Attribute.CYAN_BACK();
            case "GREEN":
                return Attribute.GREEN_BACK();
            case "MAGENTA":
                return Attribute.MAGENTA_BACK();
            case "RED":
                return Attribute.RED_BACK();
            case "WHITE":
                return Attribute.WHITE_BACK();
            case "YELLOW":
                return Attribute.YELLOW_BACK();   
        }
        throw new IOException("Wrong color!");
    }

    
}
