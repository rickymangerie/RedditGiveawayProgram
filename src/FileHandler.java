import java.io.File;

public class FileHandler {

    private String filePath = null;

    public FileHandler() {

    }

    /**
     * Check to see if an entered text file exists
     *
     * @param	fileName	the entered text file
     * @return				true if the entered text file exists
     */
    public boolean isExistingFile(String fileName) {

        // Strip the file path of any double quotes
        fileName = fileName.replace("\"", "");

        // Get the extension of the file
        String fileExtension = getFileExtension(fileName);

        // If a file extension does not exist
        if (fileExtension == "") {
            // Append the text file extension to the file name
            fileName = appendExtension(fileName, ".txt");
        }

        // A file object containing the file associated with the entered text file
        File inputFile = new File(fileName);

        // If the file exists and the file itself is itself a file object
        if (inputFile.exists() && inputFile.isFile()) {
            // THe entered text file exists
            return true;
        }

        // Set the new text file path to the modified file name
        setFilePath(fileName);
        // The entered text file does not exist
        return false;

    }

    /**
     * Check to see if an entered text file exists
     *
     * @param	fileName	the entered text file
     * @return				true if the entered text file exists
     */
    public boolean isExistingTextFile(String fileName) {

        // Strip the file path of any double quotes
        fileName = fileName.replace("\"", "");

        // Get the extension of the file
        String fileExtension = getFileExtension(fileName);

        // If a file extension does not exist
        if (fileExtension == "") {
            // Append the text file extension to the file name
            fileName = appendExtension(fileName, ".txt");
            // If the existing file extension is not that of a text file
        } else if (hasTextExtension(fileExtension) == false) {
            // The entered text file does not exist
            return false;
        }

        // A file object containing the file associated with the entered text file
        File inputFile = new File(fileName);

        // If the file exists and the file itself is itself a file object
        if (inputFile.exists() && inputFile.isFile()) {
            // Set the text file path to the modified file name
            setFilePath(fileName);
            // THe entered text file exists
            return true;
        }

        // The entered text file does not exist
        return false;

    }

    /**
     * Retrieve a file extension from an entered file
     *
     * @param	fileName	the entered file
     * @return				the extension of the entered file
     */
    public String getFileExtension(String fileName) {

        // If the entered file does not end in a period and contains a valid extension after the period
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            // Return the file extension
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }

        // Return an empty string if there was no file extension or it was invalid
        return "";

    }

    /**
     * Append a file extension to the end of an entered file
     *
     * @param	fileName	the entered file
     * @param	extension	the file extension to be appended
     * @return				the entered file with the extension appended
     */
    public String appendExtension(String fileName, String extension) {
        // Return the entered file with the extension appended
        return fileName + extension;
    }

    /**
     * Verify that an entered file has a text extension
     *
     * @param	fileExtension	the extension of the entered file
     * @return					true if the file extension is a text extension
     */
    public boolean hasTextExtension(String fileExtension) {

        // If the file extension is a text extension
        if (fileExtension.equals("txt")) {
            // Return that the entered file has a text extension
            return true;
        }

        // Return that the entered file does not have a text extension
        return false;

    }

    /**
     * Set the file path String of the class
     * @param	fp	the file path
     */
    public void setFilePath(String fp) {
        filePath = fp;
    }

    /**
     * Gets the file path String of the class
     * @return	the file path
     */
    public String getFilePath() {
        return filePath;
    }

}
