/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchoenbergerFabian.PrimeSieve;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Fabian
 */
public class EratosthenesPrimeSieve implements PrimeSieve {

    final private List<Integer> primes;
    
    final private int limit;
    
    public EratosthenesPrimeSieve(int limit){
        this.limit = limit;
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
    
    public List<Integer> getPrimes(){
        return primes;
    }
    
    @Override
    public boolean isPrime(int p) {
        return primes.contains(p);
    }

    @Override
    public void printPrimes() {
        String primesString = "\n";
        for (Integer prime : primes) {
            primesString+=prime+"\n";
        }
        
        if(primesString.equals("\n")){
            primesString = "There were no prime numbers found for \""+limit+"\"";
        }
        
        System.out.println(primesString);
    }
    
    private Map<Integer,Integer> getPrimeSummands(){
        Map<Integer,Integer> summands = new TreeMap();
        for(int i = primes.size()-1;i>=0;i--){
            if(isPrime(limit-primes.get(i))&&!summands.values().contains(limit-primes.get(i))){
                summands.put(limit-primes.get(i), primes.get(i));
            }
        }
        return summands;
    }
    
    public void printPrimeSummands(){
        String summandsString = "\n";
        Map<Integer,Integer> summands = getPrimeSummands();
        for (Map.Entry<Integer, Integer> entry : summands.entrySet()) {
            summandsString += entry.getKey()+" + "+entry.getValue()+"\n";
        }
        
        if(summandsString.equals("\n")){
            summandsString = "\nThere was no pair of prime summands found\n";
        }
        
        System.out.println(summandsString);
    }
    
}
