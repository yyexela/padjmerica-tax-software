import java.util.Scanner;
import java.text.*;

class taxCalc{
    public static void main(String[] args){
        
        // INITIALIZING VARIABLES AND SCANNER
        
        DecimalFormat numform = new DecimalFormat("0.00");
        Scanner scan = new Scanner(System.in);

        int grossIncome = 0;
        int children = 0;
        int childrenDiscount = 0;
        int age = 0;
        double amountDeducted = 0;
        double totalTax = 0;

        // ASKING FOR USER INPUT

        System.out.println("What is the gross income before taxes?");
        grossIncome = scan.nextInt();

        System.out.println("How many children do you have?");
        children = scan.nextInt();

        System.out.println("How old are you?");
        age = scan.nextInt();

        // IF STATEMENTS FOR TAX BRACKETS

        if(grossIncome >= 10000){
            if(grossIncome < 25000){
                if(((grossIncome - 10000.0) * 0.1) < 500){
                    amountDeducted = amountDeducted + 500;
                } else {
                    amountDeducted = amountDeducted + ((grossIncome - 10000.0) * 0.1);
                }
            } else {
                amountDeducted = amountDeducted + (15000 * 0.1);
            }
        }

        //System.out.println("Tier 2 " + amountDeducted);

        if(grossIncome >= 25000){
            if(grossIncome < 75000){
                if(((grossIncome - 25000.0) * 0.2) < 5000){
                    amountDeducted = amountDeducted + 5000;
                } else {
                    amountDeducted = amountDeducted + ((grossIncome - 25000.0) * 0.2);
                }
            } else {
                amountDeducted = amountDeducted + (50000 * 0.2);
            }
        }

        //System.out.println("Tier 3 " + amountDeducted);

        if(grossIncome >= 75000){
            if(grossIncome < 250000){
                if(((grossIncome - 75000.0) * 0.3) < 10000){
                    amountDeducted = amountDeducted + 10000;
                } else {
                    amountDeducted = amountDeducted + ((grossIncome - 75000.0) * 0.3);
                }
            } else {
                amountDeducted = amountDeducted + ((250000 - 75000) * 0.3);
            }
        }

        //System.out.println("Tier 4 " + amountDeducted);

        if(grossIncome >= 250000){
            if(((grossIncome - 250000) * 0.5) < 25000){
                amountDeducted = amountDeducted + 25000;
            } else {
                amountDeducted = amountDeducted + ((grossIncome - 250000.0) * 0.5);
            }
        }

        //System.out.println("Tier 5 " + amountDeducted);

        // IF STATEMENTS FOR CHILDREN

        if(children > 0 && children <= 2){
            childrenDiscount = 1000;
        } else if(children > 2){
            childrenDiscount = ((children - 2) * 500) + 1000;
        }

        // AGE DISCOUNTS

        totalTax = amountDeducted - childrenDiscount;

        if(totalTax < 0){
            totalTax = 0;
        }

        if(totalTax >= 0){
            if(age >= 0 && age <= 15){
                totalTax = totalTax * 0.5;
            }

            if(age >= 16 && age <= 21){
                totalTax = totalTax * (1 - 0.25);
            }

            if(age >= 64 && age <= 72){
                totalTax = totalTax * (1 - 0.33);
            }

            if(age >= 73 && age <= 80){
                totalTax = totalTax * (1 - 0.66);
            }

            if(age >= 81){
                totalTax = 0;
            }
        }  

        // Formatting

        String totalTaxStr = numform.format(totalTax);

        // System.out.println checks

        System.out.println("Gross: $" + grossIncome);
        System.out.println("amountDeducted: $" + amountDeducted);
        System.out.println("childrenDiscount: $" + childrenDiscount + " for " + children + " children");
        System.out.println("Total tax: $" + totalTaxStr);


    }
}