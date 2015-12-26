package Common;



import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Bode.SemiLogDemo;
import Nyquist.NyquistPlot;
import Polar.PolarPlot;



public class Panel extends JFrame implements ActionListener {
	
	// Variables declaration - do not modify
    private Button BodeBtn;
    private Label ComplexPoleLabel;
    private JTextField ComplexPoleTxtField;
    private Label ComplexZeroLabel;
    private JTextField ComplexZeroTxtField;
    private JTextField DenominatorConstTxtField;
    private Label DenominatorLabel;
    private JTextField NumeratorConstTxtField;
    private Label NumeratorLabel;
    private Button NyquistBtn;
    private Button PolarBtn;
    private Button RootBtn;
    private Label SimplePoleLabel;
    private JTextField SimplePoleTxtField;
    private Label SimpleZeroLabel;
    private JTextField SimpleZeroTxtField;
    private Label Title;
    // End of variables declaration
	
	String BodeAction = "BodePlot";
	String PolarAction = "PolarPlot";
	String NyquistAction = "NyquistPlot";
	String RootLocusAction ="RootLocus";
	
	 private String SimpleZeroToolTip = "For s(s+b)(s+c) input 0 b c"; 
	 private String SimplePoleToolTip = "For s(s+b)(s+c) input 0 b c";
	 private String ComplexZeroToolTip = "For s^2+bS+c input b c";
	 private String ComplexPoleToolTip = "For s^2+bS+c input b c";
	 private String NumeratorConstToolTip = "Input Numerator Constant";
	 private String DenominatorConstToolTip = "Input Denominator Constant";
	
	 
/** Creates new form panel */
    public Panel() 
    {
    	super("CtrlSSv1.0");
    	
    	

    	Title = new java.awt.Label();
        SimpleZeroLabel = new java.awt.Label();
        SimplePoleLabel = new java.awt.Label();
        ComplexZeroLabel = new java.awt.Label();
        ComplexPoleLabel = new java.awt.Label();
        NumeratorLabel = new java.awt.Label();
        DenominatorLabel = new java.awt.Label();
        SimpleZeroTxtField = new JTextField();
        SimplePoleTxtField = new JTextField();
        ComplexZeroTxtField = new JTextField();
        ComplexPoleTxtField = new JTextField();
        NumeratorConstTxtField = new JTextField();
        DenominatorConstTxtField = new JTextField();
        BodeBtn = new java.awt.Button();
        PolarBtn = new java.awt.Button();
        NyquistBtn = new java.awt.Button();
        RootBtn = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        Title.setFont(new java.awt.Font("Lucida Calligraphy", 3, 18)); // NOI18N
        Title.setText("CONTROL SYSTEM SIMULATOR");
        
        RootBtn.addActionListener(this);
        BodeBtn.addActionListener(this);
        NyquistBtn.addActionListener(this);
        PolarBtn.addActionListener(this);
        
        RootBtn.setActionCommand(RootLocusAction);
        BodeBtn.setActionCommand(BodeAction);
        NyquistBtn.setActionCommand(NyquistAction);
        PolarBtn.setActionCommand(PolarAction);
        
        SimpleZeroTxtField.addActionListener(this);
	    SimplePoleTxtField.addActionListener(this);
	    ComplexZeroTxtField.addActionListener(this);
	    ComplexPoleTxtField.addActionListener(this);
	    NumeratorConstTxtField.addActionListener(this);
	    DenominatorConstTxtField.addActionListener(this);
	    
	    SimpleZeroTxtField.setToolTipText(SimpleZeroToolTip);
        SimplePoleTxtField.setToolTipText(SimplePoleToolTip);
        ComplexPoleTxtField.setToolTipText(ComplexPoleToolTip);
        ComplexZeroTxtField.setToolTipText(ComplexZeroToolTip);
        NumeratorConstTxtField.setToolTipText(NumeratorConstToolTip);
        DenominatorConstTxtField.setToolTipText(DenominatorConstToolTip);
	    
	    
	    
	    

        SimpleZeroLabel.setText("Zeros : ");

        SimplePoleLabel.setText("Poles : ");

        ComplexZeroLabel.setText("Complex Zero : ");

        ComplexPoleLabel.setText("Complex Pole");

        NumeratorLabel.setText("Numerator : ");

        DenominatorLabel.setText("Denominator : ");

        BodeBtn.setLabel("Bode Plot");
  
        PolarBtn.setLabel("Polar Plor");

        NyquistBtn.setLabel("Nyquist Plot");

        RootBtn.setEnabled(false);
        RootBtn.setLabel("RootLocus");
        
        


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BodeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DenominatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SimpleZeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumeratorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SimplePoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComplexPoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComplexZeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(PolarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(NyquistBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(RootBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(SimplePoleTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SimpleZeroTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(ComplexZeroTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComplexPoleTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(NumeratorConstTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(DenominatorConstTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SimpleZeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SimpleZeroTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SimplePoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SimplePoleTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComplexZeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComplexZeroTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComplexPoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComplexPoleTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NumeratorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumeratorConstTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DenominatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DenominatorConstTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BodeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RootBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PolarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NyquistBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>

  

   

public void actionPerformed(ActionEvent e) 
{
	String d = e.getActionCommand();
	int countzero;
			
				int flag = 0;
				int flag1=1;
			
				String SimpleZeros = SimpleZeroTxtField.getText();
				String SimplePoles = SimplePoleTxtField.getText();
				String ComplexZeros = ComplexZeroTxtField.getText();
				String ComplexPoles = ComplexPoleTxtField.getText();
				String Numerator = NumeratorConstTxtField.getText();
				String Denominator = DenominatorConstTxtField.getText();
			
				Double value,img;
				
				ArrayList<CornerFrequency> arraycornerfreq = new ArrayList<CornerFrequency>();
				
				if(!Empty(SimpleZeros))
				{
					flag = 1;
					String[]zero = SimpleZeros.split(" ");
					countzero = countZero(zero);
					if(countzero!=0)
					{
						for(int i=0; i<countzero; i++)
						{
						CornerFrequency corner = new CornerFrequency(0,1);
						arraycornerfreq.add(corner);
						}
						}
					
					for(int i =0;i<zero.length;i++)
					{
						value = Double.parseDouble(zero[i]);
						if(value!=0)
						{
							CornerFrequency corner = new CornerFrequency(value,1);
							arraycornerfreq.add(corner);
						}
					}
				}
				
				
				if(!Empty(SimplePoles))
				{
					flag = 1;
					String[]pole = SimplePoles.split(" ");
					countzero = countZero(pole);
					if(countzero!=0)
					{
						for(int i=0; i<countzero; i++)
						{
						CornerFrequency corner = new CornerFrequency(0,-1);
						arraycornerfreq.add(corner);
						}
						}
					
					for(int i =0;i<pole.length;i++)
					{
						
						value = Double.parseDouble(pole[i]);
						if(value!=0)
						{
							CornerFrequency corner = new CornerFrequency(value,-1);
							arraycornerfreq.add(corner);
						}
					}
				}
				
				
				if(!Empty(ComplexZeros))
				{
					flag = 1;
					String[] Czero = ComplexZeros.split(" ");
					
					if(Czero.length%2!=0)
					{
						JOptionPane.showMessageDialog(null, "Invalid input in Complex Zero Field");
						flag1 = 0;
					}
					
					else
					{
						for(int i=0; i<Czero.length; i+=2)
						{
							value = Double.parseDouble(Czero[i+1]);
							img = Double.parseDouble(Czero[i]);
							CornerFrequency corner = new CornerFrequency(value, img, 2);
							arraycornerfreq.add(corner);
					
						}
					}
				}
				
				if(!Empty(ComplexPoles))
				{
					flag = 1;
					String[] Cpole = ComplexPoles.split(" ");
					if(Cpole.length%2!=0)
					{
						JOptionPane.showMessageDialog(null, "Invalid input in Complex Pole Field");
						flag1 = 0;
					}
						else
					{
							for(int i=0; i<Cpole.length; i+=2)
							{
								value = Double.parseDouble(Cpole[i+1]);
								img = Double.parseDouble(Cpole[i]);
								CornerFrequency corner = new CornerFrequency(value, img, -2);
								arraycornerfreq.add(corner);
						
							}
					}
				}
				
				Double num,den;
				
				if(Empty( Numerator ))		{	num = 1.0;  }
				
				else {  num = Double.parseDouble(Numerator); }
				
				
				if(Empty(Denominator)) { den = 1.0;  }
				
				else {	 den = Double.parseDouble(Denominator);	}
				
				num = num/den;
				
				CornerFrequency corner = new CornerFrequency(num, 0);
				
				arraycornerfreq.add(corner);
				
				int arraycount = arraycornerfreq.size();
				
				CornerFrequency[] corners = new CornerFrequency[arraycount];
				
				arraycornerfreq.toArray(corners);
				
				//System.out.println("The size of array is : "+arraycount);
				
				
				
				
				if(flag!=0 && flag1!=0)
				{
				
					if(d.equals(BodeAction))
					{
							SemiLogDemo.displayFrame(corners);
					}
					else if(d.equals(PolarAction))
					{
						PolarPlot polar = new PolarPlot(corners);
					}
					else if(d.equals(NyquistAction))
					{
						NyquistPlot nyquist = new NyquistPlot();
						nyquist.displayNyquistPlot(corners);
					}
					else if(d.equals(RootLocusAction))
					{
						System.out.println("Under Construction");
					}
				}//end of else
				
				else if(flag == 0 )
				{
					JOptionPane.showMessageDialog(null, "You have not enter the data yet!");
				}
				
		
			
	
}//end of Actionperformed
			
			
			

			


    
    
    private int countZero(String[] str)
    {
 	  
 	   int count=0;
 	double value;
 	   for(int i= 0;i<str.length;i++)
 	   {
 		   value =Double.parseDouble(str[i]);
 		   if(value==0)
 			   count++;
 	   }
 	   return count;
    
    }
    
    private boolean Empty(String str)
    {
 	   int leng = str.length();
 	   if(leng==0)
 	   {
 		   return true;
 	   }
 	   else return false ;
    }
    


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    

}
