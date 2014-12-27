package lab.pkg6;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;

// Lab 6 
// Abdul Wahab 

public class Lab6 extends JLabel {

    private static final Random RANDI = new Random();   // random object.
    private static final int R = 3; // represents # of buttons on grid.
//public static JLabel jl;
    private static final MouseAdapter MA = new MouseAdapter() { // tracks the mouse events.
//private String c = "Color";

        @Override // used to override method from java.awt.event.MouseAdapter.
        public void mousePressed(MouseEvent me) { // tracks mouse event.
            Lab6 l = (Lab6) me.getSource(); // method which gets the state of the mouse from the mousePressed method. 
            Color c = new Color(RANDI.nextInt());

            showColor(c);
            l.setBackground(c); // sets the background to the colors thrown by the random generator.
// l.getColorModel();

        }
    };

    public Lab6() { // constructor

        this.setBackground(new Color(RANDI.nextInt())); // 
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(45, 45));
        this.addMouseListener(MA); // important!!
//this.add(jl);
//this.getColorModel();
    }

    private static void showColor(Color c) {
    //System.out.println(new Color(RANDI.nextInt() )+"Name of Color");

        String s = "Color";
        if (c.getRed() > c.getBlue() && c.getRed() > c.getGreen()) {
            System.out.println("Red");
        } else if (c.getGreen() > c.getBlue() && c.getGreen() > c.getRed()) {
            System.out.println("Green");
        } else if (c.getBlue() > c.getGreen() && c.getBlue() > c.getRed()) {
            System.out.println("Blue");
        }
    //JLabel jl = new JLabel();

    }

    private static void getColor() {

    //JLabel jl = new JLabel(c.showColor());
    }

    private void showButton() {

        JFrame jf = new JFrame("Button");
        jf.setLayout(new GridLayout(R, R));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < R; i++) {
            final Lab6 l = new Lab6();
            jf.add(l);
//jf.add(jl);
        }
        jf.pack();
        jf.setLocationRelativeTo(null);

//jf.getColorModel();
//jf.show();
//jf.add();
        jf.setVisible(true);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Lab6().showButton();

            }
        });
    }
}
