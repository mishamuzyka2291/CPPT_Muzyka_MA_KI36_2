import java.io.*;
import java.util.*;

public class Labtwo
{

	public static void main(String[] args) throws FileNotFoundException
	{
		 int nRows;
	        char[][] arr;
	        String filler;
	        Scanner in = new Scanner(System.in);
	        File dataFile = new File("MyFile.txt");
	        PrintWriter fout = new PrintWriter(dataFile);
	        System.out.print("Введіть розмір квадратної матриці: ");
	        nRows = in.nextInt();
	        in.nextLine();
	        final String spaceRepeats = " ".repeat(2+(nRows-3)*2);
	        arr = new char[nRows][];
	        for(int i = 0; i < nRows; i++) {
	            if (i == 0 || i == nRows-1) arr[i]= new char[nRows];
	            else arr[i] = new char[2];
	        }
	        System.out.print("\n Введіть символ заповнювач:  ");
	        filler = in.nextLine();
	        exit:
	        for(int i = 0; i < nRows; i++) {
	            for(int j = 0; j < nRows; j++) {
	                if(filler.length() == 1) {
	                    arr[i][0] = (char) filler.codePointAt(0);
	                    arr[i][1] = (char) filler.codePointAt(0);
	                    arr[0][j] = (char) filler.codePointAt(0);
	                    arr[nRows-1][j] = (char) filler.codePointAt(0);
	                    if(i != 0 && i != nRows-1 && j == 1) {
	                        System.out.print(spaceRepeats  + arr[i][j]);
	                        fout.print(spaceRepeats  + arr[i][j]);
	                    }
	                    else if ((i == 0 || i == nRows-1)||((i != 0 || i != nRows-1)&& j == 0)) {
	                        System.out.print(arr[i][j] + " ");
	                        fout.print(arr[i][j] + " ");
	                    }
	                }
	                else if (filler.length() == 0) {
	                    System.out.print("\nNo placeholder character entered");
	                    break exit;
	                }
	                else {
	                    System.out.print("\nToo many placeholder characters");
	                    break exit;
	                }
	            }
	            System.out.print("\n");
	            fout.print("\n");
	        }
	        fout.flush();
	        fout.close();
    }

}



	
	
