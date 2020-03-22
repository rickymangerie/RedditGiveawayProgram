import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Output {

    protected BufferedWriter writer;
    protected LineStorage[] lineStorage;

    public Output(LineStorage... ls) {
        lineStorage = ls;
    }

    public void print() {

        outputHandler();

        try {

            for (int i = 0; i < lineStorage.length; i++) {

                String[] lines = new String[lineStorage[i].getLinesAsString().size()];
                lines = lineStorage[i].getLinesAsString().toArray(lines);



                    for (int j = 0; j < lines.length; j++) {

                        if (j != lines.length - 1) {
                            writer.write(lines[j] + "\n");
                        } else {
                            writer.write(lines[j]);
                        }

                        writer.flush();

                    }

                    //writer.close();

                if (i != lineStorage.length - 1) {
                    writer.write("\n");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    /**
     * Handle a specific type of output
     */
    public abstract void outputHandler();

    /**
     * Set the BufferedWriter object of the class
     *
     * @param	writer	a BufferedWriter object
     */
    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    /**
     * Close the writer
     */
    public void closeWriter() {

        try {
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

