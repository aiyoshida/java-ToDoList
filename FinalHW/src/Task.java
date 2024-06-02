import java.io.Serial;
import java.io.Serializable;
import java.lang.String;
import java.time.LocalDate;
import  java.time.format.DateTimeFormatter;

public class Task implements Cloneable, Serializable
{
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    private String taskTitle;
    private String taskDescription;
    transient private LocalDate taskLocalDate;
    private String taskDateStr;
    private int taskPriority;
    private String taskCategory;
    private boolean isDone;

    Task(String Title, String description, String DateStr, int priority, String category)
    {
        this.taskTitle = Title;
        this.taskDescription = description;
        LocalDate tmp = LocalDate.parse(DateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.taskLocalDate = tmp;
        this.taskDateStr = DateStr;
        this.taskPriority = priority;
        this.taskCategory = category;
        this.isDone = false;
    }
    public String getTaskTitle(){return this.taskTitle;}
    public String getTaskDescription(){return this.taskDescription;}
    public String getTaskDateStr() {return this.taskDateStr;}
    public LocalDate getLocalDate(){return this.taskLocalDate;}
    public int getTaskPriority(){
        return this.taskPriority;
    }
    public String getTaskCategory(){
        return this.taskCategory;
    }
    public boolean getIsDone(){
        return this.isDone;
    }
    public String getIsDoneStr()
    {
        if(!this.isDone) {return "Not yet";
        }else {return "Done";}
    }
    public void setIsDone() {if(!this.isDone) {this.isDone = true;}}
    public LocalDate getDateFromStr()
    {
        LocalDate tmp = LocalDate.parse(this.getTaskDateStr(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //StringからLocalDateの値を得る。
        //deserializeの時専用。
        return tmp;
    }
    public void setDateFromStr(LocalDate e)
    {
        this.taskLocalDate = e;
        //localdateをセットしたら、Strも揃える。
        this.taskDateStr = e.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public Task clone()
    { //基本的にはpublic修飾子を付け、自分自身の型を返り値とする
        Task b = null;
        /*ObjectクラスのcloneメソッドはCloneNotSupportedExceptionを投げる可能性があるので、try-catch文で記述(呼び出し元に投げても良い)*/
        try
        {
            b = (Task) super.clone(); //親クラスのcloneメソッドを呼び出す(親クラスの型で返ってくるので、自分自身の型でのキャストを忘れないようにする)
            //親クラスのcloneメソッドで深いコピー(複製先のクラス型変数と複製元のクラス型変数で指しているインスタンスの中身が違うコピー)がなされていないクラス型変数をその変数のcloneメソッドで複製し、複製先のクラス型変数に代入
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return b;
    }



}
