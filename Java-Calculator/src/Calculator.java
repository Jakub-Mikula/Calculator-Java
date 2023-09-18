import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] operators = new JButton[8];
    JButton addButton, subButton, multiplyButton, divideButton, decimalButton, equalsButton, deleteButton, ClearButton;
    JPanel panel;

    Font myFont = new Font("Helvetica", Font.BOLD,30);

    double number1 = 0, number2 = 0, result= 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        frame.add(textField); //this adds the text field into to loadout
        frame.setVisible(true);  //keep one line clear before this, this needs to be last
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}