import java.util.ArrayList;

interface LineStorage {

    public void addWord(String word);
    public void addWord(String word, int lineIndex);
    public void addLine();
    public void addLine(ArrayList<String> line);
    public void addLine(String line);
    public String getWord(int lineIndex, int wordIndex);
    public ArrayList<String> getLine(int lineIndex);
    public ArrayList<ArrayList<String>> getLines();
    public ArrayList<String> getLinesAsString();
    public String toString();

}

