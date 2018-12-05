package src.com.kimput.calcengine;

public class Multiplier extends CalculateBase {
    public Multiplier() {    }

    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double result = getLeftVal() * getRightVal();
        setResult(result);
    }
}
