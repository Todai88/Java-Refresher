package com.kimput.calcapp;

import com.kimput.calcengine.Adder;
import com.kimput.calcengine.DynamicHelper;
import com.kimput.calcengine.MathProcessing;
import com.kimput.calcengine.PowerOf;
import com.kimput.calcengine.Subtractor;
import com.kimput.calcengine.CalculateBase;
import com.kimput.calcengine.CalculateHelper;
import com.kimput.calcengine.Divider;
import com.kimput.calcengine.MathEquation;
import com.kimput.calcengine.Multiplier;
import com.kimput.invalidstatementexception.InvalidStatementException;

public class Main {

    public static void main(String[] args){
        /*useMathEquation();
        useCalculatorBase();
        useCalculatorHelper();*/
        useDynamicCalculatorHelper();
    }

    private static void useCalculatorHelper() {
        String[] statements = {
                "add 25.0 92.0"
        };

        CalculateHelper calcHelper = new CalculateHelper();
        for(String statement:statements) {
            try {
                calcHelper.process(statement);
                System.out.println(calcHelper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("   Original exception: " + e.getCause().getMessage());
                }
            }
        }
    }

    private static void useDynamicCalculatorHelper() {
        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"
        };

        /* CalculateHelper calcHelper = new CalculateHelper();*/
        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });

        for(String statement:statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }
    }

    private static void useCalculatorBase() {
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

    private static void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0, 50.0, 'd');
        equations[1] = new MathEquation(25.0, 92.0, 'a');
        equations[2] = new MathEquation(225.0, 17.0, 's');
        equations[3] = new MathEquation(11.0, 3.0, 'm');

        for (MathEquation equation: equations) {
            System.out.println(equation.execute());
        }
    }

    public static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation(leftVal, rightVal, opCode);
        return equation;
    }
}