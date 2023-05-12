package sg.edu.nus.iss;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator(scanner);
        calc.start();
        scanner.close();
    }
}
