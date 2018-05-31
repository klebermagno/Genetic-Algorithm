/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.km.genetic.problem;

/**
 *
 * @author Kleber
 */
public class Codification {
    public double x;
    public double fitness;
    
    public void initialize(){
        x = Math.random()*3 - 1;
    }
    public void doFitness(){
        //f(x) = x * sen ( 10 * ∏ * x ) 
        fitness = 1 + x * Math.sin(10*Math.PI*x);
    }
    
    public Codification crossover(Codification ind2){
        Codification ind1 = this;
        Codification child = new Codification();
        //child.x = (ind1.x + ind2.x)/2;
        
        //BLX-alfa
        
        //x1, x2 -> x3 [x1 + (x2-x1)(1+alfa-beta)]
        
        double alfa = 0.5;
        
        double beta = -alfa + Math.random()*(1+2*alfa);
        
        child.x = ind1.x + (ind2.x-ind1.x) * beta;
                
                
        return child;
    }
    public void mutation(){
        x *= (0.9+Math.random()*0.2);
        x = Math.max(x, -1);
        x = Math.min(x, +2);    //x in [-1 .. 2]
    }
}
