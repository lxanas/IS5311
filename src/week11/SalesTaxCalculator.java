package week11;

import javax.swing.*;
import java.awt.*;

public class SalesTaxCalculator
{
    private static final double COUNTY_TAX_RATE = 0.02;
    private static final double STATE_TAX_RATE = 0.04;

    public static void main(String[] args)
    {
        createGUI();
    }

    private static void createGUI()
    {
        JFrame frame = new JFrame("Sales Tax Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel label = new JLabel("Enter total sales for the month:");
        JTextField textField = new JTextField();
        JButton button = new JButton("Calculate Sales Tax");

        button.addActionListener(e ->
        {
            double sales = Double.parseDouble(textField.getText());
            double countyTax = sales * COUNTY_TAX_RATE;
            double stateTax = sales * STATE_TAX_RATE;
            double totalTax = countyTax + stateTax;

            JFrame reportFrame = new JFrame("Report");
            reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            reportFrame.setSize(350, 200);

            JPanel reportPanel = new JPanel();
            reportPanel.setLayout(new GridLayout(4, 2));

            reportPanel.add(new JLabel("County Sales Tax: "));
            reportPanel.add(new JLabel(String.format("%.1f", countyTax)));
            reportPanel.add(new JLabel("State Sales Tax: "));
            reportPanel.add(new JLabel(String.format("%.1f", stateTax)));
            reportPanel.add(new JLabel("Total Sales Tax: "));
            reportPanel.add(new JLabel(String.format("%.1f", totalTax)));

            reportFrame.add(reportPanel);
            reportFrame.pack();
            reportFrame.setVisible(true);
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }
}
