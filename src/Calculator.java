import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, eqlButton, clrButton, dotButton, delButton;
    private JPanel panel;
    private Font font = new Font("Arial", Font.PLAIN, 18);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 600); // Adjusted height to accommodate equals button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        textField = new JTextField();
        textField.setBounds(50, 50, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);
        add(textField);

        panel = new JPanel();
        panel.setBounds(50, 120, 300, 400); // Adjusted height to accommodate equals button
        panel.setLayout(new GridLayout(5, 4, 10, 10)); // Adjusted rows to add equals button

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
        }

        functionButtons = new JButton[8];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqlButton = new JButton("="); // Added equals button
        clrButton = new JButton("C");
        dotButton = new JButton(".");
        delButton = new JButton("DEL");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqlButton; // Added equals button
        functionButtons[5] = clrButton;
        functionButtons[6] = dotButton;
        functionButtons[7] = delButton;

        for (JButton button : functionButtons) {
            button.setFont(font);
            button.addActionListener(this);
        }

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(dotButton);
        panel.add(numberButtons[0]);
        panel.add(clrButton);
        panel.add(divButton);

        // Added equals button
        panel.add(new JLabel()); // Empty label for layout
        panel.add(eqlButton);
        panel.add(new JLabel()); // Empty label for layout
        panel.add(delButton);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dotButton) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText().concat("."));
            }
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String currentText = textField.getText();
            textField.setText(currentText.substring(0, currentText.length() - 1));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == eqlButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        result = 0;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
    }
}
