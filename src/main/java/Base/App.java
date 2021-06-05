/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package Base;

import java.util.Scanner;
import java.lang.Math;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        String principal = getData("principal");
        String ROI = getData("rate of interest");
        String years = getData("number of years");
        String compound = getData("number of times the interest is compounded per year");
        double principalNum = stringToDouble(principal);
        double ROINum = stringToDouble(ROI);
        double yearsNum = stringToDouble(years);
        double compNum = stringToDouble(compound);
        double total = calcTotal(principalNum, ROINum, yearsNum, compNum);
        printOutput(principal, years, ROI, compound, total);
    }
    public static String getData(String phrase)
    {
        System.out.printf( "Enter the %s: ", phrase);
        return in.nextLine();
    }

    public static double stringToDouble(String number)
    {
        return Double.parseDouble(number);
    }

    public static double calcTotal(double principalNum, double ROINum, double yearsNum, double compNum)
    {
        ROINum /= 100;
        double base = 1 + (ROINum / compNum);
        double exponent = compNum * yearsNum;
        double total = principalNum * Math.pow(base, exponent);;

        total *= 100;
        total = Math.ceil(total);
        return total / 100;
    }

    public static void printOutput (String principal, String years, String ROI, String compound, double total)
    {
        String output = "$" + principal + " invested at " + ROI + "% for " + years + " years compounded "
                + compound + " times per year is $" ;
        System.out.printf ( "%s%.2f", output, total );

    }
}

