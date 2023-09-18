import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] operators = new JButton[8];
    JButton addButton, subtractButton, multiplyButton, divideButton, decimalButton, equalsButton, deleteButton, clearButton;
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
        operators[0] = addButton;
        operators[1] = subtractButton;
        operators[2] = multiplyButton;
        operators[3] = divideButton;
        operators[4] = decimalButton;
        operators[5] = equalsButton;
        operators[6] = deleteButton;
        operators[7] = clearButton;
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

        deleteButton.setBounds(50,430,145,50); //manually set delete button
        clearButton.setBounds(205,430,145,50); //manually set clear button

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
        frame.add(textField); //this adds the text field into to load-out
        frame.setVisible(true);  //keep one line clear before this, this needs to be last
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}