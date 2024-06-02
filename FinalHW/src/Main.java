import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        ArrayList<Task> listForTaskRead;

        TaskFile tmp = new TaskFile();
        listForTaskRead = tmp.readFile();
        System.out.println(listForTaskRead.size());

        TaskFrame baseFrame = new TaskFrame(listForTaskRead);
        baseFrame.run();
    }
}
