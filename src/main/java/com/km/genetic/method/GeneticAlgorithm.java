/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.km.genetic.method;

import com.km.genetic.problem.Codification;

/**
 *
 * @author Kleber
 */
public class GeneticAlgorithm {

    private Codification pop[];
    
    
    public GeneticAlgorithm() {
        this.pop = new Codification[10];
    }
    
    public void execute(){
        for(int i=0; i<pop.length; i++){
            pop[i] = new Codification();
            pop[i].initialize();
            pop[i].doFitness();
        }
        
        
        int n = 0;
        while(n++<10000){
            int p1 = torneio();
            int p2 = torneio();
            
            Codification child = pop[p1].crossover(pop[p2]);
            child.mutation();
            child.doFitness();

            int worst = pop[p1].fitness < pop[p2].fitness ? p1 : p2;
            if(child.fitness > pop[worst].fitness){
                pop[worst] = child;
            }
        }
        Codification best = best();
        System.out.println("best - x = "+best.x);
        System.out.println("best - fitness = "+best.fitness);
        
    }
    
    private Codification best() {
        int best = 0;
        for(int j=0; j<pop.length; j++){
            if(pop[j].fitness > pop[best].fitness){
                best = j;
            }
        }
        return pop[best];
    }

    private int torneio() {
        int selected = (int) (Math.random()*pop.length);
        for(int j=0; j<3; j++){
            int r = (int) (Math.random()*pop.length);
            if(pop[r].fitness > pop[selected].fitness){
                selected = r;
            }
        }
        return selected;
    }
}
