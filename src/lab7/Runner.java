package lab7;

public class Runner {
    public static void main(String[] args) {
        CalculatorThread calculatorThread = new CalculatorThread(5, 14);
        calculatorThread.execute();
        System.out.println(calculatorThread.getResult());
    }
}