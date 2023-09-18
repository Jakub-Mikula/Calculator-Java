import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] operators = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton, decimalButton, equalsButton, deleteButton, clearButton, negativeButton;
    JPanel panel;

    Font myFont = new Font("Helvetica", Font.BOLD,30);

    double number1 = 0, number2 = 0, result= 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator"); //base
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField(); //input textField
        textField.setBounds(50, 25, 300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+"); // operators
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("DEL");
        clearButton = new JButton("CE");
        negativeButton = new JButton("(-)");
        operators[0] = addButton;
        operators[1] = subtractButton;
        operators[2] = multiplyButton;
        operators[3] = divideButton;
        operators[4] = decimalButton;
        operators[5] = equalsButton;
        operators[6] = deleteButton;
        operators[7] = clearButton;
        operators[8] = negativeButton;
        for (JButton jButton : operators) {
            jButton.addActionListener(this);
            jButton.setFont(myFont);
            jButton.setFocusable(false);
        }

        for (int i = 0; i < numbers.length; i++){ //numbers
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setFocusable(false);
        }

        negativeButton.setBounds(50,430,100,50);
        deleteButton.setBounds(150,430,100,50); //manually set delete button
        clearButton.setBounds(250,430,100,50); //manually set clear button

        panel = new JPanel(); //created grid panel for numbers and operators
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numbers[1]); //first row;
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);
        panel.add(numbers[4]); //second row;
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subtractButton);
        panel.add(numbers[7]); //third row;
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);//fourth row
        panel.add(numbers[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(negativeButton);
        frame.add(textField); //this adds the text field into to load-out
        frame.setVisible(true);  //keep one line clear before this, this needs to be last
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numbers.length; i++){  // this writes into the input the value of pressed number button
            if (e.getSource() == numbers[i]){
                textField.setText(textField.getText() + i);
            }
        }
        if (e.getSource() == decimalButton){
            textField.setText(textField.getText() + ".");
        }else if(e.getSource() == addButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }else if(e.getSource() == subtractButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }else if(e.getSource() == multiplyButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }else if(e.getSource() == divideButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }else if(e.getSource() == clearButton){
            textField.setText("");
        }else if(e.getSource() == deleteButton){
            textField.setText(textField.getText().substring(0, textField.getText().length()-1));
        }else if(e.getSource() == negativeButton){
           double temp = Double.parseDouble(textField.getText());
           temp*=-1;
           textField.setText(String.valueOf(temp));
        }else if(e.getSource() == equalsButton){
            number2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
            }
            textField.setText(String.valueOf(result));
            number1 = result;
        }
    }
}