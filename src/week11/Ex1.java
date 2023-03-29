package week11;

import javax.swing.*;
import java.awt.*;

public class Ex1
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setTitle("GUI In-Class Ex 1");
        window.setSize(400, 100);
        JLabel label = new JLabel("What's your name?");
        JTextField textField = new JTextField();
        window.setLayout(new BorderLayout());
        window.add(label, BorderLayout.NORTH);
        window.add(textField, BorderLayout.SOUTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
