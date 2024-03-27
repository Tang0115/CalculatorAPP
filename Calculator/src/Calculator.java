import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Arial MT", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;
    boolean isResultDisplayed = false;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("AC");

        Color operatorColor = new Color(253, 153, 0);
        Color equalColor = new Color(224, 224, 224);
        // Color numberButtonColor = new Color(96, 96, 96);

        addButton.setBackground(operatorColor);
        subButton.setBackground(operatorColor);
        mulButton.setBackground(operatorColor);
        divButton.setBackground(operatorColor);
        equalButton.setBackground(equalColor);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.BLACK);

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
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();
    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (isResultDisplayed) {
                    textField.setText("");
                    isResultDisplayed = false;
                }
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            if (textField.getText().isEmpty()
                    || (textField.getText().length() == 1 && textField.getText().equals("-"))) {
                if (textField.getText().equals("-")) {
                    textField.setText("");
                } else {
                    textField.setText("-");
                }
            } else {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '×';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '÷';
            textField.setText("");
        }

        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '×':
                    result = num1 * num2;
                    break;
                case '÷':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }

            if (result == Math.floor(result) && !Double.isInfinite(result)) {
                textField.setText(String.format("%.0f", result));
            } else {
                textField.setText(String.valueOf(result));
            }
            num1 = result;
            isResultDisplayed = true;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}
