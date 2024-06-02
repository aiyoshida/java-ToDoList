import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.util.ArrayList;

//これはGUI
//Frameに組み込む形でこれを基本に進めていく。
public class TaskFrame extends JFrame implements ActionListener
{

    CardLayout layout;
    JPanel cardPanel;
    JPanel panel01;
    JPanel panel02;
    JPanel panel03;
    JPanel panel04;
    JTextField txt1;
    JTextField txt2;
    JTextField txt3;
    JTextField txt4;
    JTextField txt5;
    JTextField txt6;
    JTextField txt7;
    JTextField txt8;
    JTextField txt9;
    JTextField txt10;
    JTextField txt11;
    String strTxt1;
    String strTxt2;
    String strTxt3;
    String strTxt4;
    String strTxt5;
    String strTxt6;
    String strTxt7;
    String strTxt8;
    String strTxt9;
    String strTxt10;
    String strTxt11;
    JButton btn1;
    JButton btn2;
    JList listJ;
    JList listJ4;
    JComboBox<String> comboBox;
    ArrayList <Task> TaskFrameList = new ArrayList<>();
    TaskFrame(ArrayList<Task> e){
        this.TaskFrameList = e;
    };
    TaskList taskList = new TaskList();

    public void run(){

        this.setTitle("Todo List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        //Menubar
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("Menu");
        JMenu menu2 = new JMenu("Display");
        menubar.add(menu1);
        menubar.add(menu2);

        JMenuItem i1 = new JMenuItem("Add new task(One time)");
        i1.addActionListener(this);
        i1.setActionCommand("Add new task(One time)");
        JMenuItem i2 = new JMenuItem("Add new task(Recurring)");
        i2.addActionListener(this);
        i2.setActionCommand("Add new task(Recurring)");
        JMenuItem i3 = new JMenuItem("Check as completed");
        i3.addActionListener(this);
        i3.setActionCommand("Check as completed");
        JMenuItem i4 = new JMenuItem("Delete the task");
        i4.addActionListener(this);
        i4.setActionCommand("Delete the task");
        JMenuItem i6 = new JMenuItem("Date-wise");
        i6.addActionListener(this);
        i6.setActionCommand("Date-wise");
        JMenuItem i7 = new JMenuItem("Priority-wise");
        i7.addActionListener(this);
        i7.setActionCommand("Priority-wise");
        JMenuItem i9 = new JMenuItem("Save all");
        i9.addActionListener(this);
        i9.setActionCommand("Save all");

        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i3);
        menu1.add(i4);
        menu2.add(i6);
        menu2.add(i7);
        menu1.add(i9);

        setJMenuBar(menubar);

        //後で、もし保存してるタスクがあったらここに表示するのを加える。
        //何もなかったら「There is no tasks yet」と表示する。

        //JPanel00
        JPanel panel00 =new JPanel();
        JLabel l00 = new JLabel("Welcome!!");
        panel00.add(l00);

        //JPanel01
        panel01 = new JPanel();
        panel01.setLayout(null);
        JLabel l1 = new JLabel("Task title");
        l1.setBounds(100, 100, 200, 25);
        JLabel l2 = new JLabel("Task description");
        l2.setBounds(100, 130, 200, 25);
        JLabel l3 = new JLabel("Deadline");
        l3.setBounds(100, 160, 200, 25);
        JLabel l4 = new JLabel("Priority");
        l4.setBounds(100, 190, 200, 25);
        JLabel l5 = new JLabel("Category");
        l5.setBounds(100, 220, 200, 25);

        panel01.add(l1);
        panel01.add(l2);
        panel01.add(l3);
        panel01.add(l4);
        panel01.add(l5);

        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        txt4 = new JTextField();
        txt5 = new JTextField();

        txt1.setBounds(300, 100, 200, 20);
        txt2.setBounds(300, 130, 200, 20);
        txt3.setBounds(300, 160, 200, 20);
        txt4.setBounds(300, 190, 200, 20);
        txt5.setBounds(300, 220, 200, 20);

        panel01.add(txt1);
        panel01.add(txt2);
        panel01.add(txt3);
        panel01.add(txt4);
        panel01.add(txt5);

        btn1 = new JButton("Save1");
        btn1.setBounds(430, 260, 70, 30);
        btn1.addActionListener(this);
        panel01.add(btn1);
        //ここで、ボタンを押したことをきっかけに、文章を得る、そしてそれを保存するクラスを発動させる。

        //JPanel02
        panel02 = new JPanel();
        panel02.setLayout(null);
        JLabel l6 = new JLabel("Task title");
        l6.setBounds(100, 100, 200, 25);
        JLabel l7 = new JLabel("Task description");
        l7.setBounds(100, 130, 200, 25);
        JLabel l8 = new JLabel("Deadline");
        l8.setBounds(100, 160, 200, 25);
        JLabel l9 = new JLabel("Priority");
        l9.setBounds(100, 190, 200, 25);
        JLabel l10 = new JLabel("Category");
        l10.setBounds(100, 220, 200, 25);
        JLabel l11 = new JLabel("Finish Date");
        l11.setBounds(100, 250, 200, 25);
        JLabel l12 = new JLabel("How frequent?");
        l12.setBounds(100, 280, 200, 25);

        panel02.add(l6);
        panel02.add(l7);
        panel02.add(l8);
        panel02.add(l9);
        panel02.add(l10);
        panel02.add(l11);
        panel02.add(l12);

        txt6 = new JTextField();
        txt7 = new JTextField();
        txt8 = new JTextField();
        txt9 = new JTextField();
        txt10 = new JTextField();
        txt11 = new JTextField();

        txt6.setBounds(300, 100, 200, 20);
        txt7.setBounds(300, 130, 200, 20);
        txt8.setBounds(300, 160, 200, 20);
        txt9.setBounds(300, 190, 200, 20);
        txt10.setBounds(300, 220, 200, 20);
        txt11.setBounds(300, 250, 200, 20);

        panel02.add(txt6);
        panel02.add(txt7);
        panel02.add(txt8);
        panel02.add(txt9);
        panel02.add(txt10);
        panel02.add(txt11);

        //JComboBox
        String[] combodata = {"Once in a week", "Once in a two week", "Once in a month"};
        comboBox = new JComboBox<>(combodata);
        comboBox.setBounds(300, 280, 200, 20);
        comboBox.addActionListener(this);
        panel02.add(comboBox);

        //JButton
        btn2 = new JButton("Save2");
        btn2.setBounds(430, 320, 70, 30);
        btn2.addActionListener(this);
        panel02.add(btn2);

        //Date-wiseの表示
        panel03 = new JPanel();
        listJ = new JList();
        String[] listNumTmpTitle = taskList.sortDate(TaskFrameList);

        listJ.setListData(listNumTmpTitle);
        JScrollPane sp = new JScrollPane();
        sp.getViewport().setView(listJ);
        sp.setPreferredSize(new Dimension(400, 400));
        panel03.add(sp);


        //priority-wiseの表示

        panel04 = new JPanel();
        listJ4 = new JList();
        String[] listNumTmpTitle4 = taskList.sortPriority(TaskFrameList);
        //ここやる
        listJ4.setListData(listNumTmpTitle4);
        JScrollPane sp4 = new JScrollPane();
        sp4.getViewport().setView(listJ4);
        sp4.setPreferredSize(new Dimension(400, 400));
        panel04.add(sp4);


        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

        cardPanel.add(panel00);
        cardPanel.add(panel01, "Add new task(One time)");
        cardPanel.add(panel02, "Add new task(Recurring)");
        cardPanel.add(panel03, "Date-wise");
        cardPanel.add(panel04, "Priority-wise");

        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        switch(cmd)
        {
            case "Add new task(One time)":
                layout.show(cardPanel, cmd);
                break;
            case "Add new task(Recurring)":
                layout.show(cardPanel, cmd);
                break;
            case "Date-wise":
                layout.show(cardPanel, cmd);
                break;
            case "Priority-wise":
                layout.show(cardPanel, cmd);
                break;
            case "Save1":
                strTxt1 = txt1.getText();
                strTxt2 = txt2.getText();
                strTxt3 = txt3.getText();
                strTxt4 = txt4.getText();
                strTxt5 = txt5.getText();

                int num1 = Integer.parseInt(strTxt4);
                Task tmpSave1 = new Task(strTxt1,strTxt2, strTxt3, num1, strTxt5);
                TaskFrameList = taskList.addNew(TaskFrameList, tmpSave1);
                break;

            case "Save2":
                strTxt6 = txt6.getText();
                strTxt7 = txt7.getText();
                strTxt8 = txt8.getText();
                strTxt9 = txt9.getText();
                strTxt10 = txt10.getText();
                strTxt11 = txt11.getText();
                String data = (String)comboBox.getSelectedItem();
                int num2 = Integer.parseInt(strTxt9);
                Task tmpSave2 = new Task(strTxt6,strTxt7, strTxt8, num2, strTxt10);
                taskList.addNewRecur(TaskFrameList, tmpSave2, data, strTxt11);
                break;

            case "Check as completed":
                if(!listJ.isSelectionEmpty())
                {
                    int index = listJ.getSelectedIndex();
                    TaskFrameList = taskList.checkAsDone(TaskFrameList, index);
                }
                else if(!listJ4.isSelectionEmpty())
                {
                    int index2 = listJ4.getSelectedIndex();
                    TaskFrameList = taskList.checkAsDone(TaskFrameList, index2);
                }
                break;

            case "Delete the task":
                if(!listJ.isSelectionEmpty())
                {
                    int index = listJ.getSelectedIndex();
                    TaskFrameList = taskList.delete(TaskFrameList, index);
                }
                else if(!listJ4.isSelectionEmpty())
                {
                    int index2 = listJ4.getSelectedIndex();
                    TaskFrameList = taskList.delete(TaskFrameList, index2);
                }
                break;

            case "Save all":
                TaskFile tmpFinish = new TaskFile();

                try
                {
                    tmpFinish.writeFile(TaskFrameList);
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }

                break;
            }
        }

}
