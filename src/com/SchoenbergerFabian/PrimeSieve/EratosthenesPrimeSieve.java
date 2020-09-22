/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchoenbergerFabian;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class EratosthenesPrimeSieve implements PrimeSieve {

    final private List<Integer> primes;
    
    public EratosthenesPrimeSieve(int limit){
        primes = getPrimesToLimit(limit);
    }
    
    private List<Integer> getPrimesToLimit(int limit){
        List<Integer> primes = new ArrayList();
        List<Integer> notPrimes = new ArrayList();
        
        for(int i = 2;i<=limit;i++){
            if(!notPrimes.contains(i)){
                primes.add(i);
                for(int j = (int) Math.pow(i,2);j<=limit;j+=i){
                    notPrimes.add(j);
                }
            }
        }
        
        return primes;
    }
    
    @Override
    public boolean isPrime(int p) {
        return primes.contains(p);
    }

    @Override
    public void printPrimes() {
        String primesString = "";
        for (Integer prime : primes) {
            primesString+=prime+", ";
        }
        primesString.substring(0, primesString.length()-2);
        System.out.println(primesString);
    }
    
}
