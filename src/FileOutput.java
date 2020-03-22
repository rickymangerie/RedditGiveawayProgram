import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileStore;
import java.util.Scanner;

public class FileOutput extends Output {

    private FileHandler fileHandler = new FileHandler();
    private Scanner fileScanner = new Scanner(System.in);


    public FileOutput(LineStorage... ls) {
        super(ls);
    }

    @Override
    public void outputHandler() {

        // While there is no valid file path
        ////while (filePath == null) {
        while (fileHandler.getFilePath() == null) {

            // Prompt the user to enter the file name or path
            System.out.println("\nWhat name or path would you like to set your output text file to:\n");
            ////filePath = fileScanner.nextLine();
            fileHandler.setFilePath(fileScanner.nextLine());

            // If the file name or path does not exist
            ////if (isExistingFile(filePath) == true) {
            if (fileHandler.isExistingFile(fileHandler.getFilePath()) == true) {

                // Prompt the user to enter another file name or path
                System.out.println("\nThe specified text file already exists.  Please try again.");
                ////filePath = null;
                fileHandler.setFilePath(null);

                //} else if (hasTextExtension(getFileExtension(filePath)) == false) {
            } else if (fileHandler.hasTextExtension(fileHandler.getFileExtension(fileHandler.getFilePath())) == false) {

                // Prompt the user to enter another file name or path
                System.out.println("\nYou did not enter a text file extension.  Please try again.");
                ////filePath = null;
                fileHandler.setFilePath(null);

            }

        }

        System.out.println();

        try {
            // Set the input reader to read from the file
            //setWriter(new BufferedWriter(new FileWriter(filePath)));
            setWriter(new BufferedWriter(new FileWriter(fileHandler.getFilePath())));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
