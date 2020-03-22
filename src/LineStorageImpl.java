import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LineStorageImpl implements LineStorage {

    private ArrayList<String> line = new ArrayList<String>();
    private ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();

    public LineStorageImpl() {
    }

    /**
     * Append a new word to the end of a line
     *
     * @param	word		the word to be appended to the end of the line
     */
    public void addWord(String word) {
        // Append the new word to the end of the line
        line.add(word);
    }

    /**
     * Append a new word to the end of an existing line
     *
     * @param	word		the word to be appended to the end of the line
     * @param	lineIndex	the index of the line in the list of lines
     */
    public void addWord(String word, int lineIndex) {

        // Get a line from the list of lines at the index specified by lineIndex
        ArrayList<String> line = getLine(lineIndex);
        // Append the new word to the end of the line
        line.add(word);
        // Replace the existing line in the list of lines with the new line
        lines.set(lineIndex, line);

    }

    /**
     * Append the local line to the end of the list of line
     */
    public void addLine() {

        // Append a clone of the local line object to the end of the list of lines
        lines.add((ArrayList<String>) line.clone());
        // Clear the line
        line.clear();

    }

    /**
     * Append a new line to the end of the list of line
     *
     * @param	line	the line to be appended to the end of the list of lines
     */
    public void addLine(ArrayList<String> line) {
        // Append the new line object line to the end of the list of lines
        lines.add(line);
    }

    /**
     * Append a new line String to the end of the list of line
     *
     * @param	line	the line String to be appended to the end of the list of lines
     */
    public void addLine(String line) {

        String[] lineArray = line.split(" ");
        ArrayList<String> lineList = new ArrayList<String>(Arrays.asList(lineArray));

        lines.add(lineList);
    }

    /**
     * Get a specific word from a line
     *
     * @param	lineIndex	the index of the line in the list of lines
     * @param	wordIndex	the index of the word in the line
     * @return				the word at the specified index in the line
     */
    public String getWord(int lineIndex, int wordIndex) {

        // Get a line from the list of lines at the index specified by lineIndex
        ArrayList<String> line = getLine(lineIndex);
        // Return the word from the line at the index specified by wordIndex
        return line.get(wordIndex);
    }

    /**
     * Get a specific line from the list of lines
     *
     * @param	lineIndex	the index of the line in the list of lines
     * @return				the line at the specified index in the list of line
     */
    public ArrayList<String> getLine(int lineIndex) {
        // Return the line from the list of lines at the index specified by lineIndex
        return lines.get(lineIndex);
    }

    /**
     * Get the list of lines
     *
     * @return	the list of lines
     */
    public ArrayList<ArrayList<String>> getLines(){
        return lines;
    }

    /**
     * Get the list of lines with each line being a String
     *
     * @return	the list of lines with each line being a String
     */
    public ArrayList<String> getLinesAsString() {

        ArrayList<String> linesString = new ArrayList<String>();

        for (int i = 0; i < lines.size(); i++) {

            String lineString = "";

            for (int j = 0; j < getLine(i).size(); j++) {
                lineString += getWord(i,j) + " ";
            }

            linesString.add(lineString.substring(0, lineString.length() - 1));

        }

        return linesString;

    }

    /**
     * Get the list of lines as a String
     *
     * @return	the list of lines as a String
     */
    @Override
    public String toString() {

        String linesString = "";

        for (int i = 0; i < getLinesAsString().size(); i++) {
            linesString += getLinesAsString().get(i) + "\n";
        }

        return linesString.substring(0, linesString.length() - 1);

    }

}
