import lab2.exceptions.FileNotExistException;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            File outputFile = new File("output.txt");
            DataValidate dataValidate = new DataValidate(file.getName(), outputFile.getName());
            Matrix matrix = new Matrix(dataValidate.getSizeMatrix());
            matrix.fillMatrix();
            matrix.dividingElementsOfMatrix();

            try(FileWriter output = new FileWriter(outputFile);)
            {
                outputInFile(matrix, output);
                for (int i = 0; i < 3; i++) {
                    matrix.rotateNinetyDegree();
                    outputInFile(matrix, output);
                }
            }
        } catch (FileNotExistException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void outputInFile(Matrix matrix, FileWriter output) throws IOException {
        for (int i = 0; i < 1; i++) {
            output.write(matrix.toString());
        }
        output.write("\n");
    }
}
