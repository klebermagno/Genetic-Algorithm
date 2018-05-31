/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.km.genetic;


import com.km.genetic.problem.Codification;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Kleber
 */
public class Plot {
    private Codification pop[];
    private Codification child[] = new Codification[]{null, null, null};
    private JPanel draw;
    private boolean stop = false;
    public Plot() {
        JFrame frame = new JFrame("plot");
        frame.setLayout(new FlowLayout());
        draw = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
                Graphics2D g2 = (Graphics2D) g;
                final int W = getWidth();
                final int H = getHeight();
                final int Sx = 200;
                final int Sy = 120;
                g2.setColor(Color.BLACK);
                g2.drawRect(0, 0, W-1, H-1);
                
                g2.translate(W/3, H*2/3);
                g2.drawLine(-Sx, 0, 2*Sx, 0);
                g2.drawLine(0, -2*Sy, 0, Sy);
             
                for(int i=-Sx+1; i<2*Sx; i++){
                    double x1 = (i-1)*1.0/Sx;
                    double f1 = 1+x1*Math.sin(10*Math.PI*x1);
                    
                    double x2 = i*1.0/Sx;
                    double f2 = 1+x2*Math.sin(10*Math.PI*x2);
                    
                    g2.drawLine((int)(x1*Sx), (int)(-f1*Sy), (int)(x2*Sx), (int)(-f2*Sy));
                }
                final int r = 5;
                if(pop!=null){
                    for(Codification c : pop){
                        g2.setColor(Color.GRAY);
                        g2.fillOval((int)(c.x*Sx-r), (int)(-c.fitness*Sy-r), 2*r+1, 2*r+1);
                        g2.setColor(Color.BLACK);
                        g2.drawOval((int)(c.x*Sx-r), (int)(-c.fitness*Sy-r), 2*r+1, 2*r+1);
                    }
                    for(int i=0; i<child.length; i++){
                        Codification c = child[i];
                        if(c!=null){
                            g2.setColor(i<2?Color.ORANGE : Color.GREEN);
                            g2.fillOval((int)(c.x*Sx-r), (int)(-c.fitness*Sy-r), 2*r+1, 2*r+1);
                            g2.setColor(Color.BLACK);
                            g2.drawOval((int)(c.x*Sx-r), (int)(-c.fitness*Sy-r), 2*r+1, 2*r+1);
                        }
                            
                    }
                }
            }
        };
        draw.setBackground(Color.WHITE);
        draw.setPreferredSize(new Dimension(800, 600));
        frame.add(draw);
        
        JButton btm = new JButton("Next");
        btm.addActionListener((e)->{
            stop = false;
        });
        frame.add(btm);
        
        frame.setSize(820, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void waitNext() throws InterruptedException{
        this.stop = true;
        while(stop){
            Thread.sleep(100);
        }
    }
    public void setPop(Codification[] pop) {
        this.pop = pop;
    }
    public void repaint() {
        draw.repaint();
    }

    public void crossover(Codification c1, Codification c2, Codification c3) {
        child[0] = c1;
        child[1] = c2;
        child[2] = c3;
    }
    
    
    
}
