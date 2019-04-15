package com.training.myapp;


import com.training.calcengine.Adder;
import com.training.calcengine.CalculateBase;
import com.training.calcengine.CalculateHelper;
import com.training.calcengine.Divider;
import com.training.calcengine.DynamicHelper;
import com.training.calcengine.InvalidStatementException;
import com.training.calcengine.MathEquation;
import com.training.calcengine.MathProcessing;
import com.training.calcengine.Multiplier;
import com.training.calcengine.PowerOf;
import com.training.calcengine.Subtracter;

public class Main {

    public static void main(String[] args) {
        //useCalculateHelper();
//     MathEquation testEquation = new MathEquation();
//    testEquation.execute();
//    System.out.print("test=");
//

        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"     //5.0 ^ 2.0 = 25
        };
        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
                new Adder(),
                new PowerOf()
        });
        for (String statement : statements){
            String output = helper.process(statement);
            System.out.println(output);
        }

    } //End of main method
    static void useCalculateHelper() {

            MathEquation[] equations = new MathEquation[4];
            equations[1] = new MathEquation('a', 25.0d, 92.0d);
            equations[0] = new MathEquation('d', 100.d, 50.d);
            equations[2] = new MathEquation('s', 225.0d, 17.0d);
            equations[3] = new MathEquation('m', 11.0d, 3.0d);

            System.out.println("::: for - each loop :::");

            for (MathEquation equation : equations) {
                equation.execute();
                System.out.print("Result is : ");
                System.out.println(equation.getResult());
            }

            System.out.println();
            System.out.println("Using Overloads");
            System.out.println();

            double leftDouble = 9.0d;
            double rightDouble = 4.0d;

            int leftInt = 9;
            int rightInt = 4;

            MathEquation equationOverload = new MathEquation('d');
            equationOverload.execute(leftDouble, rightDouble);
            System.out.print("Result = ");
            System.out.println(equationOverload.getResult());

            equationOverload.execute(leftInt, rightInt);
            System.out.print("Result = ");
            System.out.println(equationOverload.getResult());

            equationOverload.execute((double) leftInt, rightInt);
            System.out.print("Result = ");
            System.out.println(equationOverload.getResult());

            System.out.println();
            System.out.println("Using Inheritance");
            System.out.println();

            CalculateBase[] calculators = {
                    new Divider(100.0d, 50.0d),
                    new Adder(25.0d, 92.0d),
                    new Subtracter(225.0d, 17.0d),
                    new Multiplier(11.0d, 3.0d)
            };
            for (CalculateBase calculator : calculators) {
                calculator.calculate();
                System.out.print("result = ");
                System.out.println(calculator.getResult());

            }
            System.out.println();
            String[] statements = {
                    "add 1.0",
                    "add xx 25.0",
                    "addX 0.0 0.0",
                    "divide 100.0 50.0",
                    "add 23.0 92.0",
                    "subtract 225.0 17.0",
                    "multiply 11.0 3.0"
            };

            CalculateHelper helper = new CalculateHelper();
            for (String statement : statements) {
                try {
                    helper.process(statement);
                    System.out.println(helper);
                } catch (InvalidStatementException e) {
                    System.out.println(e.getMessage());
                    if (e.getCause() != null)
                        System.out.println(" Original Exception: " + e.getCause().getMessage());
                }
            }
        } //useCalculateHelper ends

//    public static MathEquation create(double leftVal, double rightVal, char opCode){
//        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);
//        return equation;
//    }
}//End of Class Main