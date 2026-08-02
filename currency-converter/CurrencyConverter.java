import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JComboBox<String> fromCurrency, toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;
    private JButton convertButton;

    private final double INR = 83.0;
    private final double EUR = 0.92;
    private final double GBP = 0.78;
    private final double USD = 1.0;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField();

        JLabel fromLabel = new JLabel("From Currency:");
        fromCurrency = new JComboBox<>(new String[]{"USD", "INR", "EUR", "GBP"});

        JLabel toLabel = new JLabel("To Currency:");
        toCurrency = new JComboBox<>(new String[]{"USD", "INR", "EUR", "GBP"});

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        resultLabel = new JLabel("Converted Amount: ");

        add(amountLabel);
        add(amountField);
        add(fromLabel);
        add(fromCurrency);
        add(toLabel);
        add(toCurrency);
        add(new JLabel());
        add(convertButton);
        add(new JLabel());
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double usdAmount = amount * getRate(from);
            double converted = usdAmount / getRate(to);
            resultLabel.setText("Converted Amount: " + String.format("%.2f", converted) + " " + to);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
        }
    }

    private double getRate(String currency) {
        switch (currency) {
            case "INR": return 1 / INR;
            case "EUR": return 1 / EUR;
            case "GBP": return 1 / GBP;
            default: return 1 / USD;
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
