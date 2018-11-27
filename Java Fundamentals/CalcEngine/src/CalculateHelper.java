import java.text.NumberFormat;

public class CalculateHelper {
    MathCommand command;
    double leftValue;
    double rightValue;
    double result;
    private static final char ADD_SYMBOL = '+';
    private static final char SUB_SYMBOL = '-';
    private static final char MUL_SYMBOL = '*';
    private static final char DIV_SYMBOL = '/';

    public void process(String statement) throws InvalidStatementException {
        String[] parts = statement.split(" ");
        if(parts.length != 3) {
            throw new InvalidStatementException("Incorrect number of fields", statement);
        }
        String commandString = parts[0];

        try {
            leftValue = Double.parseDouble(parts[1]);
            rightValue = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }

        setCommandFromString(commandString);

        if (command == null) {
            throw new InvalidStatementException("Invalid command", statement);
        }

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
            command = null;
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
        }

        String str = String.format("%f %c %f = %f", leftValue, symbol, rightValue, result);
        return str;
    }
}
