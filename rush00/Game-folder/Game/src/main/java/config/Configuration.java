package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;


public class Configuration {
    
    private Characters characters;
    private Colors colors;

    public Configuration(String APP_CONFIG_PATH) throws IOException {

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(
                                    ClassLoader.class.getResourceAsStream(APP_CONFIG_PATH)));
        Map <String, String> config = new TreeMap<String, String>();
        String line = buffReader.readLine();
        while(line != null) {
            String[] parsedLine = line.split(" = ");
            if (parsedLine.length != 2) {
                throw new IOException("Corrupted application-production.properties file!");
            }
            config.put(parsedLine[0], parsedLine[1]);
            line = buffReader.readLine();
        }
        buffReader.close();
        this.characters = new Characters(config);
        this.colors = new Colors(config);
    }

    public Characters getCharacters() {
        return this.characters;
    }
     public Colors getColors() {
        return this.colors;
     }

}
