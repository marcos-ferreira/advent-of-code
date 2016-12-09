package pt.aoc2016.util;

import java.io.*;

/**
 * Created by Marcos on 03/12/2016.
 */
public abstract class AbstractAoc {

    private int lineNumber = 0;

    public void run() throws Exception{
        InputStream fis = getFileStream();
        Reader reader = new InputStreamReader(fis);

        @SuppressWarnings("resource")
        BufferedReader buffReader = new BufferedReader(reader);
        String line = null;

        while((line = buffReader.readLine()) != null){
            lineNumber++;
            processLine(line);
        }

    }

    private InputStream  getFileStream(){
        return getClass().getResourceAsStream(getFileResourceName());
    }

    public abstract String getFileResourceName();

    public abstract void processLine(String line);

    public int getLineNumber(){
        return lineNumber;
    }

}