package pt.mf.aoc.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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