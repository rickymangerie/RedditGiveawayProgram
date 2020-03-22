import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.text.StringEscapeUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Users {

    private String fileName;
    private String filePath;

    private List<List<String>> entries;
    private ArrayList<String> users;

    public Users() {
        fileName = "";
        filePath = "";
    }

    public Users(String fn) {
        fileName = fn;
        setFilePath(fn);
        setUsers();
    }

    /**
     * Check to see if a file name was entered
     */
    void checkFileName() {

        // Return an error if the file name is empty and quit the program
        if (fileName.equals("")) {

            System.err.println("ERROR: File name was not entered!");
            System.exit(1);

        }

    }

    /**
     * Get the file name
     *
     * @return	The file name
     */
    String getFileName() {

        // Check to see if a file name was entered
        checkFileName();

        return fileName;

    }

    /**
     * Set the file name
     *
     * @param	fn	The file name
     */
    void setFileName(String fn) {

        fileName = fn;
        setFilePath(fn);

    }

    /**
     * Get the file path
     *
     * @return	The file path
     */
    String getFilePath() {
        return filePath;
    }

    private void setFilePath() {
        // The file is located one level higher than the current directory
        filePath = "../" + getFileName();
    }

    /**
     * Set the file path
     *
     * @param	fn	The file name
     */
    private void setFilePath(String fn) {
        // The file is located one level higher than the current directory
        filePath = "../" + fn;
    }

    /**
     * Get the list of entries
     *
     * @return	The list of entries
     */
    List<List<String>> getEntries() {
        return entries;
    }

    /**
     * Set the list of entries
     */
    void setEntries() {

        // Check to see if a file name was entered
        checkFileName();

        // Read in the CSV file as an array list
        entries = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader(getFilePath()))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                entries.add(Arrays.asList(values));
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Set the list of entries
     *
     * @param	fn	The file name
     */
    void setEntries(String fn) {

        // Set the file name
        setFileName(fn);

        // Call the root method
        setEntries();

    }

    /**
     * Get the list of users
     *
     * @return	The list of users
     */
    ArrayList<String> getUsers() {
        return users;
    }

    /**
     * Set the list of users
     */
    void setUsers() {

        // Set the list of entries
        setEntries();

        // For each entry, get the user and add it to the list of users
        users = new ArrayList<String>();
        getEntries().forEach((e) -> users.add(e.get(1)));
        // Remove the header row
        users.remove(0);

    }

    /**
     * Set the list of users
     *
     * @param	fn	The file name
     */
    void setUsers(String fn) {

        // Set the file name
        setFileName(fn);

        // Call the root method
        setUsers();

    }

    /**
     * Print the list of users
     *
     * @param	l	An array of literals that will be applied while printing
     */
    void printUsers(char... l) {

        // Set the list of users
        setUsers();

        String litString = "";

        // Create a string that contains each literal that was passed to the method
        for (char c : l) {

            if (c != 'z') {
                litString += "\\" + Character.toString(c);
            }

        }

        // Convert the literals String to an unescaped String
        String litUnesc = StringEscapeUtils.unescapeJava(litString);

        // For each user in the list, print the literals and the current user
        users.forEach((u) -> System.out.println(litUnesc + u));

    }

    /**
     * Print the list of users
     */
    void printUsers() {

        // Set the list of users
        setUsers();

        // Call the root method with no literals passed
        printUsers('z');

    }

    /**
     * Print the list of users
     *
     * @param	fn	The file name
     */
    public void printUsers(String fn) {

        // Set the file name
        setFileName(fn);

        // Call the alternate root method
        printUsers();

    }

    /**
     * Print the list of users
     *
     * @param	fn	The file name
     * @param   l   An array of literals that will be applied while printing
     */
    public void printUsers(String fn, char... l) {

        // Set the file name
        setFileName(fn);

        // Call the root method with the array of literals
        printUsers(l);

    }

    /**
     * Choose a winner from the list of users
     *
     * @return	The winning user
     */
    String getWinningUser() {

        // Set the list of users
        setUsers();

        String winner = "";

        /*
            The following two for-loops will randomize 10,000 times before choosing a winner
            For each seed, choose the 100th random number
            100 seeds --> Choose the 100th random number 100 times --> 100*100 --> 10,000
         */
        // Seed a random number 100 times
        for (int i = 0; i < 100; i++) {

            Random random = new Random();
            int randIndex = 0;

            // Choose a random number from the seed 100 times
            for (int j = 0; j < 100; j++) {
                randIndex = random.nextInt(getUsers().size());
            }

            // Store the winning user in a variable
            winner = getUsers().get(randIndex);

        }

        // Return the winning user
        return winner;

    }

    /**
     * Choose a winner from the list of users
     *
     * @return	The winning user
     */
    String chooseWinner() {
        // Call the root method
        return getWinningUser();
    }

    /**
     * Choose a winner from the list of users
     *
     * @return	The winning user
     */
    String getWinner() {
        // Call the root method
        return getWinningUser();
    }

    /**
     * Choose a winner from the list of users
     *
     * @return	The winning user
     */
    String pickWinner() {
        // Call the root method
        return getWinningUser();
    }

    /**
     * Choose a winner from the list of users
     *
     * @param	fn	The file name
     * @return	    The winning user
     */
    String getWinningUser(String fn) {

        // Set the file name
        setFileName(fn);

        // Call the root method
        return getWinningUser();

    }

    /**
     * Choose a winner from the list of users
     *
     * @param	fn	The file name
     * @return	    The winning user
     */
    String chooseWinner(String fn) {
        // Call the alternate root method with the file name
        return getWinningUser(fn);
    }

    /**
     * Choose a winner from the list of users
     *
     * @param	fn	The file name
     * @return	    The winning user
     */
    String getWinner(String fn) {
        // Call the alternate root method with the file name
        return getWinningUser(fn);
    }

    /**
     * Choose a winner from the list of users
     *
     * @param	fn	The file name
     * @return	    The winning user
     */
    String pickWinner(String fn) {
        // Call the alternate root method with the file name
        return getWinningUser(fn);
    }

}
