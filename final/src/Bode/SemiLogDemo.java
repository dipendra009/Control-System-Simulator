package Bode;

import javax.swing.JFrame;


import Common.CornerFrequency;
//This is the final bode plot coding....
public class SemiLogDemo
{
    public static void displayFrame(CornerFrequency[] corner)
    {
    	
    	
        JFrame frame = new JFrame("Using SemiLog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SemiLog graphs = new SemiLog(corner);
        frame.add(graphs);
        frame.setSize(1400 , 900);
        frame.setVisible(true);
    }
}