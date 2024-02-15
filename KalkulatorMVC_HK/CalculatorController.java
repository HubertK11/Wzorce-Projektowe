import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addCalculationListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double firstNumber, secondNumber = 0;

            try {
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();

                String operator = e.getActionCommand();

                double solution = theModel.calculate(firstNumber, secondNumber, operator);

                theView.setCalcSolution(solution);
            } catch (NumberFormatException ex) {
                theView.displayErrorMessage("You need to enter 2 numbers");
            } catch (ArithmeticException ex) {
                theView.displayErrorMessage(ex.getMessage());
            }
        }
    }
}

