package ro.sci.carrental.reader;

import ro.sci.carrental.domain.car.Car;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivett on 19-Jul-17.
 */
public class EntityWriter {

    public void readLines(ArrayList<String> list, File file) {
        Charset charset = Charset.forName("UTF8");
             try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(),charset))
            {
            for (String currentString : list) {
                writer.write(currentString);
                writer.newLine();
            }
            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
