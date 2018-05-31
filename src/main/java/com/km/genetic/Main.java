/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.km.genetic;

import com.km.genetic.method.GeneticAlgorithmPlot;

/**
 *
 * @author Kleber
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        
        //GeneticAlgorithm GA = new GeneticAlgorithm();
        GeneticAlgorithmPlot GA = new GeneticAlgorithmPlot();
        
        GA.execute();
    }
    
    
    
    
}
