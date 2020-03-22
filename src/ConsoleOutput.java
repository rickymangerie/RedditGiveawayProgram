import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ConsoleOutput extends Output {

    public ConsoleOutput(LineStorage... ls) {
        super(ls);
    }

    @Override
    public void outputHandler() {
        // Set the input reader to read from console
        setWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    }

}
