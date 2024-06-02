import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class TaskList{

    public ArrayList<Task> addNew(ArrayList<Task> addList, Task addTask)
    {
        addList.add(addTask);
        return addList;
    }

    public ArrayList<Task> addNewRecur (ArrayList<Task> addList, Task addTask, String strRecur, String DateStr)
    {
        LocalDate tmpDate = LocalDate.parse(DateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        switch(strRecur)
        {
            case "Once in a week":
                while(addTask.getLocalDate().isBefore(tmpDate))
                {
                Task tmp = addTask.clone();
                addTask.setDateFromStr(tmp.getLocalDate().plusWeeks(1));
                addList.add(tmp);
                }
                break;
            case "Once in a two week":
                while(addTask.getLocalDate().isBefore(tmpDate))
                {
                    Task tmp = addTask.clone();
                    addTask.setDateFromStr(tmp.getLocalDate().plusWeeks(2));
                    addList.add(tmp);
                }
                break;
            case "Once in a month":
                while(addTask.getLocalDate().isBefore(tmpDate))
                {
                    Task tmp = addTask.clone();
                    addTask.setDateFromStr(tmp.getLocalDate().plusMonths(1));
                    addList.add(tmp);
                }
                break;
        }
        return addList;
    }

    public String[] sortDate(ArrayList<Task> addList)
    {
        //TaskFrameListのコピーを作って、日付で並び替える。
        int listNum = addList.size();
        if(listNum < 2)
        {
            String[] str1 = new String[listNum];
            return str1 = makeString(addList);
        }
        else
        {
            Collections.sort(addList, new TaskComparator());
            String[] str2 = new String[listNum];
            return str2 = makeString(addList);
        }

    }

    //String[]を作るのと、Arrayをsortする作業分けた方がいい。他の作業にも使える。
    public String[] makeString (ArrayList<Task> addList)
    {
        int listNum = addList.size();
        String [] listNumTmpTitle = new String [listNum];
        for (int i = 0; i < listNum; i++)
        {
            //後で、表示する要素を足す。
            listNumTmpTitle[i] = i + " "
                                + addList.get(i).getTaskTitle() + " "
                                + addList.get(i).getTaskDescription() + " "
                                + addList.get(i).getTaskDateStr()+ " "
                                + addList.get(i).getTaskPriority()+" "
                                + addList.get(i).getTaskCategory() + " "
                                + addList.get(i).getIsDoneStr();
        }
        return listNumTmpTitle;
    }


    public String[] sortPriority(ArrayList<Task> addList)
    {
        int listNum = addList.size();
        if(listNum < 2)
        {
            String[] str1 = new String[listNum];
            return str1 = makeString(addList);
        }
        else
        {
            Collections.sort(addList, new TaskComparatorPriority());
            String[] str2 = new String[listNum];
            return str2 = makeString(addList);
        }

    }

    public  ArrayList<Task> delete(ArrayList<Task> addList, int index)
    {
        addList.remove(index);
        return addList;
    }
    //List型のremoveメソッド
    public ArrayList<Task> checkAsDone(ArrayList<Task> addList, int index)
    {
        addList.get(index).setIsDone();
        return addList;
    }
    public ArrayList<Task> getTaskLocalDate(ArrayList<Task> taskList)
    {
        int num = taskList.size();
        for (int a = 0; a < num; a++)
        {
            taskList.get(a).setDateFromStr(taskList.get(a).getDateFromStr());
            //fieldsのstrから、Dateに変換している。
        }
        return taskList;
    }


}
