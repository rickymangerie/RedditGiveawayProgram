import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Save the current print stream
        PrintStream ps = System.out;

        // Create an object for the users of both entries
        Users tsr = new Users("TSR.csv");
        Users currents = new Users("Currents.csv");

        // Create a line storage object for the general data
        LineStorage lineStorageData = new LineStorageImpl();

        // Add the data from each file to line storage
        lineStorageData.addLine("The Slow Rush:");
        lineStorageData.addLine("\tTotal Entries: " + tsr.getUsers().size());
        lineStorageData.addLine("\tEntered Users:");
        tsr.getUsers().forEach((u) -> lineStorageData.addLine("\t\t" + u));
        lineStorageData.addLine("");

        lineStorageData.addLine("Currents:");
        lineStorageData.addLine("\tTotal Entries: " + currents.getUsers().size());
        lineStorageData.addLine("\tEntered Users:");
        currents.getUsers().forEach((u) -> lineStorageData.addLine("\t\t" + u));
        lineStorageData.addLine("");

        // Output the general data to console
        Output consoleOutputData = new ConsoleOutput(lineStorageData);
        consoleOutputData.print();

        // Set the current print stream to its original state
        System.setOut(ps);

        // Add a buffer before the winners are displayed
        System.out.println("\nThe time has come...\nPress ENTER to see the winners.");
        Scanner sc = new Scanner(System.in);
        String enter = sc.nextLine();

        // Choose a winner for each entry
        String tsrWinner = tsr.chooseWinner();
        String currentsWinner = currents.chooseWinner();

        // Create a line storage object for the winner data
        LineStorage lineStorageWinners = new LineStorageImpl();

        // Add the winner data to line storage
        lineStorageWinners.addLine("Winners:");
        lineStorageWinners.addLine("\tThe Slow Rush (Limited):");
        lineStorageWinners.addLine("\t\t" + tsrWinner);
        lineStorageWinners.addLine("\tCurrents:");
        lineStorageWinners.addLine("\t\t" + currentsWinner);

        // Output the winner data to console
        Output consoleOutputWinners = new ConsoleOutput(lineStorageWinners);
        consoleOutputWinners.print();

        // Set the current print stream to its original state
        System.setOut(ps);
        System.out.println();

        // Output the general and winner data to a file
        Output fileOutput = new FileOutput(lineStorageData, lineStorageWinners);
        fileOutput.print();

        // Close the writers
        consoleOutputData.closeWriter();
        consoleOutputWinners.closeWriter();
        fileOutput.closeWriter();

    }

}
