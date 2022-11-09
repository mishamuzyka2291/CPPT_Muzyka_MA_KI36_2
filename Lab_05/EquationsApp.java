package Lab_05;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;


public class EquationsApp {


    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            PrintWriter fout = new PrintWriter(new File("Lab_05/result"));
            try {
                try {
                    Equations eq = new Equations();
                    out.print("Enter X: ");
                    fout.print(eq.calculate(in.nextInt()));
                }
                finally {
                    fout.flush();
                    fout.close();
                }
            }
            catch (CalcException ex) {
                out.print(ex.getMessage());
            }
        }
        catch (FileNotFoundException ex) {
            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}


/**
 * Клас CalcException реалізує користувацьке виключення
 */
class CalcException extends ArithmeticException {
    /**
     *Constructor
     */
    public CalcException(){}

    /**
     *Constructor
     * @param cause
     */
    public CalcException(String cause) {
        super(cause);
    }
}

/**
 * Клас Equations реалізує обчислення виразу
 */
class Equations {

    /**
     * @param x
     * @throws CalcException
     */
    public double calculate(int x) throws CalcException {
        double y, rad;
        int tanValue = 2 * x - 4;
        rad = Math.toRadians(tanValue);
        try {
            y = ((7.0 * x) / Math.tan(rad));
            if (y==Double.NaN || y==Double.NEGATIVE_INFINITY || y==Double.POSITIVE_INFINITY || tanValue == 90 || tanValue == -90) throw new ArithmeticException();
        }
        catch (ArithmeticException ex) {
            if (rad==Math.PI / 2.0 || rad==-Math.PI / 2.0) throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else if (tanValue == 0) throw new CalcException("Exception reason: X = 0");
            else throw new CalcException("Unknown reason of the exception during exception calculation");
        }
        out.println(y);
        return y;
    }
}