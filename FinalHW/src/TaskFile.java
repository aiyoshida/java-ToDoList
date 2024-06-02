import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.io.File;
import java.util.ArrayList;


public class TaskFile{
    TaskFile(){}

    ArrayList<Task> tmpRead = null;
    TaskList taskList = new TaskList();

    public ArrayList<Task> readFile() throws IOException
    {

        try
        {
            File file = new File("TaskData.txt");
            if (file.length() == 0)
            {
                tmpRead = new ArrayList<>();
            }
            else
            {
                FileInputStream inFile = new FileInputStream("TaskData.txt");
                //(7)FileInputStreamオブジェクトの生成
                ObjectInputStream inObject = new ObjectInputStream(inFile);
                //(8)ObjectInputStreamオブジェクトの生成

                tmpRead = (ArrayList) inObject.readObject();
                tmpRead = taskList.getTaskLocalDate(tmpRead);
                //ここで、transientになってたDateの値を追加。
                System.out.println(tmpRead.size());

                inObject.close();
                inFile.close();
            }
            return tmpRead;
            }catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
            catch (IOException e)
            {
            throw new RuntimeException(e);
            }
            catch (ClassNotFoundException e)
            {
            throw new RuntimeException(e);
            }
        }

        public void writeFile (ArrayList<Task> e) throws IOException
        {
            FileOutputStream outFile = new FileOutputStream("TaskData.txt");
            ObjectOutputStream outObject = new ObjectOutputStream(outFile);
            outObject.writeObject(e);
            System.out.println("Why?");
            outObject.close();
            outFile.close();
        }

}
