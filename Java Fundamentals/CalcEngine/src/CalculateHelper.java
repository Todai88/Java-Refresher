public class CalculateHelper {
    MathCommand command;
    double leftValue;
    double rightValue;
    double result;
    private static final char ADD_SYMBOL = '+';
    private static final char SUB_SYMBOL = '-';
    private static final char MUL_SYMBOL = '*';
    private static final char DIV_SYMBOL = '/';

    public void process(String statement) {
        String[] parts = statement.split(" ");
        String commandString = parts[0];
        leftValue = Double.parseDouble(parts[1]);
        rightValue = Double.parseDouble(parts[2]);

        setCommandFromString(commandString);

        CalculateBase calculator = null;
        switch(command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtractor(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
        }
        calculator.calculate();
    }

    private void setCommandFromString(String commandString) {
        if(commandString.equalsIgnoreCase(MathCommand.Add.toString())) {
            command = MathCommand.Add;
        } else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString())) {
            command = MathCommand.Subtract;
        } else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString())) {
            command = MathCommand.Divide;
        } else  if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString())) {
            command = MathCommand.Multiply;
        } else {
            command = MathCommand.Add;
        }
    }

    @Override
    public String toString(){
        char symbol = ' ';

        switch(command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUB_SYMBOL;
                break;
            case Multiply:
                symbol = MUL_SYMBOL;
                break;
            case Divide:
                symbol = DIV_SYMBOL;
                break;
            default:
                symbol = ADD_SYMBOL;
        }
        /*StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(" ");
        sb.append(symbol);
        sb.append(" ");
        sb.append(rightValue);*/
        String str = String.format("%f %c %f = %f", leftValue, symbol, rightValue, result);
        return str;
    }
}
