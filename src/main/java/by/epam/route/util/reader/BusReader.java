package by.epam.route.util.reader;

import by.epam.route.exception.FileReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BusReader {
    private final static Logger logger = LogManager.getLogger(BusReader.class);
    private BufferedReader reader;

    public BusReader(File file) throws FileReaderException {
        try {
            this.reader = new BufferedReader(new FileReader(file));
        }
        catch (IOException e){
            throw new FileReaderException(e);
        }
    }

    public String getLine() throws FileReaderException {
        try {
            return reader.readLine();
        }
        catch (IOException e){
            throw new FileReaderException(e);
        }
    }

    public String getLine(int number) throws FileReaderException {
        try {
            String result = "";
            while (number-- > 0) {
                result = reader.readLine();
            }
            return result;
        }
        catch (IOException e){
            throw new FileReaderException(e);
        }
    }

    public void close() throws FileReaderException {
        try{
            reader.close();
        }
        catch (IOException e){
            throw new FileReaderException(e);
        }
    }
}
