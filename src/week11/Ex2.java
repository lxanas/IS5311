package week11;

import javax.swing.*;
import java.awt.*;

public class Ex2
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setTitle("GUI In-Class Ex 2");
        window.setSize(400, 100);
        JButton submit = new JButton("Submit");
        submit.setSize(100, 30);
        JButton reset = new JButton("Reset the form");
        reset.setSize(100, 30);
        window.add(submit, BorderLayout.WEST);
        window.add(reset, BorderLayout.EAST);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
