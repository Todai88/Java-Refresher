public class Adder extends CalculateBase {
    public Adder() {    }

    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double result = getLeftVal() + getRightVal();
        setResult(result);
    }

}
