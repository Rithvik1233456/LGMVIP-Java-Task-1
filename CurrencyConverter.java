import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CurrencyConverter implements ActionListener {
    JFrame j;
    JTextField amountTextField;
    JComboBox<String> fromComboBox, toComboBox;
    JButton convertButton;
    JLabel headingLabel, amountLabel, fromLabel, toLabel, resultLabel;
    String[] currencies = { "USD", "INR", "AUD", "GBP", "JPY", "EUR"};
    double[][] rates = {
            { 1.0, 81.99, 1.48, 0.77,141.83,0.89 },
            { 0.012, 1.0, 0.018, 0.009,1.72,0.01 },
            { 0.67,55.1 , 1.0, 0.52, 95.4,0.604  },
            { 1.28,105.3, 1.90, 1.0, 182.285,1.15  },
            { 0.007, 0.577, 0.01, 0.005, 1.0,0.006 },
            { 1.11, 91.21, 1.65,0.86,157.7, 1.0 }
    };
    public CurrencyConverter() {
        j = new JFrame("CURRENCY CONVERTER");
        j.setSize(550, 300);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        headingLabel = new JLabel("CURRENCY CONVERTER ");
        headingLabel.setBounds(200, 30, 250, 50);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 15));
        j.add(headingLabel);
        amountLabel = new JLabel("AMOUNT :");
        amountLabel.setBounds(80, 80, 60, 20);
        j.add(amountLabel);
        amountTextField = new JTextField(10);
        amountTextField.setBounds(150, 80, 100, 20);
        j.add(amountTextField);
        fromLabel = new JLabel("FROM :");
        fromLabel.setBounds(90, 120, 100, 20);
        j.add(fromLabel);
        fromComboBox = new JComboBox<>(currencies);
        fromComboBox.setBounds(150, 120, 100, 20);
        j.add(fromComboBox);
        toLabel = new JLabel("TO :");
        toLabel.setBounds(300, 120, 100, 20);
        j.add(toLabel);
        toComboBox = new JComboBox<>(currencies);
        toComboBox.setBounds(350, 120, 100, 20);
        j.add(toComboBox);
        convertButton = new JButton("CONVERT");
        convertButton.setBounds(230, 170, 100, 20);
        convertButton.addActionListener(this);
        j.add(convertButton);
        resultLabel = new JLabel("");
        resultLabel.setBounds(250, 200, 100, 20);
        j.add(resultLabel);
        j.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            String amountString = amountTextField.getText();
            double amount = Double.parseDouble(amountString);
            int fromIndex = fromComboBox.getSelectedIndex();
            int toIndex = toComboBox.getSelectedIndex();
            double rate = rates[fromIndex][toIndex];
            double result = amount * rate;
            String resultString = String.format("%.2f %s", result, currencies[toIndex]);
            resultLabel.setText(resultString);
        } catch (NumberFormatException ex) {
            System.out.println("error");
        }
    }
    public static void main(String[] args) {
        new CurrencyConverter();
    }
}