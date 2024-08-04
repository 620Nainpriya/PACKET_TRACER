package network;

import java.awt.Dimension;
import javax.swing.*;

public class Gui extends JPanel {
    JTextArea jcomp1;
    JTextArea jcomp2;
    JTextArea jcomp3;
    JTextArea jcomp4;

    JButton jcomp9;
    JButton jcomp10;
    JTextField jcomp11;

    JComboBox<String> jcomp5;
    JComboBox<String> jcomp6;
    JComboBox<String> jcomp7;
    JComboBox<String> jcomp8;

    JTextField jcomp12;
    JButton jcomp13;
    JButton jcomp14;

    JRadioButton jcomp15;

    public Gui() {
        // Construct components
        jcomp1 = new JTextArea(5, 5);
        jcomp2 = new JTextArea(5, 5);
        jcomp3 = new JTextArea(5, 5);
        jcomp4 = new JTextArea(5, 5);
        jcomp9 = new JButton("Single Iteration");

        jcomp10 = new JButton("Update LINK");
        jcomp11 = new JTextField(1);

        jcomp12 = new JTextField(5);
        jcomp13 = new JButton("Iterations");
        jcomp14 = new JButton("Until Convergence");
        jcomp15 = new JRadioButton("Split-Horizon");

        // Adjust size and set layout
        setPreferredSize(new Dimension(944, 553));
        setLayout(null);

        // Add components
        add(jcomp1);
        add(jcomp2);
        add(jcomp3);
        add(jcomp4);
        add(jcomp9);
        add(jcomp10);
        add(jcomp11);
        add(jcomp12);
        add(jcomp13);
        add(jcomp14);
        add(jcomp15);

        // Set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(40, 295, 180, 235);
        jcomp2.setBounds(265, 295, 180, 235);
        jcomp3.setBounds(490, 295, 180, 235);
        jcomp4.setBounds(715, 295, 180, 235);
        jcomp9.setBounds(20, 25, 145, 40);
        jcomp10.setBounds(160, 100, 145, 30);
        jcomp11.setBounds(20, 100, 135, 30);
        jcomp12.setBounds(215, 25, 40, 40);
        jcomp13.setBounds(260, 25, 145, 40);
        jcomp14.setBounds(455, 25, 145, 40);
        jcomp15.setBounds(20, 160, 100, 50);
    }

    private void add(JButton jcomp92) {
		// TODO Auto-generated method stub
		
	}

	private void setLayout(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void updateDropDowns(int size) {
        String[] jcomp5Items = new String[size];

        for (int i = 0; i < size; i++) {
            jcomp5Items[i] = Integer.toString(i + 1);
        }

        if (jcomp5 != null) {
            remove(jcomp5);
            remove(jcomp6);
            remove(jcomp7);
            remove(jcomp8);
        }

        jcomp5 = new JComboBox<>(jcomp5Items);
        jcomp6 = new JComboBox<>(jcomp5Items);
        jcomp7 = new JComboBox<>(jcomp5Items);
        jcomp8 = new JComboBox<>(jcomp5Items);

        add(jcomp5);
        add(jcomp6);
        add(jcomp7);
        add(jcomp8);

        jcomp5.setBounds(40, 245, 175, 40);
        jcomp6.setBounds(265, 245, 175, 40);
        jcomp7.setBounds(490, 245, 175, 40);
        jcomp8.setBounds(715, 245, 175, 40);

        revalidate();
        repaint();
    }
}
