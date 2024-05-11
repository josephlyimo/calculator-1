import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

  private JFrame frame;
  private JTextField textField;
  private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
      addButton, subtractButton, multiplyButton, divideButton, decimalButton, equalButton, clearButton;

  private double num1 = 0, num2 = 0;
  private char operator;

  public Calculator() {
    frame = new JFrame("Calculator");
    frame.setLayout(null);
    frame.setSize(300, 400);

    textField = new JTextField();
    textField.setBounds(10, 10, 270, 50);
    textField.setFont(textField.getFont().deriveFont(20f));
    textField.setEditable(false);
    frame.add(textField);

    // Create buttons and set positions
    button1 = new JButton("1");
    button1.setBounds(10, 70, 50, 50);
    button1.addActionListener(this);
    frame.add(button1);

    // ... (similar code for buttons 2-9, 0, +, -, *, /, ., =, C)

    equalButton = new JButton("=");
    equalButton.setBounds(170, 230, 50, 50);
    equalButton.addActionListener(this);
    frame.add(equalButton);

    clearButton = new JButton("C");
    clearButton.setBounds(230, 230, 50, 50);
    clearButton.addActionListener(this);
    frame.add(clearButton);

    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String text = e.getActionCommand();

    if (Character.isDigit(text.charAt(0))) {
      textField.setText(textField.getText() + text);
    } else if (text.equals("+")) {
      num1 = Double.parseDouble(textField.getText());
      operator = '+';
      textField.setText("");
    } else if (text.equals("-")) {
      num1 = Double.parseDouble(textField.getText());
      operator = '-';
      textField.setText("");
    } else if (text.equals("*")) {
      num1 = Double.parseDouble(textField.getText());
      operator = '*';
      textField.setText("");
    } else if (text.equals("/")) {
      num1 = Double.parseDouble(textField.getText());
      operator = '/';
      textField.setText("");
    } else if (text.equals(".")) {
      if (!textField.getText().contains(".")) {
        textField.setText(textField.getText() + ".");
      }
    } else if (text.equals("=")) {
      num2 = Double.parseDouble(textField.getText());
      double result = calculate(num1, num2, operator);
      textField.setText(String.valueOf(result));
      num1 = result;
    } else if (text.equals("C")) {
      textField.setText("");
      num1 = 0;
      num2 = 0;
    }
  }

  private double calculate(double num1, double num2, char operator) {
    switch (operator) {
      case '+':
        return num1 + num2;
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
      case '/':
        if (num2 == 0) {
          // Handle division by zero error
          return Double.NaN;
        }
        return num1 / num2;
      default:
        return 0;
    }
  }

  public static void main(String[] args) {
    new Calculator();
  }
}
