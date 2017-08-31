/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabmiclientapplication;

import java.util.Scanner;

/**
 *
 * @author Vishal Prasad
 */
public class JavaBmiClientApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double weight, height, bmi;
        char gender;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Your Weight in Kgs:");
        weight = s.nextDouble();

        System.out.println("\nEnter Your Height in Meters:");
        height = s.nextDouble();
        try {
            bmi = calculateBMI(height, weight);

            if (bmi < 18.5) {
                System.out.println("\n\n You are Underweight\n");
                System.out.println("BMI: " + bmi);
            } else if (bmi < 24.9 && bmi >= 18.5) {
                System.out.println("\n\n You are Healthy\n");
                System.out.println("BMI: " + bmi);
            } else if (bmi < 30 && bmi >= 24.9) {
                System.out.println("\n\n You are Overweight\n");
                System.out.println("BMI: " + bmi);
            } else if (bmi >= 30) {
                System.out.println("\n\n You are Obese\n");
                System.out.println("BMI: " + bmi);
            }
        } catch (Exception e) {
            System.out.println("\n\nSomething went wrong...unable to process your request!!!");
        }

    }

    private static double calculateBMI(double height, double weight) {
        org.mindfire.webservices.BmiCalculatorWS_Service service = new org.mindfire.webservices.BmiCalculatorWS_Service();
        org.mindfire.webservices.BmiCalculatorWS port = service.getBmiCalculatorWSPort();
        return port.calculateBMI(height, weight);
    }

}
