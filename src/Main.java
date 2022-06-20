import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            NumberUtils nu = new NumberUtils();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vvedite virazheniye: ");
            String ex = scanner.nextLine();
            char operator = ExpressionParser.getOperator(ex);
            String firstNumber = ExpressionParser.getFirstNumber(ex);
            String secondNumber = ExpressionParser.getSecondNumber(ex);
            Boolean validExpression = ex.split(" ").length == 3;
            if(validExpression){
                if (nu.isArabicNumeral(firstNumber) && nu.isArabicNumeral(secondNumber)){
                    switch (operator) {
                        case '+':
                            System.out.println(nu.sumArabicNumbers(firstNumber, secondNumber));
                            break;
                        case '-':
                            System.out.println(nu.subtractArabicNumbers(firstNumber, secondNumber));
                            break;
                        case '*':
                            System.out.println(nu.multiplyArabicNumbers(firstNumber, secondNumber));
                            break;
                        case '/':
                            System.out.println(nu.divideArabicNumbers(firstNumber, secondNumber));
                            break;
                    }
                } else if (nu.isRomanNumeral(firstNumber) && nu.isRomanNumeral(secondNumber)){
                    switch (operator) {
                        case '+':
                            System.out.println(nu.sumRomanNumbers(firstNumber, secondNumber));
                            break;
                        case '-':
                            System.out.println(nu.subtractRomanNumbers(firstNumber, secondNumber));
                            break;
                        case '*':
                            System.out.println(nu.multiplyRomanNumbers(firstNumber, secondNumber));
                            break;
                        case '/':
                            System.out.println(nu.divideRomanNumbers(firstNumber, secondNumber));
                            break;
                    }
                } else {
                    throw new IllegalArgumentException("Wrong number system");
                }
            } else{
                throw new IllegalArgumentException("Wrong expression");
            }

        } catch (Exception e) {
            System.out.println("Invalid input: " + e);
        }
    }
}