package tstudent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentTDistribution extends JFrame {

    int h = 400;
    int w = 700;
    double alpha = 0.95;
    int df = 42;
    
    private JPanel jPanel;
    private JLabel labelAlpha;
    private JLabel labelDf;
    private JTextField textFieldAlpha;
    private JTextField textFieldDf;
    private JButton buttonDraw;
    
    final static double[] LANCZOSTABLE = {
         1.000000000190015,
        76.18009172947146,
       -86.50532032941677,
        24.01409824083091,
        -1.231739572450155,
         0.1208650973866179e-2,
        -0.5395239384953e-5
    };
    final double LN_SQRT_2_PI = 0.91893853320467274178;

    /**
     * Callculating Gamma using the Lanczos method
     * 
     * @param x
     * @return logarithm of the Gamma function
     */
    double ln_gamma_lanczos(double x) {
        
        if (x < 0.5) {
          return Math.log(Math.PI / Math.sin(Math.PI * x)) - ln_gamma_lanczos(1.0 - x);
        }
        
        x = x - 1.0;
        double sum = 0;
        for(int i=1; i<LANCZOSTABLE.length; i++) {
            sum += LANCZOSTABLE[i]/(x+i);
        }
        sum += LANCZOSTABLE[0];
        return ((LN_SQRT_2_PI+Math.log(sum))-x-5.5)+Math.log(x+5.5)*(x+0.5);
        
      }

    public double gamma(double x) {
        return Math.exp(ln_gamma_lanczos(x));
    }
    
    double dt(double x, int df) {
        return gamma((1.0+df)/2) /
                (Math.sqrt(Math.PI*df)*gamma(df/2.0)) *
                Math.pow(1.0+(x*x)/df, -(1.0+df)/2);
    }
    
    public double qt(double alpha, int df) {
        double sum = 0;
        double pos = -1000;
        double stepSize = 0.01;
        while (sum<alpha) {
            sum += dt(pos, df)*stepSize;
            pos += stepSize;
        }
        return pos;
    }
    
    public StudentTDistribution() {

        daten = new double[w];
        for (int i=0; i<w; i++) {
            daten[i] = dt(-5.0+(10.0/w)*i, 42);
        }

        initGui();
        repaint();
    }
    
    private void initGui() {
        try {
            this.setTitle("Student t-distribution");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            jPanel = new JPanel();
            jPanel.setLayout(null);
            getContentPane().add(jPanel, BorderLayout.CENTER);

            labelAlpha = new JLabel();
            labelAlpha.setText("P(T<=t) = ");
            labelAlpha.setBounds(25, 10, 75, 25);
            jPanel.add(labelAlpha);
            
            textFieldAlpha = new JTextField();
            textFieldAlpha.setText("0.95");
            textFieldAlpha.setBounds(75, 10, 100, 25);
            jPanel.add(textFieldAlpha);
        
            labelDf = new JLabel();
            labelDf.setText("Df = ");
            labelDf.setBounds(200, 10, 75, 25);
            jPanel.add(labelDf);

            textFieldDf = new JTextField();
            textFieldDf.setText("42");
            textFieldDf.setBounds(250, 10, 100, 25);
            jPanel.add(textFieldDf);
            
            buttonDraw = new JButton();
            buttonDraw.setText("draw");
            buttonDraw.setBounds(375, 10, 100, 25);
            buttonDraw.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    df = 42;
                    alpha = 0.95;
                    try {
                        df = Integer.parseInt(textFieldDf.getText());
                        alpha = Double.parseDouble(textFieldAlpha.getText());
                    } catch (Exception e) {
                        
                    }
                    daten = new double[w];
                    for (int i=0; i<w; i++) {
                        daten[i] = dt(-5.0+(10.0/w)*i, df);
                    }
                    repaint();
                }
            });
            jPanel.add(buttonDraw);
            
            pack();
            setBounds(0, 0, 800, 620);
            setLocationRelativeTo(null);
            
            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    double[] daten;
    
    public void paint(Graphics g){
        super.paint(g);
        int x0 = 0;
        int y0 = h;
        
        int xOff = 75;
        int yOff = 150;
        
        g.setColor(Color.black);
        g.drawLine(xOff+0, yOff+y0, xOff+w, yOff+y0);
        g.drawLine(xOff+0, yOff, xOff+0, yOff+h);

        for (int i=0; i<11; i++) {
            int ypos = (int)(yOff+y0-i*(h/10.0));
            g.drawLine(xOff-25, ypos, xOff, ypos);
            g.drawString(""+(i/10.0), xOff-45, ypos);
        }

        for (int i=0; i<11; i++) {
            int xpos = (int)(xOff+x0+i*(w/10.0));
            g.drawLine(xpos, yOff+y0, xpos, yOff+y0+25);
            g.drawString(""+(-5.0+i), xpos, yOff+y0+45);
        }
        
        g.setColor(Color.GREEN);

        g.setColor(Color.BLUE);
        
        for (int i=0; i<daten.length-1; i++) {
            g.drawLine(xOff+i, yOff+h-(int)(daten[i]*h), xOff+i+1, yOff+h-(int)(daten[i+1]*h));
        }
        
        int pos = (int)((5+qt(alpha, df))*(w/10.0));
        g.setColor(Color.RED);
        for (int x=0; x<pos; x++) {
            if ((int)(daten[x]*h)>1)
                g.drawLine(xOff+x, yOff+h-(int)(daten[x]*h)+1, xOff+x, yOff+h-1);
        }
            
    }
    
    public static void main(String[] args) {
        new StudentTDistribution();
    }

}