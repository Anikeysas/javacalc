class ExpressionParser {
    public static char getOperator(String expression) {

        if (expression.contains("+")) return '+';

        if (expression.contains("-")) return '-';

        if (expression.contains("*")) return '*';

        if (expression.contains("/")) return '/';

        throw new IllegalArgumentException("Invalid expression");
    }


    public static String getFirstNumber(String expression) {
        return expression.split(" ")[0];
    }

    public static String getSecondNumber(String expression) {
        return expression.split(" ")[2];
    }
}
