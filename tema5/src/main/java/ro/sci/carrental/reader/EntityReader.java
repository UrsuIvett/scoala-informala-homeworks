package ro.sci.carrental.reader;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 13-Jul-17.
 */
/*this class reads the text from a text file, and the text is transformed into a list of strings*/
public class EntityReader {
    public List<String> readLines(File file) {
        Charset charset = Charset.forName("UTF8");

        List<String> list= new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(),charset))
        {
            String line= null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.err.println("IOException: "+ e);
        }
        return list;
    }
}
