public class Subtractor extends CalculateBase{

    public Subtractor() {    }

    public Subtractor(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double result = getLeftVal() - getRightVal();
        setResult(result);
    }
}
