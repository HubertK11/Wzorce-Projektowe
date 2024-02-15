import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField firstNumber = new JTextField(10);
    private JTextField secondNumber = new JTextField(10);
    private JButton addButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton multiplyButton = new JButton("*");
    private JButton divideButton = new JButton("/");
    private JTextField calcSolution = new JTextField(10);

    public CalculatorView() {
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);

        calcPanel.add(firstNumber);
        calcPanel.add(secondNumber);
        calcPanel.add(addButton);
        calcPanel.add(subtractButton);
        calcPanel.add(multiplyButton);
        calcPanel.add(divideButton);
        calcPanel.add(calcSolution);

        this.add(calcPanel);
    }

    public double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setCalcSolution(double solution) {
        calcSolution.setText(Double.toString(solution));
    }

    public void addCalculationListener(ActionListener listenerForCalcButton) {
        addButton.addActionListener(listenerForCalcButton);
        subtractButton.addActionListener(listenerForCalcButton);
        multiplyButton.addActionListener(listenerForCalcButton);
        divideButton.addActionListener(listenerForCalcButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void start() {
        this.setVisible(true);
    }
}

