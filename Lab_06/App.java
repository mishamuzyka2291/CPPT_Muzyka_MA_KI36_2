package Lab_06;

import java.io.*;
import java.util.*;



public class App {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter data: ");
        int data = s.nextInt();
        obj.calculate(data);
        System.out.println("Result is: " + obj.getResult());
        obj.writeResTxt("Lab_06/textRes.txt");
        obj.writeResBin("Lab_06/BinRes.bin");
        obj.readResBin("Lab_06/BinRes.bin");
        System.out.println("Result in binary file is: " + obj.getResult());
        obj.readResTxt("Lab_06/textRes.txt");
        System.out.println("Result in txt file is: " + obj.getResult());
    }
}

/**
* Клас CalcWFio реалізує обчислення виразу і читання/запис у файл
*/
class CalcWFio {
    /** 
     * Method реалізує запис у текстовий файл
     * @param fName
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ",result);
        f.close();
    }

    /** 
     * Method реалізує читання текстового файлу
     * @param fName
     */
    public void readResTxt(String fName) {
        try {
            File f = new File (fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            }
            else throw new FileNotFoundException("File " + fName + "not found");
        }
        catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
    }

    /** 
     * Method реалізує запис у бінарний файл
     * @param fName
     */
    public void writeResBin(String fName) throws FileNotFoundException, IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /** 
     * Method реалізує читання бінарного файлу
     * @param fName
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    /** 
     * Method реалізує обчислення виразу
     * @param x
     */
    public void calculate(int x) {
        int tanValue = 2 * x - 4;
        double rad = Math.toRadians(tanValue);
        try {
            result = ((7.0 * x) / Math.tan(rad));
            if (result==Double.NaN || result==Double.NEGATIVE_INFINITY || result==Double.POSITIVE_INFINITY || tanValue == 90 || tanValue == -90) throw new ArithmeticException();
        }
        catch (ArithmeticException ex) {
            if (rad==Math.PI / 2.0 || rad==-Math.PI / 2.0) throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else if (tanValue == 0) throw new CalcException("Exception reason: X = 0");
            else throw new CalcException("Unknown reason of the exception during exception calculation");
        }
    }
    
    /** 
     * @return result
     */
    public double getResult() {
        return result;
    }

    private double result;
}

/**
* Клас CalcException реалізує користувацьке виключення
*/
class CalcException extends ArithmeticException {
    /**
    *Constructor
    */ 
    public CalcException(){}
    

    public CalcException(String cause) {
        super(cause);
    }
}