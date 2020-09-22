/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchoenbergerFabian.PrimeSieve;

import java.util.Scanner;

/**
 *
 * @author Fabian
 */
public class Main {
    
   private static final String menu = "1 .. print all prime numbers to [limit]"
           + "\n2 .. get all possible pairs of prime summands for even number [number]"
           + "\n3 .. END";
   private static final String menu1 = "[limit]: ";
   private static final String menu2 = "[number]: ";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in,"Windows-1252");
        EratosthenesPrimeSieve primeSieve;
        int choice;
        do{
            System.out.println(menu);
            choice = getIntInput(scanner);
            switch(choice){
                case 1:
                    System.out.print(menu1);
                    int limit = getIntInput(scanner);
                    if(limit!=-1){
                        primeSieve = new EratosthenesPrimeSieve(limit);
                        primeSieve.printPrimes();
                    }
                    break;
                case 2:
                    System.out.println(menu2);
                    int number = getIntInput(scanner);
                    if(number!=-1){
                        primeSieve = new EratosthenesPrimeSieve(number);
                        primeSieve.printPrimeSummands();
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    break;
            }
        }while(choice != 0);
    }
    
    private static int getIntInput(Scanner scanner){
        String line = scanner.nextLine();
        try{
            return Integer.parseInt(line);
        }catch(NumberFormatException ex){
            System.out.println("\""+line+"\" is not a valid number!");
            return -1;
        }
    }
}
