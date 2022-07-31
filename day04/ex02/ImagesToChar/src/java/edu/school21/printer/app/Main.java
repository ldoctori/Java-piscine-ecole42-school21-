
package edu.school21.printer.app;

import java.io.IOException;
import edu.school21.printer.logic.Logic;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.Parameter;

@Parameters (separators = "=")
public class Main {

    @Parameter (names = {"--white", "-w"})
    private static String whiteChar;
    @Parameter (names = {"--black", "-b"})
    private static String blackChar;
    private static final String IMAGE_PATH = "/resources/it.bmp";
    public static void main(String[] args) throws IOException{
        
        JCommander.newBuilder()
                .addObject(new Main())
                .build().parse(args);
        Logic logic = new Logic(whiteChar, blackChar, IMAGE_PATH);
        logic.printImg();
    }
}