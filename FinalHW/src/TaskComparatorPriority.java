import java.util.Comparator;

public class TaskComparatorPriority implements Comparator<Task>
{
    @Override
    public int compare(Task t1, Task t2) {
        return t2.getTaskPriority() - t1.getTaskPriority();
    }
}