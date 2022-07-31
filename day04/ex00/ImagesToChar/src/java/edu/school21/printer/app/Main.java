
package edu.school21.printer.app;

import java.io.IOException;
import edu.school21.printer.logic.Logic;

class Main {

    private static char whiteChar;
    private static char blackChar;
    private static String pathToImg;
    public static void main(String[] args) throws IOException {
        
        parseInput(args);
        Logic logic = new Logic(whiteChar, blackChar, pathToImg);
        logic.printImg();        
    }

    private static void parseInput(String[] args) throws IOException{

        if (args.length != 3) {
            throw new IOException("Wrong number of arguments");
        }
        char[] parsedWhite = args[0].toCharArray();
        char[] parsedBlack = args[1].toCharArray();

        if (parsedWhite.length != 1 || parsedBlack.length != 1) {
            throw new IOException("Wrong arguments");
        }
        whiteChar = parsedWhite[0];
        blackChar = parsedBlack[0];
        pathToImg = args[2];
    }   


}