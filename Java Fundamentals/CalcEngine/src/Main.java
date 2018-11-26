public class Main {

    public static void main(String[] args){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0, 50.0, 'd');
        equations[1] = new MathEquation(25.0, 92.0, 'a');
        equations[2] = new MathEquation(225.0, 17.0, 's');
        equations[3] = new MathEquation(11.0, 3.0, 'm');

        for (MathEquation equation: equations) {
            System.out.println(equation.execute());
        }

        System.out.println("Using inheritance >> ");
        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Multiplier(11.0d, 3.0d),
                new Adder(25.0d, 92.0d),
                new Subtractor(225.0d, 17.0d),
        };
        for (CalculateBase calculator: calculators) {
            calculator.calculate();
            System.out.println(calculator.getResult());
        }
    }

    public static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation(leftVal, rightVal, opCode);

        return equation;
    }
}