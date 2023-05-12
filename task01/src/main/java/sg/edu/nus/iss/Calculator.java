package sg.edu.nus.iss;

import java.util.List;
import java.util.Scanner;

public class Calculator {

    private float last;
    private Scanner scanner;

    public Calculator(Scanner scanner){
        this.last = 0;
        this.scanner = scanner;

    }
    
    public void start() {
        while (true) {
            System.out.println("> ");
            String input = scanner.nextLine();

            if (input.toLowerCase().trim().equals("exit")) {
                System.out.println("Bye bye");
                break;
            }

            String[] components = new String[3];
            components = input.split(" ");
            float firstNo = 0;
            float secondNo = 0;

            if (components[0].contains("last")) {
                firstNo = this.last;
            } else{
                firstNo = Float.parseFloat(components[0]);
            }

            if (components[2].contains("last")){
                secondNo = getLast();
            } else {
                secondNo = Float.parseFloat(components[2]);
            }

            String operator = components[1];

            if (operator.equals("+")) {
                    System.out.println(add(firstNo, secondNo));}
                else if (operator.equals("-")){
                    System.out.println(subtract(firstNo, secondNo));}
                else if (operator.equals("*")){
                    System.out.println(multiply(firstNo, secondNo));}
                else if (operator.equals("/")){
                    System.out.println(divide(firstNo, secondNo));}
                else if (operator.equals("x")){
                    System.out.println(multiply(firstNo, secondNo));}
            }

        }

    public float add(float no1, float no2) {
        this.last = no1 + no2;
        return no1 + no2;
     
    }

    public float subtract(float no1, float no2) {
        this.last = no1 - no2;
        return this.last;
    }

    public float divide(float numerator, float divisor) {
        this.last = numerator / divisor;
        return this.last;
    }

    public float multiply(float no1, float no2) {
        this.last = no1 * no2 * 1.00f;
        return this.last;
    }

    public float getLast() {
        return this.last;
    }
}
