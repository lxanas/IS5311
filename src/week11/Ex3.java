package week11;

import javax.swing.*;
import java.awt.*;

public class Ex3
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setTitle("GUI In-Class Ex 3");
        window.setSize(400, 250);
        //添加label，"What's your name"，放在窗口的北边，添加文本框，放在label下面
        JLabel label = new JLabel("What's your name?");
        JTextField textField = new JTextField();
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        JLabel label2 = new JLabel("How old are you?");
        JTextField textField2 = new JTextField();
        JPanel panel2 = new JPanel();
        panel2.add(label2);
        panel2.add(textField2);
        JLabel label3 = new JLabel("What's your gender?");
        JTextField textField3 = new JTextField();
        JPanel panel3 = new JPanel();
        panel3.add(label3);
        panel3.add(textField3);
        JButton submit = new JButton("Submit");
        submit.setSize(100, 30);
        JButton reset = new JButton("Reset the form");
        reset.setSize(100, 30);
        panel3.add(submit);
        panel3.add(reset);
        window.setLayout(new BorderLayout());
        window.add(panel, BorderLayout.NORTH);
        window.add(panel2, BorderLayout.CENTER);
        window.add(panel3, BorderLayout.SOUTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
