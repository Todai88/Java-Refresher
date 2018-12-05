package src.com.kimput.calcengine;

public class MathEquation {


    public MathEquation(double leftVal, double rightVal, char opCode) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.opCode = opCode;
    }


    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    private double leftVal;
    private double rightVal;
    private double result;
    private char opCode;

    public double execute() {
        switch(this.opCode) {
            case 'a':
                return this.leftVal + this.rightVal;
            case 's':
                return this.leftVal - this.rightVal;
            case 'd':
                return this.rightVal != 0.0 ? this.leftVal / this.rightVal : 0.0;
            case 'm':
                return this.leftVal * this.rightVal;
            default:
                System.out.println("Error - invalid opCode");
                return 0.0;
        }
    }
}