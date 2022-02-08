import lab2.exceptions.FileNotExistException;
import lab2.exceptions.OverflowException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataValidate {
    private final File file;
    private final File outputfile;
    private final static int MIN_SIZE = 1;
    private final static int MAX_SIZE = 1_000_000;

    public DataValidate(String path, String outputPath) {
        file = new File(path);
        outputfile = new File(outputPath);
    }

    public int getSizeMatrix() throws FileNotFoundException {
        if (!file.exists()) { throw new FileNotExistException("File not exists"); }
        if (!outputfile.exists()) { throw new FileNotExistException("File not exist!"); }
        final int size;
        try (Scanner reader = new Scanner(file);) {
            size = Integer.parseInt(reader.nextLine());
        }
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("The size of the matrix can not be less than 1");
        }
        if (size > MAX_SIZE) {
            throw new OverflowException("The size of the matrix can not be more than 1 000 000");
        }
        return size;
    }
}
